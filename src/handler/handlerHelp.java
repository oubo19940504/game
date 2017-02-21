package handler;

import castle.Game;

public class handlerHelp extends handler {

	public handlerHelp(Game game) {
		super(game);
		// TODO Auto-generated constructor stub
	}

	@Override
    public void DoFunc(String cmd)
    {
		 System.out.println("迷路了吗?以下是你可以做的：");
		 System.out.println("go    走           如：go east");
	     System.out.println("bye   退出");
	     System.out.println("help  寻求帮助");
	     System.out.println("fight  攻击敌人");
	     System.out.println("Sleep  休息       注：只有宾馆和睡房可以用来休息");
	     System.out.println("state  查看自身属性");
    }
}
