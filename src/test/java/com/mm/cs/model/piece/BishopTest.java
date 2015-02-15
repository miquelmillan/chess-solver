package com.mm.cs.model.piece;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.mm.cs.model.board.Board;
import com.mm.cs.model.board.impl.ArrayBoard;
import com.mm.cs.model.piece.impl.Bishop;

/**
 * Test case of the Bishop piece. This test covers the constructor,
 * a positioning in the middle of the board, the positioning on
 * the four edges of the board and error conditions
 * 
 * @author miquel.millan@gmail.com
 * @version 1.0
 *
 */
public class BishopTest {
	String cleanBoardConfiguration= 
			   "o o o o o "
			 + "o o o o o "
			 + "o o o o o "
			 + "o o o o o "
			 + "o o o o o ";
		
	@Test
	public void testConstructor() {
		Board board = new ArrayBoard(5, 5);
		Piece bishop = new Bishop(board);
		assertNotNull(bishop);
	}
	@Test
	public void testMiddlePosition() {
		String boardConfiguration= 
				   "x o o o x "
				 + "o x o x o "
				 + "o o B o o "
				 + "o x o x o "
				 + "x o o o x ";	
				
				
		Board board = new ArrayBoard(5, 5);
		Piece bishop = new Bishop(board);
		bishop.moveTo(2, 2);
		assertEquals(boardConfiguration, board.toString().replace(System.lineSeparator(), ""));
		bishop.removeFrom(2, 2);
		assertEquals(cleanBoardConfiguration, board.toString().replace(System.lineSeparator(), ""));
	}

	@Test
	public void testUpperLeftPosition() {
		String boardConfiguration= 
				   "B o o o o "
				 + "o x o o o "
				 + "o o x o o "
				 + "o o o x o "
				 + "o o o o x ";	
				
				
		Board board = new ArrayBoard(5, 5);
		Piece bishop = new Bishop(board);
		bishop.moveTo(0, 0);
		assertEquals(boardConfiguration, board.toString().replace(System.lineSeparator(), ""));
		bishop.removeFrom(0, 0);
		assertEquals(cleanBoardConfiguration, board.toString().replace(System.lineSeparator(), ""));
	}
	
	@Test
	public void testUpperRightPosition() {
		String boardConfiguration= 
				  "o o o o B "
				+ "o o o x o "
				+ "o o x o o "
				+ "o x o o o "
				+ "x o o o o ";
				
				
		Board board = new ArrayBoard(5, 5);
		Piece bishop = new Bishop(board);
		bishop.moveTo(0, 4);
		assertEquals(boardConfiguration, board.toString().replace(System.lineSeparator(), ""));
		bishop.removeFrom(0, 4);
		assertEquals(cleanBoardConfiguration, board.toString().replace(System.lineSeparator(), ""));
	}

	@Test
	public void testBottomLeftPosition() {
		String boardConfiguration= 
				  "o o o o x "
				+ "o o o x o "
				+ "o o x o o "
				+ "o x o o o "
				+ "B o o o o ";

		Board board = new ArrayBoard(5, 5);
		Piece bishop = new Bishop(board);
		bishop.moveTo(4, 0);
		assertEquals(boardConfiguration, board.toString().replace(System.lineSeparator(), ""));
		bishop.removeFrom(4, 0);
		assertEquals(cleanBoardConfiguration, board.toString().replace(System.lineSeparator(), ""));
	}
	
	@Test
	public void testBottomRightPosition() {
		String boardConfiguration= 
		  		   "x o o o o "
				 + "o x o o o "
				 + "o o x o o "
				 + "o o o x o "
				 + "o o o o B ";
				
		Board board = new ArrayBoard(5, 5);
		Piece bishop = new Bishop(board);
		bishop.moveTo(4, 4);
		assertEquals(boardConfiguration, board.toString().replace(System.lineSeparator(), ""));
		bishop.removeFrom(4, 4);
		assertEquals(cleanBoardConfiguration, board.toString().replace(System.lineSeparator(), ""));
	}
	
	@Test (expected=IndexOutOfBoundsException.class)
	public void testOutBoardPosition() {			
		Board board = new ArrayBoard(5, 5);
		Piece bishop = new Bishop(board);
		bishop.moveTo(5, 5);
	}
	
	@Test (expected=IndexOutOfBoundsException.class)
	public void testNegativeBoardPosition() {			
		Board board = new ArrayBoard(5, 5);
		Piece bishop = new Bishop(board);
		bishop.moveTo(-1, 1);
	}

}
