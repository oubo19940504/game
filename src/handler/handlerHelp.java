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
		 System.out.println("��·����?��������������ģ�");
		 System.out.println("go    ��           �磺go east");
	     System.out.println("bye   �˳�");
	     System.out.println("help  Ѱ�����");
	     System.out.println("fight  ��������");
	     System.out.println("Sleep  ��Ϣ       ע��ֻ�б��ݺ�˯������������Ϣ");
	     System.out.println("state  �鿴��������");
    }
}
