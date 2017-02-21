package castle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import castle.Room;
import handler.*;
import role.*;

public class Game {
	
	private HashMap<String, handler> handler = new HashMap<String, handler>();
	private  ArrayList<Room> theRooms = new ArrayList<Room>();
    private Room currentRoom;
    private Player player;


//    ���췽��
    public Game()
    {
        createRooms();
        handler.put("help", new handlerHelp(this));
        handler.put("go", new handlerGo(this));
        handler.put("bye", new handlerBye(this));
        handler.put("state", new handlerState(this));
        handler.put("fight", new handlerFight(this));
        handler.put("sleep", new handlerSleep(this));
 
    }

    private void createRooms()
    {

    	Room outside, lobby, pub, libary, hotel, bedroom;

        //	���췿��
        theRooms.add(outside= new Room("�Ǳ���","�������͵�С͵ͷĿ",		10,6,3,1,"�ڷ����ĳǱ�С͵���Ѿ�����������"));
        theRooms.add(lobby  = new Room("һ¥����","�߹�Ĺܼ�",	100,15,12,5,"�ܼ����΢Ц�ؿ�����"));
        theRooms.add(pub    = new Room("С�ư�","�������ϰ���",		150,10,5,3,"�ϰ����������˸�����,������Ķ�����"));
        theRooms.add(libary = new Room("�鷿","���ε�����",		100,7,5,2,"�������ʵĶ������·�������Ļ���..."));
        theRooms.add(hotel 	= new Room("����","���ɵ�Ů��",			120,6,5,1,"�㾲���ؿ���Ů�ͣ����룺�Ǹúúõ�˯һ����zzz"));
        theRooms.add(bedroom= new Room("��¥˯��","�����Ĺܼ�",		300,20,5,15,"������:�������ڽ����ˣ����۰�����Ҫ������˯һ��"));

        outside.setExit("east", lobby);
        outside.setExit("south",libary);
        outside.setExit("west", pub);
        lobby.	setExit("west",	outside);
        pub.	setExit("east",	outside);
        libary.	setExit("north",outside);
        libary.	setExit("east", hotel);
        hotel.	setExit("west",	libary);
        lobby.	setExit("up", 	bedroom);
        bedroom.setExit("down", lobby);

        currentRoom = outside;
    }
    private void printWelcome() {
        System.out.println();
        System.out.println("��ӭ�����Ǳ���");
        System.out.println("����һ���������ĵ���Ϸ��");
        System.out.println("����������Ҳ����ᵽ��Ȥ��");
        System.out.println("ף����Ϸ��죡");
        System.out.println("�����������֣�");
        Scanner name = new Scanner(System.in);
        player = new Player(name.nextLine(),200,10,5);
        System.out.println("��ã� "+player);
        System.out.println("�����Ҫ������������ 'help' ");
        System.out.print("����");
        currentRoom.showPrompt();
    }
//    ����
    public void goRoom(String direction)
    {
    	if( currentRoom.CheckExit(direction) )
		{
    		currentRoom = currentRoom.showRoom(direction);
		}
    	else
    	{
    		System.out.println("û��������ڡ�");
    	}
		currentRoom.showPrompt();
    }
//  ս������
  public void Fight() {
//  	��Ѫ��ֵ��ԭ����
  	player = currentRoom.fightBoss(player);
  	if(player.getBlood()>0)
  	currentRoom.showPrompt();
	}
//   ����Ƿ������Ϣ
    public boolean TreatRoomCheck() {
    	return (currentRoom.equals("����")||currentRoom.equals("����"));
	}
//    ��ʾ��ҵ�ǰ����
    public String PLayerToString() {
    	return player.stateToString();
	}
//  ָ�������Ĳ�Ѫ
  public void Treat(int bloodMore) {
  	player.setBlood(player.getBlood() + bloodMore);
	}
//  ����
  public boolean Treat() {
  	if( player.getBlood() <= 120 )
  	{
  		player.setBlood(120);
  		return true;
  	}
  	else
  	{
  		return false;
  	}
	}
//    ����BOSS�Ƿ񱻴�ܹ�
    public boolean BossGetItem() {
		return currentRoom.BossGetItem();
	}
//	    ��Ϸ���У�����ָ��
    private void gameRun() {
    	String line;
		Scanner in = new Scanner(System.in);
		while ( player.getBlood()>0 ) {
			
			System.out.print("������ָ�");
			
			line = in.nextLine();
			String[] words = line.split(" ");
			
			handler handler1 = handler.get(words[0]);
			String value2 = "";
			
			if( words.length > 1 )
			{
				value2 = words[1];
			}
			if( handler1 != null )
			{
				handler1.DoFunc(value2);
				if( handler1.Bye() )
					break;
			}
			else
			{
				System.out.println("�Բ�������ָ�����");
			}
			
		}
		in.close();
    }
	
	public static void main(String[] args) {
		
		Game game = new Game();
		game.printWelcome();
		game.gameRun();
      
        
        System.out.println("�˳���Ϸ���ټ���");
       
	}

}
