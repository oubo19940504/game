package handler;

import castle.Game;

public class handlerFight extends handler {
	
	public handlerFight(Game game) {
		super(game);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void DoFunc(String cmd) {
		game.Fight();
	}

}
