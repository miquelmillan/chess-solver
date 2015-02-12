package com.mm.cs.model.piece.impl;

import com.mm.cs.model.board.Board;
import com.mm.cs.model.board.Square;
import com.mm.cs.model.piece.Piece;

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
			//occupy the positions
			/*
			 ==>
			 x o o o x
			 o x o x o
			 o o X o o
			 o x o x o
			 x o o o x
			 
			 */
			for (int i=0;i<boardArray[0].length;i++){
				int position = row - i;
				boardArray[row+position][i].setFree(false);
				boardArray[row-position][i].setFree(false);
			}
		}
	}
}
