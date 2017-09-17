package com.layzers.players;

import com.layzers.pieces.Piece.Team;

public class Player {
	private final String playerName;
	private final Team playerTeam;
	
	public Player(String playerName, Team playerTeam){
		this.playerName = playerName;
		this.playerTeam = playerTeam;
	}
	
	public String getName(){
		return this.playerName;
	}
	
	public Team getTeam(){
		return this.playerTeam;
	}
	
	public int getSphinxPosition(){
		if(this.playerTeam == Team.BLACK){
			return 79;
		} else if(this.playerTeam == Team.WHITE){
			return 0;
		} else {
			return -1;
		}
	}
}