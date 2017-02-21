package handler;

import castle.Game;

public class handler {
	
	protected Game game;
	
	public handler(Game game) {
		this.game = game;
	}
	
	protected handler() {}
	
	public boolean Bye(){return false;}
	public void DoFunc(String cmd){}

}
