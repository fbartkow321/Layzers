package com.layzers.board;

import com.layzers.pieces.Piece;
import com.layzers.pieces.Piece.Team;

public class Tile {
	
	private final Team tileTeam;
	
	private Piece pieceOnTile;
	
	public Tile(int tileCoordinate, Team tileTeam, Piece pieceOnTile){
		this.tileTeam = tileTeam;
		this.pieceOnTile = pieceOnTile;
	}
	
	public boolean isOccupied(){
		if(pieceOnTile != null){
			return true;
		} else {
			return false;
		}
	}
	
	public Team getTileTeam() {
		return this.tileTeam;
	}
	
	public Piece getPiece(){
		return this.pieceOnTile;
	}
	
	public void setPiece(Piece pieceOnTile){
		this.pieceOnTile = pieceOnTile;
	}
}