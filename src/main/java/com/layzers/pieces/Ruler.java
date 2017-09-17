package com.layzers.pieces;

import com.layzers.layzer.Layzer;

public class Ruler extends Piece {

	public Ruler(Team pieceTeam, Angle pieceAngle) {
		super(pieceTeam, pieceAngle);
	}

	@Override
	public boolean handleLaser(Layzer laser) {
		return false;
	}
}
