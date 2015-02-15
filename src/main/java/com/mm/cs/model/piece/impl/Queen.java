package com.mm.cs.model.piece.impl;

import com.mm.cs.model.board.Board;
import com.mm.cs.model.board.Square;
import com.mm.cs.model.piece.Piece;
/**
 * Piece implementation according to the rules of a Queen piece:
 * x o x o x
 * o x x x o
 * x x X x x
 * o x x x o
 * x o x o x
 * 
 * @author miquel.millan@gmail.com
 * @version 1.0
 *
 */
public class Queen extends Piece {
	
	public Queen(Board board){
		super(board);
	}
	@Override
	protected void movement(int row, int column, Movement move){
		Square[][] boardArray = this.board.getBoard();
		Square[] columnSquares = board.getColumn(column);
		Square[] rowSquares = board.getRow(row);
		
		int bottomRow = 0;
		int upperRow = 0;
		int postColumn = 0;
		int preColumn = 0;
			
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
		
		//2.- column
		for (Square square: columnSquares){
			this.modifyPosition(square, move);
		}
		
		//3.- row
		for (Square square: rowSquares){
			this.modifyPosition(square, move);
		}
	}
	@Override
	public String toString(){
		return "Q ";
	}
}
