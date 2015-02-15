package com.mm.cs.model.piece;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.mm.cs.model.board.Board;
import com.mm.cs.model.board.impl.ArrayBoard;
import com.mm.cs.model.piece.impl.Queen;

/**
 * Test case of the Queen piece. This test covers the constructor,
 * a positioning in the middle of the board, the positioning on
 * the four edges of the board and error conditions
 * 
 * @author miquel.millan@gmail.com
 * @version 1.0
 *
 */
public class QueenTest {
	String cleanBoardConfiguration= 
			   "o o o o o "
			 + "o o o o o "
			 + "o o o o o "
			 + "o o o o o "
			 + "o o o o o ";	
	@Test
	public void testConstructor() {
		Board board = new ArrayBoard(5, 5);
		Piece queen = new Queen(board);
		assertNotNull(queen);
	}
	@Test
	public void testMiddlePosition() {
		String boardConfiguration= 
				   "x o x o x "
				 + "o x x x o "
				 + "x x Q x x "
				 + "o x x x o "
				 + "x o x o x ";	
				
				
		Board board = new ArrayBoard(5, 5);
		Piece queen = new Queen(board);
		queen.moveTo(2, 2);
		assertEquals(boardConfiguration, board.toString().replace(System.lineSeparator(), ""));
		queen.removeFrom(2, 2);
		assertEquals(cleanBoardConfiguration, board.toString().replace(System.lineSeparator(), ""));
	}

	@Test
	public void testUpperLeftPosition() {
		String boardConfiguration= 
				   "Q x x x x "
				 + "x x o o o "
				 + "x o x o o "
				 + "x o o x o "
				 + "x o o o x ";	
				
				
		Board board = new ArrayBoard(5, 5);
		Piece queen = new Queen(board);
		queen.moveTo(0, 0);
		assertEquals(boardConfiguration, board.toString().replace(System.lineSeparator(), ""));
		queen.removeFrom(0, 0);
		assertEquals(cleanBoardConfiguration, board.toString().replace(System.lineSeparator(), ""));
	}
	
	@Test
	public void testUpperRightPosition() {
		String boardConfiguration= 
				  "x x x x Q "
				+ "o o o x x "
				+ "o o x o x "
				+ "o x o o x "
				+ "x o o o x ";
				
				
		Board board = new ArrayBoard(5, 5);
		Piece queen = new Queen(board);
		queen.moveTo(0, 4);
		assertEquals(boardConfiguration, board.toString().replace(System.lineSeparator(), ""));
		queen.removeFrom(0, 4);
		assertEquals(cleanBoardConfiguration, board.toString().replace(System.lineSeparator(), ""));
	}

	@Test
	public void testBottomLeftPosition() {
		String boardConfiguration= 
				  "x o o o x "
				+ "x o o x o "
				+ "x o x o o "
				+ "x x o o o "
				+ "Q x x x x ";

		Board board = new ArrayBoard(5, 5);
		Piece queen = new Queen(board);
		queen.moveTo(4, 0);
		assertEquals(boardConfiguration, board.toString().replace(System.lineSeparator(), ""));
		queen.removeFrom(4, 0);
		assertEquals(cleanBoardConfiguration, board.toString().replace(System.lineSeparator(), ""));
	}	
	
	@Test
	public void testBottomRightPosition() {
		String boardConfiguration= 
		  		   "x o o o x "
				 + "o x o o x "
				 + "o o x o x "
				 + "o o o x x "
				 + "x x x x Q ";
				
		Board board = new ArrayBoard(5, 5);
		Piece queen = new Queen(board);
		queen.moveTo(4, 4);
		assertEquals(boardConfiguration, board.toString().replace(System.lineSeparator(), ""));
		queen.removeFrom(4, 4);
		assertEquals(cleanBoardConfiguration, board.toString().replace(System.lineSeparator(), ""));
	}
	
	@Test (expected=IndexOutOfBoundsException.class)
	public void testOutBoardPosition() {			
		Board board = new ArrayBoard(5, 5);
		Piece queen = new Queen(board);
		queen.moveTo(5, 5);
	}
	
	@Test (expected=IndexOutOfBoundsException.class)
	public void testNegativeBoardPosition() {			
		Board board = new ArrayBoard(5, 5);
		Piece queen = new Queen(board);
		queen.moveTo(-1, 1);
	}
}
