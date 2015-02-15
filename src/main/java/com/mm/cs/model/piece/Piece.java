package com.mm.cs.model.piece;

import com.mm.cs.model.board.Board;
import com.mm.cs.model.board.Square;

/**
 * Abstract class modelling a chess piece. A piece can move to a position or
 * remove from a position. Any inheriting class must provide the internals
 * of these movements.
 * 
 * @author miquel.millan@gmail.com
 * @version 1.0
 *
 */
public abstract class Piece {
	protected enum Movement {
		ATTACK,
		FREE
	};

	protected Board board;
	/**
	 * Constructor of a Piece. A board to interact to must be provided
	 * 
	 * @param <em>board</em> The board to interact to
	 * @throws IllegalArgumentException if the board is not a legal (not-null) value
	 */
	public Piece(Board board){
		if (board != null){
			this.board = board;
		} else {
			throw new IllegalArgumentException("Board must be defined");
		}
	}
		
	/**
	 * Operation to be done when moving a piece to a concrete position.
	 * Normally such position would be occupied by the piece, and its
	 * attacking zones too.
	 * 
	 * @param <em>row</em> the row to move to
	 * @param <em>column</em> the column to move to
	 */
	public void moveTo(int row, int column) {
		//is the square free?
		if (this.board.getBoard()[row][column].isFree()){
			Square[][] boardArray = this.board.getBoard();
			
			//1.- piece position
			boardArray[row][column].setPiece(this);
			//2.- perform the movement
			this.movement(row, column, Movement.ATTACK);
		}
	}
	
	/**
	 * Operation to be done when removing a piece from a concrete position.
	 * Normally such position would be freed by the piece, and its
	 * attacking zones too.
	 * 
	 * @param <em>row</em> the row to remove from
	 * @param <em>column</em> the column to remove from
	 */
	public void removeFrom(int row, int column) {
		//is the square free?
		if (!this.board.getBoard()[row][column].isFree()){
			Square[][] boardArray = this.board.getBoard();
			
			//1.- piece position
			boardArray[row][column].setPiece(null);
			//2.- perform the movement
			this.movement(row, column, Movement.FREE);
		}
	}
	
	/**
	 * Operation to be done in case a position of the board
	 * has to be modified. The position will be modified depending on the
	 * operation done.
	 * 
	 * @param <em>square</em> The position to be modified
	 * @param <em>move</em> The move performed
	 */
	protected void modifyPosition(Square square, Movement move){
		switch (move) {
		case ATTACK:
			square.increaseOccupation();
			break;
		case FREE:
			square.decreaseOccupation();
			break;
		}
		
	}
	/**
	 * Operation to be implemented by any concrete class inheriting from Piece.
	 * This operation models the "area of influence" of the concrete piece.
	 * 
	 * @param <em>row</em> The row to move to or remove from
	 * @param <em>column</em> The column to move to or remove from
	 * @param <em>move</em> The movement performed
	 */
	protected abstract void movement(int row, int column, Movement move);

}
