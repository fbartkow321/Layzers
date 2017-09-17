package com.layzers.board;

import java.util.Collection;

import com.layzers.pieces.Defender;
import com.layzers.pieces.LayzerLauncher;
import com.layzers.pieces.OneSidedMirror;
import com.layzers.pieces.Piece;
import com.layzers.pieces.Ruler;
import com.layzers.pieces.TwoSidedMirror;
import com.layzers.pieces.Piece.Angle;
import com.layzers.pieces.Piece.Team;
import com.layzers.rules.Move;
import com.layzers.rules.Relocation;
import com.layzers.rules.Rotation;

public class Board{
	
	public enum GameType{ORIGINAL, TECHLO, PEWPEW}
	
	public static void main(String[] args){
		Board b = new Board();
		b.setPieces(GameType.ORIGINAL);
		b.printBoard();
		b.printLaser();
		b.printLaser();
	}
	
	private void printBoard(){
		int pieceCounter = 1;
		int tileCounter = 0;
		for(Tile tile:gameBoard){
			if(tile.isOccupied()){
				Piece piece = tile.getPiece();
				System.out.println("Piece Number: " + pieceCounter + ": " +
						", Piece Team: " + piece.getTeam() + ", Piece Angle: " + piece.getAngle() + ", Piece Position: " + tileCounter);
				pieceCounter++;
				Collection<Move> moves = piece.calculateLegalMoves(this, tileCounter);
				int moveCounter = 1;
				for(Move move:moves){
					System.out.print("   Move - " + moveCounter + ": Move Type: " + move.getMoveType());
					if(move instanceof Relocation){
						Relocation rel = (Relocation)move;
						System.out.print(", New Coordinate: " + rel.getNewCoordinate() + "\n");
					} else if(move instanceof Rotation){
						Rotation rot = (Rotation)move;
						System.out.print(", Rotation Direction: " + rot.getRotationDirection() + "\n");
					}
					moveCounter++;
				}
			}
		}
	}
	
	private void printLaser(){
		LayzerLauncher sphinx = (LayzerLauncher)gameBoard[79].getPiece();
		sphinx.fireLaser(gameBoard, 79);
	}
	
	private Tile[] gameBoard = new Tile[80];
	
	public Board(){
		for(int i = 0; i < 80; i++){
			Tile tile;
			if(i == 0 || i == 8 || i == 78 || i % 10 == 0){
				tile = new Tile(i, Team.WHITE, null);
			} else if(i == 1 || i == 71 || String.valueOf(i).endsWith("9")){
				tile = new Tile(i, Team.BLACK, null);
			} else {
				tile = new Tile(i, Team.NONE, null);
			}
			this.gameBoard[i] = tile;
		}
	}
	
	public Tile getTile(int tileNumber){
		return gameBoard[tileNumber];
	}
	
	public Tile[] getBoard(){
		return gameBoard;
	}
	
	public void setPieces(GameType gameType){
		if(gameType == GameType.ORIGINAL){
			//Red Team Configuration
			gameBoard[0].setPiece(new LayzerLauncher(Team.WHITE, Angle.ONEEIGHTY));
			gameBoard[4].setPiece(new Defender(Team.WHITE, Angle.ONEEIGHTY));
			gameBoard[5].setPiece(new Ruler(Team.WHITE, Angle.ONEEIGHTY));
			gameBoard[6].setPiece(new Defender(Team.WHITE, Angle.ONEEIGHTY));
			gameBoard[7].setPiece(new OneSidedMirror(Team.WHITE, Angle.TWOSEVENTY));
			gameBoard[12].setPiece(new OneSidedMirror(Team.WHITE, Angle.ZERO));
			gameBoard[30].setPiece(new OneSidedMirror(Team.WHITE, Angle.ONEEIGHTY));
			gameBoard[34].setPiece(new TwoSidedMirror(Team.WHITE, Angle.ZERO));
			gameBoard[35].setPiece(new TwoSidedMirror(Team.WHITE, Angle.NINETY));
			gameBoard[37].setPiece(new OneSidedMirror(Team.WHITE, Angle.TWOSEVENTY));
			gameBoard[40].setPiece(new OneSidedMirror(Team.WHITE, Angle.TWOSEVENTY));
			gameBoard[47].setPiece(new OneSidedMirror(Team.WHITE, Angle.ONEEIGHTY));
			gameBoard[56].setPiece(new OneSidedMirror(Team.WHITE, Angle.TWOSEVENTY));
			
			//TODO Test destroction piece - delete this later
			//gameBoard[19].setPiece(new Pyramid(Team.RED, Angle.ONEEIGHTY));
			
			//Silver Team Configuration
			gameBoard[79].setPiece(new LayzerLauncher(Team.BLACK, Angle.ZERO));
			gameBoard[75].setPiece(new Defender(Team.BLACK, Angle.ZERO));
			gameBoard[74].setPiece(new Ruler(Team.BLACK, Angle.ZERO));
			gameBoard[73].setPiece(new Defender(Team.BLACK, Angle.ZERO));
			gameBoard[72].setPiece(new OneSidedMirror(Team.BLACK, Angle.NINETY));
			gameBoard[67].setPiece(new OneSidedMirror(Team.BLACK, Angle.ONEEIGHTY));
			gameBoard[49].setPiece(new OneSidedMirror(Team.BLACK, Angle.ZERO));
			gameBoard[45].setPiece(new TwoSidedMirror(Team.BLACK, Angle.ONEEIGHTY));
			gameBoard[44].setPiece(new TwoSidedMirror(Team.BLACK, Angle.TWOSEVENTY));
			gameBoard[42].setPiece(new OneSidedMirror(Team.BLACK, Angle.NINETY));
			gameBoard[39].setPiece(new OneSidedMirror(Team.BLACK, Angle.NINETY));
			gameBoard[32].setPiece(new OneSidedMirror(Team.BLACK, Angle.ZERO));
			gameBoard[23].setPiece(new OneSidedMirror(Team.BLACK, Angle.NINETY));
			
		} else if(gameType == GameType.TECHLO) {
			
			//Red Team Configuration
			gameBoard[0].setPiece(new LayzerLauncher(Team.WHITE, Angle.ONEEIGHTY));
			gameBoard[4].setPiece(new Defender(Team.WHITE, Angle.ONEEIGHTY));
			gameBoard[5].setPiece(new Ruler(Team.WHITE, Angle.ONEEIGHTY));
			gameBoard[6].setPiece(new Defender(Team.WHITE, Angle.ONEEIGHTY));
			gameBoard[7].setPiece(new TwoSidedMirror(Team.WHITE, Angle.NINETY));
			gameBoard[26].setPiece(new OneSidedMirror(Team.WHITE, Angle.ONEEIGHTY));
			gameBoard[30].setPiece(new OneSidedMirror(Team.WHITE, Angle.ONEEIGHTY));
			gameBoard[35].setPiece(new TwoSidedMirror(Team.WHITE, Angle.NINETY));
			gameBoard[38].setPiece(new OneSidedMirror(Team.WHITE, Angle.TWOSEVENTY));
			gameBoard[40].setPiece(new OneSidedMirror(Team.WHITE, Angle.TWOSEVENTY));
			gameBoard[45].setPiece(new OneSidedMirror(Team.WHITE, Angle.NINETY));
			gameBoard[48].setPiece(new OneSidedMirror(Team.WHITE, Angle.ONEEIGHTY));
			gameBoard[56].setPiece(new OneSidedMirror(Team.WHITE, Angle.TWOSEVENTY));
			
			//Silver Team Configuration
			gameBoard[79].setPiece(new LayzerLauncher(Team.BLACK, Angle.ZERO));
			gameBoard[75].setPiece(new Defender(Team.BLACK, Angle.ZERO));
			gameBoard[74].setPiece(new Ruler(Team.BLACK, Angle.ZERO));
			gameBoard[73].setPiece(new Defender(Team.BLACK, Angle.ZERO));
			gameBoard[72].setPiece(new TwoSidedMirror(Team.BLACK, Angle.TWOSEVENTY));
			gameBoard[53].setPiece(new OneSidedMirror(Team.BLACK, Angle.ZERO));
			gameBoard[49].setPiece(new OneSidedMirror(Team.BLACK, Angle.ZERO));
			gameBoard[44].setPiece(new TwoSidedMirror(Team.BLACK, Angle.TWOSEVENTY));
			gameBoard[41].setPiece(new OneSidedMirror(Team.BLACK, Angle.NINETY));
			gameBoard[39].setPiece(new OneSidedMirror(Team.BLACK, Angle.NINETY));
			gameBoard[34].setPiece(new OneSidedMirror(Team.BLACK, Angle.TWOSEVENTY));
			gameBoard[31].setPiece(new OneSidedMirror(Team.BLACK, Angle.ZERO));
			gameBoard[23].setPiece(new OneSidedMirror(Team.BLACK, Angle.NINETY));
		} else if(gameType == GameType.PEWPEW){
			
			//Red Team Configuration
			gameBoard[0].setPiece(new LayzerLauncher(Team.WHITE, Angle.ONEEIGHTY));
			gameBoard[4].setPiece(new OneSidedMirror(Team.WHITE, Angle.ZERO));
			gameBoard[5].setPiece(new Defender(Team.WHITE, Angle.ONEEIGHTY));
			gameBoard[6].setPiece(new OneSidedMirror(Team.WHITE, Angle.TWOSEVENTY));
			gameBoard[15].setPiece(new Ruler(Team.WHITE, Angle.ONEEIGHTY));
			gameBoard[20].setPiece(new OneSidedMirror(Team.WHITE, Angle.ONEEIGHTY));
			gameBoard[24].setPiece(new OneSidedMirror(Team.WHITE, Angle.ZERO));
			gameBoard[25].setPiece(new Defender(Team.WHITE, Angle.ONEEIGHTY));
			gameBoard[26].setPiece(new TwoSidedMirror(Team.WHITE, Angle.TWOSEVENTY));
			gameBoard[30].setPiece(new OneSidedMirror(Team.WHITE, Angle.TWOSEVENTY));
			gameBoard[32].setPiece(new TwoSidedMirror(Team.WHITE, Angle.ONEEIGHTY));
			gameBoard[43].setPiece(new OneSidedMirror(Team.WHITE, Angle.NINETY));
			gameBoard[45].setPiece(new OneSidedMirror(Team.WHITE, Angle.TWOSEVENTY));
			
			//Silver Team Configuration
			gameBoard[79].setPiece(new LayzerLauncher(Team.BLACK, Angle.ZERO));
			gameBoard[75].setPiece(new OneSidedMirror(Team.BLACK, Angle.ONEEIGHTY));
			gameBoard[74].setPiece(new Defender(Team.BLACK, Angle.ZERO));
			gameBoard[73].setPiece(new OneSidedMirror(Team.BLACK, Angle.NINETY));
			gameBoard[64].setPiece(new Ruler(Team.BLACK, Angle.ZERO));
			gameBoard[59].setPiece(new OneSidedMirror(Team.BLACK, Angle.ZERO));
			gameBoard[55].setPiece(new OneSidedMirror(Team.BLACK, Angle.ONEEIGHTY));
			gameBoard[54].setPiece(new Defender(Team.BLACK, Angle.ZERO));
			gameBoard[53].setPiece(new TwoSidedMirror(Team.BLACK, Angle.NINETY));
			gameBoard[49].setPiece(new OneSidedMirror(Team.BLACK, Angle.NINETY));
			gameBoard[47].setPiece(new TwoSidedMirror(Team.BLACK, Angle.ZERO));
			gameBoard[36].setPiece(new OneSidedMirror(Team.BLACK, Angle.TWOSEVENTY));
			gameBoard[34].setPiece(new OneSidedMirror(Team.BLACK, Angle.NINETY));
			
		} else {
			System.out.println("Invalid Game Type. Board not set.");
		}
	}
}