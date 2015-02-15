package com.mm.cs.model.piece.impl;

import com.mm.cs.model.board.Board;
import com.mm.cs.model.board.Square;
import com.mm.cs.model.piece.Piece;
/**
 * Piece implementation according to the rules of a Queen piece:
 * o o x o o
 * o o x o o
 * x x X x x
 * o o x o o
 * o o x o o
 * 
 * @author miquel.millan@gmail.com
 * @version 1.0
 *
 */
public class Rook implements Piece {
	private Board board;
	
	public Rook(Board board){
		if (board != null){
			this.board = board;
		} else {
			throw new IllegalArgumentException("Board must be defined");
		}
	}
	@Override
	public void moveTo(Board board, int row, int column) {
		//is the square free?
		if (this.board.getBoard()[row][column].isFree()){
			Square[][] boardArray = this.board.getBoard();
			Square[] columnSquares = board.getColumn(column);
			Square[] rowSquares = board.getRow(row);

			//occupy the positions
			//1.- position
			boardArray[row][column].setPiece(this);
			
			//2.- column
			for (Square square: columnSquares){
				square.increaseOccupation();
			}
			
			//3.- row
			for (Square square: rowSquares){
				square.increaseOccupation();
			}
		}
	}
	
	@Override
	public String toString(){
		return "R ";
	}
}
