package com.mm.cs.model.board.impl;

import com.mm.cs.model.board.Board;
import com.mm.cs.model.board.Square;

/**
 * Board implementation using an array to represent the board.
 * 
 * @author miquel.millan@gmail.com
 * @version 1.0
 */
public class ArrayBoard implements Board {
	private Square[][] board;
	/**
	 * Constructor of the array board. It is mandatory to define
	 * the board sizes. If the sizes aren't defined it will throw an
	 * IllegalArgumentException
	 * 
	 * @param rows the number of rows of the board
	 * @param columns the number of columns of the board
	 */
	public ArrayBoard(int rows, int columns){
		//rows and columns check
		if (rows<0 || columns <0){
			throw new IllegalArgumentException("rows and columns values must be greater than 0");
		}
		
		board = new NoColorSquare[rows][columns];
		
		for (int i=0;i<rows;i++){
			board[i] = new NoColorSquare[columns];
			for (int j=0;j<columns;j++){
				board[i][j] = new NoColorSquare();
			}
		}
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
	
	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		for (int i=0;i<board.length;i++){
			for (int j=0;j<board[i].length;j++){
				if (board[i][j].getPiece() != null){
					sb.append(board[i][j].getPiece());					
				} else {
					if (board[i][j].isFree()){
						sb.append("o ");
					} else {
						sb.append("x ");
					}
				}
			}
			sb.append(System.lineSeparator());
		}
		
		return sb.toString();
	}
}
