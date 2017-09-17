package com.layzers.rules;

import com.layzers.pieces.Piece;
import com.layzers.pieces.Piece.Angle;

public class Rotation extends Move {
	
	public enum RotationDirection{RIGHT, LEFT}
	
	private final Piece piece;
	private final RotationDirection rotationDirection;
	private final Angle currentAngle;
	
	public RotationDirection getRotationDirection(){
		return this.rotationDirection;
	}
	
	public MoveType getMoveType(){
		return MoveType.ROTATION;
	}
	
	public Rotation(Piece piece, RotationDirection rotationDirection){
		this.piece = piece;
		this.rotationDirection = rotationDirection;
		this.currentAngle = piece.getAngle();
	}
	
	@Override
	public void executeMove(){
		if(rotationDirection == RotationDirection.RIGHT){
			switch(currentAngle){
				case ZERO :
					piece.setAngle(Angle.NINETY);
					break;
				case NINETY:
					piece.setAngle(Angle.ONEEIGHTY);
					break;
				case ONEEIGHTY:
					piece.setAngle(Angle.TWOSEVENTY);
					break;
				case TWOSEVENTY:
					piece.setAngle(Angle.ZERO);
					break;
			}
		} else if(rotationDirection == RotationDirection.LEFT){
			switch(currentAngle){
				case ZERO :
					piece.setAngle(Angle.TWOSEVENTY);
					break;
				case NINETY:
					piece.setAngle(Angle.ZERO);
					break;
				case ONEEIGHTY:
					piece.setAngle(Angle.NINETY);
					break;
				case TWOSEVENTY:
					piece.setAngle(Angle.ONEEIGHTY);
					break;
			}
		}
	}
}