package com.mm.cs.model.board;

import com.mm.cs.model.piece.Piece;

public interface Square {
	public Piece getPiece();
	public boolean isFree();
	public void setFree(boolean free);
}
