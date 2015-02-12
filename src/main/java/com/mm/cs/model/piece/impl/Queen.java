package com.mm.cs.model.piece.impl;

import com.mm.cs.model.board.Board;
import com.mm.cs.model.board.Square;
import com.mm.cs.model.piece.Piece;

public class Queen implements Piece {
	private Board board;
	
	public Queen(Board board){
		this.board = board;
	}
	@Override
	public void moveTo(Board board, int row, int column) {
		//is the square free?
		if (this.board.getBoard()[row][column].isFree()){
			Square[][] boardArray = this.board.getBoard();
			Square[] columnSquares = board.getColumn(column);
			Square[] rowSquares = board.getColumn(row);

			//occupy the positions
			/*
			 ==>
			 x o x o x
			 o x x x o
			 x x X x x
			 o x x x o
			 x o x o x
			 
			 */
			//diagonals
			for (int i=0;i<boardArray[0].length;i++){
				int position = row - i;
				boardArray[row+position][i].setFree(false);
				boardArray[row-position][i].setFree(false);
			}
			
			for (Square square: columnSquares){
				square.setFree(false);
			}
			
			for (Square square: rowSquares){
				square.setFree(false);
			}
		}
	}
}
