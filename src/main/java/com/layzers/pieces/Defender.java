package com.layzers.pieces;

import com.layzers.layzer.Layzer;

public class Defender extends Piece {

	public Defender(Team pieceTeam, Angle pieceAngle) {
		super(pieceTeam, pieceAngle);
	}

	@Override
	public boolean handleLaser(Layzer laser) {
		return false;
	}
}
