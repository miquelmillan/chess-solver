package com.mm.cs.model.board;

import java.util.List;

/**
 * Contract interface for the OO chess board implementations.
 * It gives operations to quickly access to the board position or to have
 * free access to all of them
 * 
 * 
 * @author miquel.millan@gmail.com
 * @version 1.0
 */

public interface Board {
	
	/**
	 * Returns a board row by passing its index. If the row does not exists
	 * returns null
	 * @param <em>index</em> the row index
	 * @return the row or null if it does not exist
	 */
	public Square[] getRow(int index);
	/**
	 * Returns a board column by passing its index. If the column does not exists
	 * returns null
	 * @param <em>index</em> the column index
	 * @return the column or null if it does not exist
	 */
	public Square[] getColumn(int index);

	
	/**
	 * Returns an array representing the board. It can be used to freely
	 * access any position of the board
	 * 
	 * @return a representation of the board in form array
	 */
	public Square[][] getBoard();

	/**
	 * Returns the first free position of this board. Its up to the concrete implementation
	 * how to find it, but the operation must return the same position if this operation
	 * is called twice and the board has not been modified.
	 * 
	 * @return the First free position or null if no position is free.
	 */
	public int[] getFirstFreePosition();
	
	/**
	 * Returns a list with the free positions of the board.
	 * 
	 * @return the array of the free positions or null if no position is free.
	 */
	public List<int[]> getFreePositions();
	
	/**
	 * Determines if the passed coordinates are into the board or outside it
	 * @param <em>row</em> the row of the position
	 * @param <em>column</em> the column of the position
	 * @return True if the position is valid (inside the board), otherwise false
	 */
	public boolean isValidPosition(int row, int column);
}
