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
public class Rook extends Piece {
	
	public Rook(Board board){
		super(board);
	}

	@Override
	protected void movement(int row, int column, Movement move){
		Square[] columnSquares = board.getColumn(column);
		Square[] rowSquares = board.getRow(row);
		
		//occupy the positions
		//1.- column
		for (Square square: columnSquares){
			this.modifyPosition(square, move);
		}
		
		//2.- row
		for (Square square: rowSquares){
			this.modifyPosition(square, move);
		}
	}
	
	@Override
	public String toString(){
		return "R ";
	}
}
