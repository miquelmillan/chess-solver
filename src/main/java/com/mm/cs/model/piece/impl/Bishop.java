package com.mm.cs.model.piece.impl;

import com.mm.cs.model.board.Board;
import com.mm.cs.model.board.Square;
import com.mm.cs.model.piece.Piece;
/**
 * Piece implementation according to the rules of a Bishop piece:
 * x o o o x
 * o x o x o
 * o o X o o
 * o x o x o
 * x o o o x
 * 
 * @author miquel.millan@gmail.com
 * @version 1.0
 *
 */
public class Bishop implements Piece {
	private Board board;
	
	public Bishop(Board board){
		this.board = board;
	}
	@Override
	public void moveTo(Board board, int row, int column) {
		//is the square free?
		if (this.board.getBoard()[row][column].isFree()){
			Square[][] boardArray = this.board.getBoard();
			int bottomRow = 0;
			int upperRow = 0;
			int postColumn = 0;
			int preColumn = 0;
			//occupy the positions:
			//1.- piece position
			boardArray[row][column].setPiece(this);

			//2.- diagonals
			for (int i=0;i<boardArray[0].length;i++){
				bottomRow = row + i;
				upperRow = row - i;
				postColumn = column + i;
				preColumn = column - i;
				
				if (bottomRow >= 0 && bottomRow < boardArray.length) {
					if (preColumn >= 0 && preColumn < boardArray[0].length) {
						boardArray[bottomRow][preColumn].increaseOccupation();
					}
				}
				if (bottomRow >= 0 && bottomRow < boardArray.length) {
					if (postColumn >= 0 && postColumn < boardArray[0].length) {
						boardArray[bottomRow][postColumn].increaseOccupation();
					}
				}
				if (upperRow >= 0 && upperRow < boardArray.length) {
					if (preColumn >= 0 && preColumn < boardArray[0].length) {
						boardArray[upperRow][preColumn].increaseOccupation();
					}
				}
				if (upperRow >= 0 && upperRow < boardArray.length) {
					if (postColumn >= 0 && postColumn < boardArray[0].length) {
						boardArray[upperRow][postColumn].increaseOccupation();
					}
				}
			}
		}
	}
	
	@Override
	public String toString(){
		return "B ";
	}
}
