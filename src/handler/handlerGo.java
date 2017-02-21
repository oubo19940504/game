package handler;

import castle.Game;

public class handlerGo extends handler {

	public handlerGo(Game game) {
		super(game);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void DoFunc(String cmd) {
		// µ÷ÓÃÒÆ¶¯¡£
		game.goRoom(cmd);
	}

}
