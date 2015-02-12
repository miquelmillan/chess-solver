package com.mm.cs.model.board;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertEquals;


import org.junit.Test;

import com.mm.cs.model.board.impl.ArrayBoard;
import com.mm.cs.model.piece.Piece;

public class ArrayBoardTest {

	@Test
	public void testConstructorOk() {
		Board board = new ArrayBoard(1, 1, new Piece[1]);
		assertNotNull(board);
	}

	@Test (expected=IllegalArgumentException.class)
	public void testConstructorKo() {
		Board board = new ArrayBoard(-1, -2, new Piece[1]);
		assertNotNull(board);
	}

	@Test
	public void testGetRow(){
		Piece[] pieces = new Piece[5];
		Board board = new ArrayBoard(5, 5, pieces);
		
		assertNotNull(board.getRow(0));
		assertNull(board.getRow(-1));
		assertEquals("length not properly retrieved", 5,board.getRow(0).length);
	}

	@Test
	public void testGetColumn(){
		Piece[] pieces = new Piece[5];
		Board board = new ArrayBoard(4, 3, pieces);
		
		assertNull(board.getColumn(-1));
		assertNotNull(board.getColumn(0)); 
		assertNotNull(board.getColumn(2));
		assertNull(board.getColumn(3));
		
		assertEquals("length not properly retrieved", 3, board.getRow(0).length);
	}
}
