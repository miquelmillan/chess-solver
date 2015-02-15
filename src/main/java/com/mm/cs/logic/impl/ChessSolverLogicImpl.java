package com.mm.cs.logic.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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
		List<Piece> pieces = new ArrayList<>();
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
		
		solveBoard(board, 0, 0, pieces, result);
		System.out.println("Partial Result :: ");
		
		for (String boardConfig: result){
			System.out.println("Configuration:");
			System.out.println(boardConfig);
		}
		
		System.out.println("<- solveChessBoard: " + result);
		
		return result;
	}
	
	
	private void solveBoard(Board board, int row, int column, List<Piece> pieces, Set<String> result){
		int[] nextPosition = board.getFirstFreePosition();
		
		if (nextPosition != null){
			for (Piece p : pieces){
				for (int i=row;i<board.getBoard().length;i++){
					for (int j=column;j<board.getBoard()[0].length;j++){
						if (board.getBoard()[i][j].isFree()){
							p.moveTo(i, j);
							//System.out.println(board);
							nextPosition = board.getFirstFreePosition();
							if (nextPosition != null){
								List<Piece> subList = pieces.subList(1, pieces.size());
								solveBoard(board, nextPosition[0], nextPosition[1], subList, result);
							}
							//The last piece and it has a location ==> Solution!
							if (pieces.size()==1){
								result.add(board.toString());
							}
							
							p.removeFrom(i, j);
						}
					}
				}
			}
		}
	}
}
