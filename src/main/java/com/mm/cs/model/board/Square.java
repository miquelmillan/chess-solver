package com.mm.cs.model.board;

import com.mm.cs.model.piece.Piece;

/**
 * Contract interface for the OO chess board position representation.
 * Any square implementation must provide the following methods in order
 * to be properly used.
 * 
 * @author miquel.millan@gmail.com
 * @version 1.0
 *
 */
public interface Square {
	/**
	 * Places a piece in this Square
	 * 
	 * @param <em>piece</em>
	 */
	public void setPiece(Piece piece);
	/**
	 * Returns the piece placed in this square. If no piece is placed
	 * returns null
	 * 
	 * @return the Piece in this Square or null if no piece is placed
	 */
	public Piece getPiece();
	/**
	 * Returns the occupation of this Square. The occupation represents
	 * the number of pieces which can attack this Square
	 * 
	 * @return the current occupation. If no occupation, then returns 0
	 */
	public int getOccupation();
	/**
	 * Increases the occupation index of this Square.
	 * 
	 */
	public void increaseOccupation();
	/**
	 * Decresases the occupation index of this Square. In case the occupation is 0
	 * it must not be decreased
	 */
	public void decreaseOccupation();
	/**
	 * Returns if the current position is occupied or not. It is occupied if
	 * if the occupation index is greater than 0.
	 * 
	 * @return if the current position is occupied
	 */
	public boolean isFree();
}
