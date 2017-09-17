package com.layzers.layzer;

import com.layzers.board.Tile;
import com.layzers.pieces.Defender;
import com.layzers.pieces.LayzerLauncher;
import com.layzers.pieces.Piece;
import com.layzers.pieces.Ruler;
import com.layzers.pieces.Piece.Angle;

public class Layzer {
	private Angle laserAngle;
	private int laserPosition;
	private final Tile[] gameBoard;
	
	/**
	 * The Angle of the laser should be thought of as a direction, not an angle.</br>
	 * I left it as an Angle because that was easier than making a whole new enum.</br>
	 * ZERO = NORTH</br>
	 * NINETY = EAST</br>
	 * ONEIGHTY = SOUTH</br>
	 * TWOSEVENTY = WEST
	 */
	public void setAngle(Angle laserAngle){
		this.laserAngle = laserAngle;
	}
	
	public Angle getAngle(){
		return this.laserAngle;
	}
	
	public Layzer(Tile[] gameBoard, Angle laserAngle, int laserPosition) {
		this.gameBoard = gameBoard;
		this.laserAngle = laserAngle;
		this.laserPosition = laserPosition;
	}
	
	public void fire(){
		boolean laserStillMoving = true;
		boolean laserOnBoard = true;
		while(laserStillMoving){
			System.out.println("Current Laser Position: " + this.laserPosition);
			if(this.laserAngle == Angle.ZERO && laserPosition > 9){
				laserPosition -= 10;
			} else if(this.laserAngle == Angle.NINETY && !String.valueOf(laserPosition).endsWith("9")){
				laserPosition += 1;
			} else if(this.laserAngle == Angle.ONEEIGHTY && laserPosition < 70){
				laserPosition += 10;
			} else if(this.laserAngle == Angle.TWOSEVENTY && !String.valueOf(laserPosition).endsWith("0")){
				laserPosition -= 1;
			} else {
				laserStillMoving = false;
				laserOnBoard = false;
			}
			if(gameBoard[laserPosition].isOccupied()){
				Piece piece = gameBoard[laserPosition].getPiece();
				laserStillMoving = piece.handleLaser(this);
			}
		}
		if(laserOnBoard){
			Piece piece = this.gameBoard[this.laserPosition].getPiece();
			if(piece instanceof LayzerLauncher){
				//Do nothing;
			} else if(piece instanceof Defender){
				switch(laserAngle){
				case ZERO:
					if(piece.getAngle() != Angle.ONEEIGHTY){
						destroyPiece(this.laserPosition);
					}
					break;
				case NINETY:
					if(piece.getAngle() != Angle.TWOSEVENTY){
						destroyPiece(this.laserPosition);
					}
					break;
				case ONEEIGHTY:
					if(piece.getAngle() != Angle.ZERO){
						destroyPiece(this.laserPosition);
					}
					break;
				case TWOSEVENTY:
					if(piece.getAngle() != Angle.NINETY){
						destroyPiece(this.laserPosition);
					}
					break;
				}
			} else if(piece instanceof Ruler){
				System.out.println("The game needs to end.");
			} else {
				destroyPiece(this.laserPosition);
			}
			System.out.println("Killing a Piece.");
		} else {
			System.out.println("Laser has gone off the board.");
		}
	}
	
	private void destroyPiece(int piecePosition){
		this.gameBoard[piecePosition].setPiece(null);;
	}
}