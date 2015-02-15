package com.mm.cs.model.piece.impl;

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
	protected void movement(int row, int column, Movement move){
		Square[][] boardArray = this.board.getBoard();
		
		//1.- circle piece
		for (int i=column-1;i<=column+1;i++){
			for (int j=row-1;j<=row+1;j++){
				if ((i>=0 && j>=0) && 
					(i<boardArray[0].length && j<boardArray.length))
				{
					this.modifyPosition(boardArray[j][i], move);
				}
					
			}
		}
	}

	@Override
	public String toString(){
		return "K ";
	}
}
