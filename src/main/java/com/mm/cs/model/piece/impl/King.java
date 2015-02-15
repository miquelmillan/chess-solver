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
public class King implements Piece {
	private Board board;
	
	public King(Board board){
		this.board = board;
	}
	@Override
	public void moveTo(Board board, int row, int column) {
		//is the square free?
		if (this.board.getBoard()[row][column].isFree()){
			Square[][] boardArray = this.board.getBoard();
			//occupy the positions
			//1.- piece position
			boardArray[row][column].setPiece(this);
			//2.- circle piece
			for (int i=column-1;i<=column+1;i++){
				for (int j=row-1;j<=row+1;j++){
					if ((i>=0 && j>=0) && 
						(i<boardArray[0].length && j<boardArray.length))
					{
						boardArray[j][i].increaseOccupation();
					}
						
				}
			}
		}
	}
	
	@Override
	public String toString(){
		return "K ";
	}
}
