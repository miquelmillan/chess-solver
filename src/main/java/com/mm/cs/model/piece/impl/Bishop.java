package com.mm.cs.model.piece.impl;

import java.util.ArrayList;
import java.util.List;

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
	protected List<Square> movement(int row, int column){
		List<Square> result = new ArrayList<>();
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
					result.add(boardArray[bottomRow][preColumn]);
				}
			}
			if (bottomRow >= 0 && bottomRow < boardArray.length) {
				if (postColumn >= 0 && postColumn < boardArray[0].length) {
					result.add(boardArray[bottomRow][postColumn]);
				}
			}
			if (upperRow >= 0 && upperRow < boardArray.length) {
				if (preColumn >= 0 && preColumn < boardArray[0].length) {
					result.add(boardArray[upperRow][preColumn]);
				}
			}
			if (upperRow >= 0 && upperRow < boardArray.length) {
				if (postColumn >= 0 && postColumn < boardArray[0].length) {
					result.add(boardArray[upperRow][postColumn]);
				}
			}
		}
		return result;
	}
	
	@Override
	public String toString(){
		return "B ";
	}
}
