package com.layzers.rules;

import com.layzers.board.Board;
import com.layzers.pieces.Piece;
import com.layzers.pieces.TwoSidedMirror;

public final class Relocation extends Move {
	
	private final Piece piece;
	private final int currentCoordinate;
	private final int newCoordinate;
	private final Board board;
	
	public MoveType getMoveType(){
		return MoveType.RELOCATION;
	}
	
	public int getNewCoordinate(){
		return this.newCoordinate;
	}
	
	public Relocation(Piece piece, int currentCoordinate, int newCoordinate, Board board){
		this.piece = piece;
		this.currentCoordinate = currentCoordinate;
		this.newCoordinate = newCoordinate;
		this.board = board;
	}

	@Override
	public void executeMove() {
		if(this.piece instanceof TwoSidedMirror){
			board.getBoard()[this.currentCoordinate].setPiece(board.getBoard()[this.newCoordinate].getPiece());
		}
		board.getBoard()[this.newCoordinate].setPiece(this.piece);
	}
}