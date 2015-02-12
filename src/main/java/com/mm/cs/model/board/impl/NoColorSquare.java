package com.mm.cs.model.board.impl;

import com.mm.cs.model.board.Square;
import com.mm.cs.model.piece.Piece;

public class NoColorSquare implements Square {
	private Piece piece;
	private boolean free;

	public NoColorSquare(Piece piece, boolean free) {
		this.piece = piece;
		this.free = free;
	}

	public Piece getPiece() {
		return piece;
	}

	public void setPiece(Piece piece) {
		this.piece = piece;
	}

	public boolean isFree() {
		return free;
	}

	public void setFree(boolean free) {
		this.free = free;
	}
}
