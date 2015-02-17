package com.mm.cs.logic.impl;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

import com.mm.cs.logic.ChessSolverLogic;
import com.mm.cs.model.board.Board;
import com.mm.cs.model.board.impl.ArrayBoard;
import com.mm.cs.model.piece.Piece;
import com.mm.cs.model.piece.impl.Bishop;
import com.mm.cs.model.piece.impl.King;
import com.mm.cs.model.piece.impl.Knight;
import com.mm.cs.model.piece.impl.Queen;
import com.mm.cs.model.piece.impl.Rook;
import com.mm.cs.util.BoardFormatUtil;

/**
 * Implementation of the ChessSolverLogic interface using a backtracking
 * algorithm.
 * 
 * @author miquel.millan@gmail.com
 * @version 1.0
 *
 */
public class ChessSolverLogicImpl implements ChessSolverLogic {

	@Override
	public Set<String> solveChessBoard(int rows, int columns, int knights,
			int rooks, int bishops, int queens, int kings) {
		System.out.println("-> solveChessBoard()");
		
		Set<String> result = new HashSet<>();
		Queue<Piece> pieces = new LinkedList<>();
		Board board = new ArrayBoard(rows, columns);

		for (int i = 0; i < knights; i++)
			pieces.add(new Knight(board));
		for (int i = 0; i < rooks; i++)
			pieces.add(new Rook(board));
		for (int i = 0; i < bishops; i++)
			pieces.add(new Bishop(board));
		for (int i = 0; i < queens; i++)
			pieces.add(new Queen(board));
		for (int i = 0; i < kings; i++)
			pieces.add(new King(board));
		
		solveBoard(board, pieces, result);
		
		System.out.println("<- solveChessBoard: " + result);
		
		return result;
	}
	
	private void solveBoard(Board board, Queue<Piece> pieces, Set<String> result){
		int size = pieces.size();
		
		if (size > 0){
			for (int i=0;i<size;i++){
				Piece piece = pieces.poll();
				for (int[] position: board.getFreePositions()){
					if (piece.moveTo(position[0], position[1])){
						solveBoard(board, pieces, result);
						piece.removeFrom(position[0], position[1]);
					}
				}
				pieces.offer(piece);
			}
		} else {
			//The add condition must be called only if no pieces are left to be placed in the board
			result.add(BoardFormatUtil.format(board, BoardFormatUtil.Format.FANCY));
		}
		
	}
}
