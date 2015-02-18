package com.mm.cs.logic.concurrent.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ForkJoinPool;

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
 * Intend to solve the chess problem using concurrency. As the problem consists in a tree
 * search, the tree is divided into several parts and each part is offered to a thread. Once
 * each part is solved, the results are joined and returned to the user.
 * 
 * @author miquel.millan@gmail.com
 * @version 1.0
 *
 */
public class ChessSolverLogicConcurrentImpl implements ChessSolverLogic {
	
	@Override
	public Set<String> solveChessBoard(int rows, int columns, int knights,
			int rooks, int bishops, int queens, int kings) {
		System.out.println("-> solveChessBoard()");
		Set<String> result = new HashSet<>();
		List<Board> boards = null;
		List<Queue<Piece>> configs = null;
		Queue<ChessSolverRecurrentTaskImpl> tasks = new LinkedList<>();
		int totalPieces = knights + rooks + bishops + queens + kings;
		
		//Prepare the boards and the configurations
		boards = new ArrayList<>();
		for (int i=0;i<totalPieces;i++){
			boards.add(new ArrayBoard(rows, columns));
		}
		configs = getConfigurations(boards, knights, rooks, bishops, queens, kings);
				
		for (int i=0;i<boards.size();i++){
			tasks.add(new ChessSolverRecurrentTaskImpl(boards.get(i), configs.get(i), rows, columns));
		}
		
		ForkJoinPool pool = new ForkJoinPool();
		//The divided jobs are sent
		for (ChessSolverRecurrentTaskImpl task: tasks){
			pool.execute(task);
		}
		
		//The results are gathered
		for (ChessSolverRecurrentTaskImpl task: tasks){
			result.addAll(task.join());
		}
		
		System.out.println("<- solveChessBoard: " + result);
		
		return result;
	}
	

	private List<Queue<Piece>> getConfigurations(List<Board> boards, int knights,
			int rooks, int bishops, int queens, int kings){
		int j=0;
		Board board = null;
		List<Queue<Piece>> configs = new ArrayList<>();
		Queue<Piece> pieces = null;
		
		for (int i=0;i<boards.size();i++){
			board = boards.get(i);
			pieces = new LinkedList<>();
			for (j = 0; j < knights; j++)
				pieces.add(new Knight(board));
			for (j = 0; j < rooks; j++)
				pieces.add(new Rook(board));
			for (j = 0; j < bishops; j++)
				pieces.add(new Bishop(board));
			for (j = 0; j < queens; j++)
				pieces.add(new Queen(board));
			for (j = 0; j < kings; j++)
				pieces.add(new King(board));
			//Switch the configuration
			for (j = 0; j < i; j++){
				pieces.offer(pieces.poll());
			}
			configs.add(pieces);
		}

		return configs;
	}
}
