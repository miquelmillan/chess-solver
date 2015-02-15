package com.mm.cs.logic;

import java.util.Set;
/**
 * Interface contract to be implemented by the different chess problem algorithm solutions.
 * 
 * @author miquel.millan@gmail.com
 * @version 1.0
 *
 */
public interface ChessSolverLogic {
	/**
	 * Solves the problem of the board configurations given a number of rows, columns and
	 * pieces.
	 * 
	 * @param <em>rows</em> The board number of rows
	 * @param <em>columns</em> The board number of columns
	 * @param <em>knights</em> The number of knights to be placed
	 * @param <em>rooks</em> the number of rooks to be placed
	 * @param <em>bishops</em> the number of bishops to be placed
	 * @param <em>queens</em> the number of queens to be placed
	 * @param <em>kings</em> the number of kings to be placed
	 * 
	 * @return A list with the different board configurations
	 */
	public Set<String> solveChessBoard( int rows, int columns, int knights, 
										int rooks, int bishops,
										int queens, int kings);
}
