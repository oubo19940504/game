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
				System.out.println("Ů��˳�ӵ�����������硣��Ϣ��.....");
			    for(int i = 0; i < 8; i ++ ) {
			    	SleepTime(250);
			    }
				if( game.Treat() )
				{
					System.out.println("һ������������ˬ����о��������ܸɵ�һͷţ�������ָ���120.");
				}
				else
				{
					System.out.println("���꣬���ڶ����𣿾�����ô����Ͽ�ȥ��ɼ���boss��");
				}
			}
			else
			{
				System.out.println("��Ȼ�����,����û�취���䱻Ů��ռ���ˡ�����");
				System.out.println("��������꣬�������������֡�");
			}
		}
		else
		{
			System.out.println("ֻ�б��ݻ����Ҳ���������Ϣ");
		}
	}
	
	public void SleepTime(int time) {
		try   
	    {   
		    Thread.currentThread();
			Thread.sleep(time);  
	    }  
	    catch(Exception e){}
		System.out.print("��");
	}

}
