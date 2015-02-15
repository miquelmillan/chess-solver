package com.mm.cs.model.board;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import com.mm.cs.model.board.impl.ArrayBoard;
import com.mm.cs.model.piece.Piece;
import com.mm.cs.model.piece.impl.Bishop;
import com.mm.cs.model.piece.impl.King;
import com.mm.cs.model.piece.impl.Knight;
import com.mm.cs.model.piece.impl.Queen;
import com.mm.cs.model.piece.impl.Rook;

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
	
	@Test
	public void testGetFirstFreePosition(){
		/*
		 "x o o o x "
		 "o x o x o "
		 "o o B o o "
		 "o x o x o "
		 "x o o o x "
		*/
		
		Board board = new ArrayBoard(5, 5);
		Piece bishop = new Bishop(board);
		bishop.moveTo(2, 2);
		
		int[] freePosition = board.getFirstFreePosition();
		
		assertEquals(0, freePosition[0]);
		assertEquals(1, freePosition[1]);
		
		/*
		 "x Q x x x "
		 "x x x x o "
		 "o x B x o "
		 "o x o x x "
		 "x x o o x "
		*/
		
		Piece queen = new Queen(board);
		queen.moveTo(0, 1);
		
		freePosition = board.getFirstFreePosition();
		
		assertEquals(1, freePosition[0]);
		assertEquals(4, freePosition[1]);
		
		/*
		 "x Q x x x "
		 "x x x x o "
		 "o x B x o "
		 "x x o x x "
		 "x x K o x "
		*/
		
		Piece knight = new Knight(board);
		knight.moveTo(4, 2);
		
		freePosition = board.getFirstFreePosition();
		
		assertEquals(1, freePosition[0]);
		assertEquals(4, freePosition[1]);
		
		/*
		 "x Q x x x "
		 "x x x x K "
		 "o x B x x "
		 "x x o x x "
		 "x x K o x "
		*/
		
		Piece king = new King(board);
		king.moveTo(1, 4);
		
		freePosition = board.getFirstFreePosition();
		
		assertEquals(2, freePosition[0]);
		assertEquals(0, freePosition[1]);
		
		/*
		 "x Q x x x "
		 "x x x x K "
		 "R x B x x "
		 "x x o x x "
		 "x x K o x "
		*/
		
		Piece rook = new Rook(board);
		rook.moveTo(2, 0);
		
		freePosition = board.getFirstFreePosition();
		
		assertEquals(3, freePosition[0]);
		assertEquals(2, freePosition[1]);
		
		/*
		 "x Q x x x "
		 "x x x x K "
		 "R x B x x "
		 "x x Q x x "
		 "x x K x x "
		*/
		
		Piece queen2 = new Queen(board);
		queen2.moveTo(3, 2);
		
		freePosition = board.getFirstFreePosition();
		
		assertEquals(null, freePosition);
		
		/*
		 "x Q x x x "
		 "x x x x K "
		 "R x B x x "
		 "x x o x x "
		 "x x K o x "
		*/
		
		queen2.removeFrom(3, 2);
		
		freePosition = board.getFirstFreePosition();
		
		assertEquals(3, freePosition[0]);
		assertEquals(2, freePosition[1]);
	}
}
