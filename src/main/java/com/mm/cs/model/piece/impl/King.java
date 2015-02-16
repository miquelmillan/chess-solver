package com.mm.cs.model.piece.impl;

import java.util.ArrayList;
import java.util.List;

import com.mm.cs.model.board.Board;
import com.mm.cs.model.board.Square;
import com.mm.cs.model.piece.Piece;
/**
 * Piece implementation according to the rules of a King piece:
 * o o o o o
 * o x x x o
 * o x X x o
 * o x x x o
 * o o o o o
 * 
 * @author miquel.millan@gmail.com
 * @version 1.0
 *
 */
public class King extends Piece {

	public King(Board board){
		super(board);
	}
	@Override
	protected List<Square> movement(int row, int column){
		List<Square> result = new ArrayList<>();
		Square[][] boardArray = this.board.getBoard();
		
		//1.- circle piece
		for (int i=column-1;i<=column+1;i++){
			for (int j=row-1;j<=row+1;j++){
				if ((i>=0 && j>=0) && 
					(i<boardArray[0].length && j<boardArray.length))
				{
					result.add(boardArray[j][i]);
				}
					
			}
		}
		
		return result;
	}

	@Override
	public String toString(){
		return "K ";
	}
}
