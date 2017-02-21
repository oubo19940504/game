package handler;

import castle.Game;

public class handlerSleep extends handler {

	public handlerSleep(Game game) {
		super(game);
		// TODO Auto-generated constructor stub
	}

	public handlerSleep() {}

	@Override
	public void DoFunc(String cmd) {
		if( game.TreatRoomCheck() )
		{
			if( !game.BossGetItem() )
			{
				System.out.println("女仆顺从地送你进入梦乡。休息中.....");
			    for(int i = 0; i < 8; i ++ ) {
			    	SleepTime(250);
			    }
				if( game.Treat() )
				{
					System.out.println("一觉醒来神清气爽，你感觉你现在能干掉一头牛，体力恢复至120.");
				}
				else
				{
					System.out.println("少年，你在逗我吗？精力这么充沛赶快去多干几个boss吧");
				}
			}
			else
			{
				System.out.println("虽然你很累,但是没办法房间被女仆占有了。。。");
				System.out.println("打败她少年，美梦在向你招手。");
			}
		}
		else
		{
			System.out.println("只有宾馆或卧室才能用来休息");
		}
	}
	
	public void SleepTime(int time) {
		try   
	    {   
		    Thread.currentThread();
			Thread.sleep(time);  
	    }  
	    catch(Exception e){}
		System.out.print("。");
	}

}
