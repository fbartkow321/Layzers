package com.layzers.rules;

public abstract class Move {
	
	public enum MoveType{RELOCATION, ROTATION}
	
	public abstract void executeMove();
	
	public abstract MoveType getMoveType();
}