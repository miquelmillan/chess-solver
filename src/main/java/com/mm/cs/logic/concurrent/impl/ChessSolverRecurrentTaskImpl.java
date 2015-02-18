package com.mm.cs.logic.concurrent.impl;

import java.util.HashSet;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.RecursiveTask;

import com.mm.cs.model.board.Board;
import com.mm.cs.model.piece.Piece;
import com.mm.cs.util.BoardFormatUtil;

public class ChessSolverRecurrentTaskImpl extends RecursiveTask<Set<String>> {
	private static final long serialVersionUID = -6056262994858323977L;
	private Board board;
	private Queue<Piece> pieces;
	private int rows;
	private int columns;
	
	public ChessSolverRecurrentTaskImpl(Board board, Queue<Piece> pieces, int rows, int columns) {
		this.board = board;
		this.pieces = pieces;
		this.rows = rows;
		this.columns = columns;
	}
	
	@Override
	protected Set<String> compute (){
		//compute with one piece moving around the board and calculating the 
		//rest of combinations
		Set<String> result = new HashSet<>();
		Piece piece = pieces.poll();
		for (int i=0;i<rows;i++){
			for (int j=0;j<columns;j++){
					for (int[] position: board.getFreePositions()){
							if (piece.moveTo(position[0], position[1])){
								if (pieces.size()>0){
									solveBoard(board, pieces, result);
								} else {
									//The add condition must be called only if no pieces are left to be placed in the board
									result.add(BoardFormatUtil.format(board, BoardFormatUtil.Format.FANCY));	
								}
							}
							piece.removeFrom(position[0], position[1]);
					}
			}
		}
		
		return result;
	}
	
	private void solveBoard(Board board, Queue<Piece> pieces, Set<String> result){
		int size = pieces.size();
		Piece piece = null, oldPiece = null;
		
		if (size > 0){
			for (int i=0;i<size;i++){
				piece = pieces.poll();
				if (oldPiece==null || !piece.toString().equals(oldPiece.toString())){
					for (int[] position: board.getFreePositions()){
						if (piece.moveTo(position[0], position[1])){
							solveBoard(board, pieces, result);
							piece.removeFrom(position[0], position[1]);
						}
					}
				}
				pieces.offer(piece);
				oldPiece = piece;
			}
		} else {
			//The add condition must be called only if no pieces are left to be placed in the board
			result.add(BoardFormatUtil.format(board, BoardFormatUtil.Format.FANCY));
		}
	}
}
