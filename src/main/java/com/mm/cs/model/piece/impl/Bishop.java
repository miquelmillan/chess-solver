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
public class Bishop extends Piece {

	public Bishop(Board board){
		super(board);
	}
	
	
	@Override
	protected void movement(int row, int column, Movement move){
		Square[][] boardArray = this.board.getBoard();
		int bottomRow = 0;
		int upperRow = 0;
		int postColumn = 0;
		int preColumn = 0;
		
		//occupy the positions:
		//1.- diagonals
		for (int i=0;i<boardArray[0].length;i++){
			bottomRow = row + i;
			upperRow = row - i;
			postColumn = column + i;
			preColumn = column - i;
			
			if (bottomRow >= 0 && bottomRow < boardArray.length) {
				if (preColumn >= 0 && preColumn < boardArray[0].length) {
					this.modifyPosition(boardArray[bottomRow][preColumn], move);
				}
			}
			if (bottomRow >= 0 && bottomRow < boardArray.length) {
				if (postColumn >= 0 && postColumn < boardArray[0].length) {
					this.modifyPosition(boardArray[bottomRow][postColumn], move);
				}
			}
			if (upperRow >= 0 && upperRow < boardArray.length) {
				if (preColumn >= 0 && preColumn < boardArray[0].length) {
					this.modifyPosition(boardArray[upperRow][preColumn], move);
				}
			}
			if (upperRow >= 0 && upperRow < boardArray.length) {
				if (postColumn >= 0 && postColumn < boardArray[0].length) {
					this.modifyPosition(boardArray[upperRow][postColumn], move);
				}
			}
		}
	}
	
	@Override
	public String toString(){
		return "B ";
	}
}
