package com.mm.cs.model.piece;

import com.mm.cs.model.board.Board;

public interface Piece {
	public void moveTo(Board board, int row, int column);
}
