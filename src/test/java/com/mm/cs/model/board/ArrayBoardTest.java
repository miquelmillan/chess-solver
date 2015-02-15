package com.mm.cs.model.board;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import com.mm.cs.model.board.impl.ArrayBoard;

/**
 * Test of the ArrayBoard implementation. This test intends to cover
 * the common operations and the constructors
 * 
 * @author miquel.millan@gmail.com
 *
 */
public class ArrayBoardTest {

	@Test
	public void testConstructorOk() {
		Board board = new ArrayBoard(1, 1);
		assertNotNull(board);
	}

	@Test (expected=IllegalArgumentException.class)
	public void testConstructorKo() {
		Board board = new ArrayBoard(-1, -2);
		assertNotNull(board);
	}

	@Test
	public void testGetRow(){
		Board board = new ArrayBoard(5, 5);
		
		assertNotNull(board.getRow(0));
		assertNull(board.getRow(-1));
		assertEquals("length not properly retrieved", 5,board.getRow(0).length);
	}

	@Test
	public void testGetColumn(){
		Board board = new ArrayBoard(4, 3);
		
		assertNull(board.getColumn(-1));
		assertNotNull(board.getColumn(0)); 
		assertNotNull(board.getColumn(2));
		assertNull(board.getColumn(3));
		
		assertEquals("length not properly retrieved", 3, board.getRow(0).length);
	}
}
