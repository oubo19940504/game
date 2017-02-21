package handler;

import castle.Game;


public class handlerState extends handler {
	
	public handlerState(Game game) {
		super(game);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void DoFunc(String cmd) {
		// TODO Auto-generated method stub
		System.out.println(game.PLayerToString());
	}

}
