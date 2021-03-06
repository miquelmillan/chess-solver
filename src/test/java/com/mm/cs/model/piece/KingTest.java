package com.mm.cs.model.piece;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

import com.mm.cs.model.board.Board;
import com.mm.cs.model.board.impl.ArrayBoard;
import com.mm.cs.model.piece.impl.King;

/**
 * Test case of the King piece. This test covers the constructor,
 * a positioning in the middle of the board, the positioning on
 * the four edges of the board and error conditions
 * 
 * @author miquel.millan@gmail.com
 * @version 1.0
 *
 */
public class KingTest {
	String cleanBoardConfiguration= 
			   "o o o o o "
			 + "o o o o o "
			 + "o o o o o "
			 + "o o o o o "
			 + "o o o o o ";
	
	@Test
	public void testConstructor() {
		Board board = new ArrayBoard(5, 5);
		Piece king = new King(board);
		assertNotNull(king);
	}
	@Test
	public void testMiddlePosition() {
		String boardConfiguration= 
				   "o o o o o "
				 + "o x x x o "
				 + "o x K x o "
				 + "o x x x o "
				 + "o o o o o ";	
				
				
		Board board = new ArrayBoard(5, 5);
		Piece king = new King(board);
		king.moveTo(2, 2);
		assertEquals(boardConfiguration, board.toString().replace(System.lineSeparator(), ""));
		king.removeFrom(2, 2);
		assertEquals(cleanBoardConfiguration, board.toString().replace(System.lineSeparator(), ""));
	}

	@Test
	public void testUpperLeftPosition() {
		String boardConfiguration= 
				   "K x o o o "
				 + "x x o o o "
				 + "o o o o o "
				 + "o o o o o "
				 + "o o o o o ";	
				
				
		Board board = new ArrayBoard(5, 5);
		Piece king = new King(board);
		king.moveTo(0, 0);
		assertEquals(boardConfiguration, board.toString().replace(System.lineSeparator(), ""));
		king.removeFrom(0, 0);
		assertEquals(cleanBoardConfiguration, board.toString().replace(System.lineSeparator(), ""));
	}
	
	@Test
	public void testUpperRightPosition() {
		String boardConfiguration= 
				  "o o o x K "
				+ "o o o x x "
				+ "o o o o o "
				+ "o o o o o "
				+ "o o o o o ";
				
				
		Board board = new ArrayBoard(5, 5);
		Piece king = new King(board);
		king.moveTo(0, 4);
		assertEquals(boardConfiguration, board.toString().replace(System.lineSeparator(), ""));
		king.removeFrom(0, 4);
		assertEquals(cleanBoardConfiguration, board.toString().replace(System.lineSeparator(), ""));		
	}

	@Test
	public void testBottomLeftPosition() {
		String boardConfiguration= 
				  "o o o o o "
				+ "o o o o o "
				+ "o o o o o "
				+ "x x o o o "
				+ "K x o o o ";

		Board board = new ArrayBoard(5, 5);
		Piece king = new King(board);
		king.moveTo(4, 0);
		assertEquals(boardConfiguration, board.toString().replace(System.lineSeparator(), ""));
		king.removeFrom(4, 0);
		assertEquals(cleanBoardConfiguration, board.toString().replace(System.lineSeparator(), ""));
	}
	
	@Test
	public void testBottomRightPosition() {
		String boardConfiguration= 
		  		   "o o o o o "
				 + "o o o o o "
				 + "o o o o o "
				 + "o o o x x "
				 + "o o o x K ";
				
		Board board = new ArrayBoard(5, 5);
		Piece king = new King(board);
		king.moveTo(4, 4);
		assertEquals(boardConfiguration, board.toString().replace(System.lineSeparator(), ""));
		king.removeFrom(4, 4);
		assertEquals(cleanBoardConfiguration, board.toString().replace(System.lineSeparator(), ""));
	}
	
	@Test
	public void testOutBoardPosition() {			
		Board board = new ArrayBoard(5, 5);
		Piece king = new King(board);
		assertFalse(king.moveTo(5, 5));
	}
	
	@Test
	public void testNegativeBoardPosition() {			
		Board board = new ArrayBoard(5, 5);
		Piece king = new King(board);
		assertFalse(king.moveTo(-1, 1));
	}
}
