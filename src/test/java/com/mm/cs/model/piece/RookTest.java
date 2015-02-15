package com.mm.cs.model.piece;

import org.junit.Test;

import static org.junit.Assert.*;

import com.mm.cs.model.board.Board;
import com.mm.cs.model.board.impl.ArrayBoard;
import com.mm.cs.model.piece.impl.Rook;

/**
 * Test case of the Rook piece. This test covers the constructor,
 * a positioning in the middle of the board, the positioning on
 * the four edges of the board and error conditions
 * 
 * @author miquel.millan@gmail.com
 * @version 1.0
 *
 */
public class RookTest {
	
	@Test
	public void testConstructor() {
		Board board = new ArrayBoard(5, 5);
		Piece rook = new Rook(board);
		assertNotNull(rook);
	}
	@Test
	public void testMiddlePosition() {
		String boardConfiguration= 
				   "o o x o o "
				 + "o o x o o "
				 + "x x R x x "
				 + "o o x o o "
				 + "o o x o o ";	
				
				
		Board board = new ArrayBoard(5, 5);
		Piece rook = new Rook(board);
		rook.moveTo(board, 2, 2);
		assertEquals(boardConfiguration, board.toString().replace(System.lineSeparator(), ""));
	}

	@Test
	public void testUpperLeftPosition() {
		String boardConfiguration= 
				   "R x x x x "
				 + "x o o o o "
				 + "x o o o o "
				 + "x o o o o "
				 + "x o o o o ";	
				
				
		Board board = new ArrayBoard(5, 5);
		Piece rook = new Rook(board);
		rook.moveTo(board, 0, 0);
		assertEquals(boardConfiguration, board.toString().replace(System.lineSeparator(), ""));
	}
	
	@Test
	public void testUpperRightPosition() {
		String boardConfiguration= 
				  "x x x x R "
				+ "o o o o x "
				+ "o o o o x "
				+ "o o o o x "
				+ "o o o o x ";
				
				
		Board board = new ArrayBoard(5, 5);
		Piece rook = new Rook(board);
		rook.moveTo(board, 0, 4);
		assertEquals(boardConfiguration, board.toString().replace(System.lineSeparator(), ""));
	}

	@Test
	public void testBottomLeftPosition() {
		String boardConfiguration= 
				  "x o o o o "
				+ "x o o o o "
				+ "x o o o o "
				+ "x o o o o "
				+ "R x x x x ";

		Board board = new ArrayBoard(5, 5);
		Piece rook = new Rook(board);
		rook.moveTo(board, 4, 0);
		assertEquals(boardConfiguration, board.toString().replace(System.lineSeparator(), ""));
	}
	
	@Test
	public void testBottomRightPosition() {
		String boardConfiguration= 
		  		   "o o o o x "
				 + "o o o o x "
				 + "o o o o x "
				 + "o o o o x "
				 + "x x x x R ";
				
		Board board = new ArrayBoard(5, 5);
		Piece rook = new Rook(board);
		rook.moveTo(board, 4, 4);
		assertEquals(boardConfiguration, board.toString().replace(System.lineSeparator(), ""));
	}
	
	@Test (expected=IndexOutOfBoundsException.class)
	public void testOutBoardPosition() {			
		Board board = new ArrayBoard(5, 5);
		Piece rook = new Rook(board);
		rook.moveTo(board, 5, 5);
	}
	
	@Test (expected=IndexOutOfBoundsException.class)
	public void testNegativeBoardPosition() {			
		Board board = new ArrayBoard(5, 5);
		Piece rook = new Rook(board);
		rook.moveTo(board, -1, 1);
	}
}
