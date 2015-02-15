package com.mm.cs.model.piece;

import com.mm.cs.model.board.Board;
/**
 * Interface contract for a chess piece. Any piece must provide
 * operations to move it to a concrete location of the board and
 * occupy it and its corresponding attack zones.
 * 
 * @author miquel.millan@gmail.com
 * @version 1.0
 *
 */
public interface Piece {
	public void moveTo(Board board, int row, int column);
}
