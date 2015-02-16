package com.mm.cs.model.piece;

import java.util.List;

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
	 * @return True if it has been possible to move the piece, otherwise false
	 */
	public boolean moveTo(int row, int column) {
		boolean result = false;
		//is the square free?
		if (this.board.isValidPosition(row, column)){
			List<Square> positions = this.movement(row, column);
			
			if (testPosition(positions) 
					&& this.board.getBoard()[row][column].isFree()){
				Square[][] boardArray = this.board.getBoard();
				
				//1.- piece position
				boardArray[row][column].setPiece(this);
				//2.- perform the movement
				for (Square square: positions){
					modifyPosition(square, Movement.ATTACK);
				}
				
				result = true;
			}
		}
		return result;
	}
	
	/**
	 * Operation to be done when removing a piece from a concrete position.
	 * Normally such position would be freed by the piece, and its
	 * attacking zones too.
	 * 
	 * @param <em>row</em> the row to remove from
	 * @param <em>column</em> the column to remove from
	 * @return True if it has been possible to remove the piece, otherwise false
	 */
	public boolean removeFrom(int row, int column) {
		boolean result = false;
		
		if (board.isValidPosition(row, column)){
			//is the square free?
			List<Square> positions = this.movement(row, column);
			
			if (	this.board.isValidPosition(row, column)
					&& !this.board.getBoard()[row][column].isFree()){
				Square[][] boardArray = this.board.getBoard();
				
				//1.- piece position
				boardArray[row][column].setPiece(null);
				//2.- perform the movement
				for (Square square: positions){
					modifyPosition(square, Movement.FREE);
				}
				
				result = true;
			}
		}
		
		return result;
	}
	
	/**
	 * Operation to be done when moving a piece to a concrete position.
	 * It is used to test if the movement is legal
	 * 
	 * @param <em>row</em> the row to remove from
	 * @param <em>column</em> the column to remove from
 	 * @return True if the position isn't occupied or will occupy other pieces in the board, otherwise false
	 */
	private boolean testPosition(List<Square> positions) {
		boolean result = true;

		//1.- analyze if they are free or not
		for (Square square: positions){
			if (square.getPiece()!=null){
				result = false;
				break;
			}
		}
		
		return result;
	}
	
	
	/**
	 * Operation to be done in case a position of the board
	 * has to be modified. The position will be modified depending on the
	 * operation done.
	 * 
	 * @param <em>square</em> The position to be modified
	 * @param <em>move</em> The move performed
	 * @return true if the operation has been possible otherwise false
	 */
	protected boolean modifyPosition(Square square, Movement move){
		boolean result = true;
		switch (move) {
		case ATTACK:
			square.increaseOccupation();
			break;
		case FREE:
			square.decreaseOccupation();
			break;
		}
		return result;
	}
	/**
	 * Operation to be implemented by any concrete class inheriting from Piece.
	 * This operation models the "area of influence" of the concrete piece.
	 * 
	 * @param <em>row</em> The row to move to or remove from
	 * @param <em>column</em> The column to move to or remove from
	 * @param <em>move</em> The movement performed
	 */
	protected abstract List<Square> movement(int row, int column);

}
