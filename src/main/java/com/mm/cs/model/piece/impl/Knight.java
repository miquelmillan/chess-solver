package com.mm.cs.model.piece.impl;

import com.mm.cs.model.board.Board;
import com.mm.cs.model.board.Square;
import com.mm.cs.model.piece.Piece;
/**
 * Piece implementation according to the rules of a Knight piece:
 * o x o x o
 * x o o o x
 * o o X o o
 * x o o o x
 * o x o x o 
 * 
 * @author miquel.millan@gmail.com
 * @version 1.0
 *
 */
public class Knight implements Piece {
	private Board board;
	
	public Knight(Board board){
		this.board = board;
	}
	
	@Override
	public void moveTo(Board board, int row, int column) {
		//is the square free?
		if (this.board.getBoard()[row][column].isFree()){
			Square[][] boardArray = this.board.getBoard();
			//Variables to calculate the L movements
			int [][] signs = {{-1,-1},{-1,1},{1,-1},{1,1}};
			int [] twoColumnsL = new int[2];
			int [] twoRowsL = new int[2];
			//occupy the positions
			//1.- piece position
			boardArray[row][column].setPiece(this);
			
			//2.- L positions
			// 4 times (changing signs):
			// 1 row 2 columns
			// 2 rows 1 column
			
			for (int i=0;i<4;i++){
				//2 columns L
				twoColumnsL[0] = row + signs[i][0];
				twoColumnsL[1] = column + signs[i][1]*2;
				if ((twoColumnsL[0]>=0 && twoColumnsL[0]<boardArray.length) && 
					((twoColumnsL[1]>=0 && twoColumnsL[1]<boardArray[0].length))) {	
					boardArray[twoColumnsL[0]][twoColumnsL[1]].increaseOccupation();
				}

				//2 rows L
				twoRowsL[0]=row + signs[i][0]*2;
				twoRowsL[1]=column + signs[i][1];
				if ((twoRowsL[0]>=0 && twoRowsL[0]<boardArray.length) && 
						((twoRowsL[1]>=0 && twoRowsL[1]<boardArray[0].length))) {	
					boardArray[twoRowsL[0]][twoRowsL[1]].increaseOccupation();
				}
			}
		}
	}

	@Override
	public String toString(){
		return "N ";
	}
}
