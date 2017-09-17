package com.layzers.pieces;

import com.layzers.layzer.Layzer;

public class TwoSidedMirror extends Piece {
	public TwoSidedMirror(Team pieceTeam, Angle pieceAngle) {
		super(pieceTeam, pieceAngle);
	}

	@Override
	public boolean handleLaser(Layzer laser) {
		Angle laserAngle = laser.getAngle();
		switch(laserAngle){
		case ZERO:
			if(this.pieceAngle == Angle.ZERO || this.pieceAngle == Angle.ONEEIGHTY){
				laser.setAngle(Angle.TWOSEVENTY);
			} else if(this.pieceAngle == Angle.NINETY || this.pieceAngle == Angle.TWOSEVENTY){
				laser.setAngle(Angle.NINETY);
			}
			break;
		case NINETY:
			if(this.pieceAngle == Angle.ZERO || this.pieceAngle == Angle.ONEEIGHTY){
				laser.setAngle(Angle.ONEEIGHTY);
			} else if(this.pieceAngle == Angle.NINETY || this.pieceAngle == Angle.TWOSEVENTY){
				laser.setAngle(Angle.ZERO);
			}
			break;
		case ONEEIGHTY:
			if(this.pieceAngle == Angle.NINETY || this.pieceAngle == Angle.TWOSEVENTY){
				laser.setAngle(Angle.TWOSEVENTY);
			} else if(this.pieceAngle == Angle.ONEEIGHTY || this.pieceAngle == Angle.ZERO){
				laser.setAngle(Angle.NINETY);
			}
			break;
		case TWOSEVENTY:
			if(this.pieceAngle == Angle.ONEEIGHTY || this.pieceAngle == Angle.ZERO){
				laser.setAngle(Angle.ZERO);
			} else if(this.pieceAngle == Angle.TWOSEVENTY || this.pieceAngle == Angle.NINETY){
				laser.setAngle(Angle.ONEEIGHTY);
			}
			break;
		}
		return true;
	}
}
