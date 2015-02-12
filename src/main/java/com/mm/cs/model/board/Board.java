package com.mm.cs.model.board;


public interface Board {
	public Square[] getRow(int index);
	public Square[] getColumn(int index);
	public Square[][] getBoard();
}
