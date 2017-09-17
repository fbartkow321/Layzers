package com.layzers.pieces;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import com.layzers.board.Board;
import com.layzers.board.Tile;
import com.layzers.layzer.Layzer;
import com.layzers.rules.Move;
import com.layzers.rules.Rotation;
import com.layzers.rules.Rotation.RotationDirection;

public class LayzerLauncher extends Piece {
	public LayzerLauncher(Team pieceTeam, Angle pieceAngle) {
		super(pieceTeam, pieceAngle);
	}
	
	public void fireLaser(Tile[] gameBoard, int startingPosition){
		Layzer laser = new Layzer(gameBoard, this.pieceAngle, startingPosition);
		laser.fire();
	}

	@Override
	public boolean handleLaser(Layzer laser) {
		return false;
	}

	@Override
	public Collection<Move> calculateLegalMoves(final Board board, int piecePosition) {
		final List<Move> legalMoves = new ArrayList<>();
		if(this.pieceAngle == Angle.ZERO && this.pieceTeam == Team.BLACK){
			legalMoves.add(new Rotation(this, RotationDirection.LEFT));
		} else if(this.pieceAngle == Angle.TWOSEVENTY && this.pieceTeam == Team.BLACK){
			legalMoves.add(new Rotation(this, RotationDirection.RIGHT));
		} else if(this.pieceAngle == Angle.NINETY && this.pieceTeam == Team.WHITE){
			legalMoves.add(new Rotation(this, RotationDirection.RIGHT));
		} else if(this.pieceAngle == Angle.ONEEIGHTY && this.pieceTeam == Team.WHITE){
			legalMoves.add(new Rotation(this, RotationDirection.LEFT));
		}
		return Collections.unmodifiableCollection(legalMoves);
	}
}
