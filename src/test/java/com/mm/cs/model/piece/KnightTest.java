package com.mm.cs.model.piece;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.mm.cs.model.board.Board;
import com.mm.cs.model.board.impl.ArrayBoard;
import com.mm.cs.model.piece.impl.Knight;
/**
 * Test case of the Knight piece. This test covers the constructor,
 * a positioning in the middle of the board, the positioning on
 * the four edges of the board and error conditions
 * 
 * @author miquel.millan@gmail.com
 * @version 1.0
 *
 */
public class KnightTest {
	String cleanBoardConfiguration= 
			   "o o o o o "
			 + "o o o o o "
			 + "o o o o o "
			 + "o o o o o "
			 + "o o o o o ";
	
	@Test
	public void testConstructor() {
		Board board = new ArrayBoard(5, 5);
		Piece knight = new Knight(board);
		assertNotNull(knight);
	}
	@Test
	public void testMiddlePosition() {
		String boardConfiguration= 
				   "o x o x o "
				 + "x o o o x "
				 + "o o N o o "
				 + "x o o o x "
				 + "o x o x o ";	
				
				
		Board board = new ArrayBoard(5, 5);
		Piece knight = new Knight(board);
		knight.moveTo(2, 2);
		assertEquals(boardConfiguration, board.toString().replace(System.lineSeparator(), ""));
		knight.removeFrom(2, 2);
		assertEquals(cleanBoardConfiguration, board.toString().replace(System.lineSeparator(), ""));
	}
	
	@Test
	public void testUpperLeftPosition() {
		String boardConfiguration= 
				   "N o o o o "
				 + "o o x o o "
				 + "o x o o o "
				 + "o o o o o "
				 + "o o o o o ";	
				
				
		Board board = new ArrayBoard(5, 5);
		Piece knight = new Knight(board);
		knight.moveTo(0, 0);
		assertEquals(boardConfiguration, board.toString().replace(System.lineSeparator(), ""));
		knight.removeFrom(0, 0);
		assertEquals(cleanBoardConfiguration, board.toString().replace(System.lineSeparator(), ""));
	}
	
	
	@Test
	public void testUpperRightPosition() {
		String boardConfiguration= 
				  "o o o o N "
				+ "o o x o o "
				+ "o o o x o "
				+ "o o o o o "
				+ "o o o o o ";
				
				
		Board board = new ArrayBoard(5, 5);
		Piece knight = new Knight(board);
		knight.moveTo(0, 4);
		assertEquals(boardConfiguration, board.toString().replace(System.lineSeparator(), ""));
		knight.removeFrom(0, 4);
		assertEquals(cleanBoardConfiguration, board.toString().replace(System.lineSeparator(), ""));
	}
	

	@Test
	public void testBottomLeftPosition() {
		String boardConfiguration= 
				  "o o o o o "
				+ "o o o o o "
				+ "o x o o o "
				+ "o o x o o "
				+ "N o o o o ";

		Board board = new ArrayBoard(5, 5);
		Piece knight = new Knight(board);
		knight.moveTo(4, 0);
		assertEquals(boardConfiguration, board.toString().replace(System.lineSeparator(), ""));
		knight.removeFrom(4, 0);
		assertEquals(cleanBoardConfiguration, board.toString().replace(System.lineSeparator(), ""));
	}
	
	
	@Test
	public void testBottomRightPosition() {
		String boardConfiguration= 
		  		   "o o o o o "
				 + "o o o o o "
				 + "o o o x o "
				 + "o o x o o "
				 + "o o o o N ";
				
		Board board = new ArrayBoard(5, 5);
		Piece knight = new Knight(board);
		knight.moveTo(4, 4);
		assertEquals(boardConfiguration, board.toString().replace(System.lineSeparator(), ""));
		knight.removeFrom(4, 4);
		assertEquals(cleanBoardConfiguration, board.toString().replace(System.lineSeparator(), ""));
	}
	
	
	@Test (expected=IndexOutOfBoundsException.class)
	public void testOutBoardPosition() {			
		Board board = new ArrayBoard(5, 5);
		Piece knight = new Knight(board);
		knight.moveTo(5, 5);
	}
	
	@Test (expected=IndexOutOfBoundsException.class)
	public void testNegativeBoardPosition() {			
		Board board = new ArrayBoard(5, 5);
		Piece knight = new Knight(board);
		knight.moveTo(-1, 1);
	}
}
