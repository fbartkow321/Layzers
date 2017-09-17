package com.layzers.pieces;

import com.layzers.layzer.Layzer;

public class OneSidedMirror extends Piece{

	public OneSidedMirror(final Team pieceTeam, final Angle pieceAngle) {
		super(pieceTeam, pieceAngle);
	}

	@Override
	public boolean handleLaser(Layzer laser) {
		Angle laserAngle = laser.getAngle();
		switch(laserAngle){
		case ZERO:
			if(this.pieceAngle == Angle.ZERO){
				laser.setAngle(Angle.TWOSEVENTY);
			} else if(this.pieceAngle == Angle.TWOSEVENTY){
				laser.setAngle(Angle.NINETY);
			} else {
				return false;
			}
			break;
		case NINETY:
			if(this.pieceAngle == Angle.ZERO){
				laser.setAngle(Angle.ONEEIGHTY);
			} else if(this.pieceAngle == Angle.NINETY){
				laser.setAngle(Angle.ZERO);
			} else {
				return false;
			}
			break;
		case ONEEIGHTY:
			if(this.pieceAngle == Angle.NINETY){
				laser.setAngle(Angle.TWOSEVENTY);
			} else if(this.pieceAngle == Angle.ONEEIGHTY){
				laser.setAngle(Angle.NINETY);
			} else {
				return false;
			}
			break;
		case TWOSEVENTY:
			if(this.pieceAngle == Angle.ONEEIGHTY){
				laser.setAngle(Angle.ZERO);
			} else if(this.pieceAngle == Angle.TWOSEVENTY){
				laser.setAngle(Angle.ONEEIGHTY);
			} else {
				return false;
			}
			break;
		}
		return true;
	}
}