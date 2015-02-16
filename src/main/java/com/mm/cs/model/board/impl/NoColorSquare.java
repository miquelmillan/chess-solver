package com.mm.cs.model.board.impl;

import com.mm.cs.model.board.Square;
import com.mm.cs.model.piece.Piece;
/**
 * Implementation of the Square interface. It represents a Square
 * with no color.
 * 
 * @author miquel.millan@gmail.com
 * @version 1.0
 *
 */
public class NoColorSquare implements Square {
	//Values for the default constructor
	private Piece piece = null;
	private int occupation = 0;

	public Piece getPiece() {
		return piece;
	}

	public void setPiece(Piece piece) {
		this.piece = piece;
	}

	public void increaseOccupation() {
		occupation++;
	}

	public void decreaseOccupation() {
		occupation = (occupation > 0 ? occupation - 1 : 0);
	}

	public int getOccupation() {
		return occupation;
	}
	
	public boolean isFree(){
		boolean result = false;
		if (occupation == 0){
			result = true;
		}
		return result;
	}
}