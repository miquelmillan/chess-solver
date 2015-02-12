package com.mm.cs.model.board.impl;

import com.mm.cs.model.board.Board;
import com.mm.cs.model.board.Square;
import com.mm.cs.model.piece.Piece;

public class ArrayBoard implements Board {
	private NoColorSquare[][] board;
	private Piece[] pieces;
	
	public ArrayBoard(int rows, int columns, Piece ...pieces){
		//rows and columns check
		if (rows<0 || columns <0){
			throw new IllegalArgumentException("rows and columns values must be greater than 0");
		}
		
		board = new NoColorSquare[rows][columns];
		this.pieces = pieces;
	}

	@Override
	public Square[] getRow(int index) {
		//if index is greater than number of rows, return null
		return (index<board.length&&index>=0?board[index]:null);
	}

	@Override
	public Square[] getColumn(int index) {
		//if index is greater than number of columns, return null
		Square[] result = null;
		
		if (board != null && (index>=0 && index<board[0].length)){	
			result = new Square[board[0].length];
			for (int i=0;i<board[0].length;i++){
				result[i]=board[i][index];
			}
		}
		
		return result;
	}

	@Override
	public Square[][] getBoard() {
		return board;
	}
	
	public String toString(){
		return "";
	}
}
