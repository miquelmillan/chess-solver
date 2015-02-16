package com.mm.cs.model.piece.impl;

import java.util.ArrayList;
import java.util.List;

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
	protected List<Square> movement(int row, int column){
		List<Square> result = new ArrayList<>();
		Square[] columnSquares = board.getColumn(column);
		Square[] rowSquares = board.getRow(row);
		
		//occupy the positions
		//1.- column
		for (Square square: columnSquares){
			result.add(square);
		}
		
		//2.- row
		for (Square square: rowSquares){
			result.add(square);
		}
		
		return result;
	}
	
	@Override
	public String toString(){
		return "R ";
	}
}
