package com.mm.cs.model.piece.impl;

import java.util.ArrayList;
import java.util.List;

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
public class Knight extends Piece {
	
	public Knight(Board board){
		super(board);
	}
	
	@Override
	protected List<Square> movement(int row, int column){
		List<Square> result = new ArrayList<>();
		Square[][] boardArray = this.board.getBoard();
		//Variables to calculate the L movements
		int [][] signs = {{-1,-1},{-1,1},{1,-1},{1,1}};
		int [] twoColumnsL = new int[2];
		int [] twoRowsL = new int[2];
		
		//occupy the positions
		//1.- piece position
		result.add(boardArray[row][column]);
		
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
				result.add(boardArray[twoColumnsL[0]][twoColumnsL[1]]);
			}
			
			//2 rows L
			twoRowsL[0]=row + signs[i][0]*2;
			twoRowsL[1]=column + signs[i][1];
			if ((twoRowsL[0]>=0 && twoRowsL[0]<boardArray.length) && 
					((twoRowsL[1]>=0 && twoRowsL[1]<boardArray[0].length))) {	
				result.add(boardArray[twoRowsL[0]][twoRowsL[1]]);
			}
		}
		
		return result;
	}
	
	@Override
	public String toString(){
		return "N ";
	}
}
