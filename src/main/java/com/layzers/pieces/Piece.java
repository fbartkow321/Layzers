package com.layzers.pieces;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import com.layzers.board.Board;
import com.layzers.board.Tile;
import com.layzers.layzer.Layzer;
import com.layzers.rules.Move;
import com.layzers.rules.Relocation;
import com.layzers.rules.Rotation;
import com.layzers.rules.Rotation.RotationDirection;

public abstract class Piece {
	public enum Team{WHITE, BLACK, NONE};
	public enum Angle{ZERO, NINETY, ONEEIGHTY, TWOSEVENTY};
	public enum Status{ALIVE, DEAD};
	
	protected final static int[] CANDIDATE_MOVE_COORDINATES = {-11, -10, -9, -1, 1, 9, 10, 11};
	
	protected final Team pieceTeam;
	protected Angle pieceAngle;
	
	Piece(final Team pieceTeam, Angle pieceAngle){
		this.pieceTeam = pieceTeam;
		this.pieceAngle = pieceAngle;
	}
	
	public Team getTeam(){
		return this.pieceTeam;
	}
	
	public void setAngle(Angle val){
		this.pieceAngle = val;
	}
	
	public Angle getAngle(){
		return this.pieceAngle;
	}
	
	public abstract boolean handleLaser(Layzer laser);

	protected static boolean isFirstColumnExclusion(final int currentPosition, final int candidateOffset){
		if(String.valueOf(currentPosition).endsWith("0")
				&& (candidateOffset == -11 
				|| candidateOffset == -1 
				|| candidateOffset == 9)){
			return true;
		} else {
			return false;
		}
	}
	
	protected static boolean isFirstRowExclusion(final int currentPosition, final int candidateOffset){
		if(currentPosition < 10 
				&& (candidateOffset == -11 
				|| candidateOffset == -10 
				|| candidateOffset == -9)){
			return true;
		} else {
			return false;
		}
	}
	
	protected static boolean isLastColumnExclusion(final int currentPosition, final int candidateOffset){
		if(String.valueOf(currentPosition).endsWith("9") 
				&& (candidateOffset == 11 
				|| candidateOffset == 1 
				|| candidateOffset == -9)){
			return true;
		} else {
			return false;
		}
	}
	
	protected static boolean isLastRowExclusion(final int currentPosition, final int candidateOffset){
		if(currentPosition > 69 
				&& (candidateOffset == 11 
				|| candidateOffset == 10 
				|| candidateOffset == 9)){
			return true;
		} else {
			return false;
		}
	}
	
	public Collection<Move> calculateLegalMoves(final Board board, int piecePosition) {
		final List<Move> legalMoves = new ArrayList<>();
		for(final int currentCandidateOffset : CANDIDATE_MOVE_COORDINATES){
			int candidateDestinationCoordinate = piecePosition + currentCandidateOffset;
			if(isFirstColumnExclusion(piecePosition, currentCandidateOffset) 
					|| isFirstRowExclusion(piecePosition, currentCandidateOffset)
					|| isLastColumnExclusion(piecePosition, currentCandidateOffset) 
					|| isLastRowExclusion(piecePosition, currentCandidateOffset)){
				continue;
			}
			if(candidateDestinationCoordinate >= 0 && candidateDestinationCoordinate < 80){
				final Tile candidateDestinationTile = board.getTile(candidateDestinationCoordinate);
				if(candidateDestinationTile.getTileTeam() == this.pieceTeam 
						|| candidateDestinationTile.getTileTeam() == Team.NONE){
					if(candidateDestinationTile.isOccupied() && this instanceof TwoSidedMirror){
						Piece destinationTilePiece = candidateDestinationTile.getPiece();
						if(destinationTilePiece instanceof OneSidedMirror ||
								destinationTilePiece instanceof Defender){
							legalMoves.add(new Relocation(this, piecePosition, candidateDestinationCoordinate, board));
						}
					} else if(!candidateDestinationTile.isOccupied()){
						legalMoves.add(new Relocation(this, piecePosition, candidateDestinationCoordinate, board));
					}
				}
			}
		}
		legalMoves.add(new Rotation(this, RotationDirection.RIGHT));
		legalMoves.add(new Rotation(this, RotationDirection.LEFT));
		return Collections.unmodifiableCollection(legalMoves);
	}
}
