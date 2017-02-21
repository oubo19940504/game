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


//    构造方法
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

        //	制造房间
        theRooms.add(outside= new Room("城堡外","富得流油的小偷头目",		10,6,3,1,"在繁华的城堡小偷都已经富的流油了"));
        theRooms.add(lobby  = new Room("一楼大堂","高贵的管家",	100,15,12,5,"管家面带微笑地看着您"));
        theRooms.add(pub    = new Room("小酒吧","美丽的老板娘",		150,10,5,3,"老板娘向你抛了个媚眼,你觉得心都软化了"));
        theRooms.add(libary = new Room("书房","俊俏的书生",		100,7,5,2,"书生朗朗的读书声仿佛勾起了你的回忆..."));
        theRooms.add(hotel 	= new Room("宾馆","乖巧的女仆",			120,6,5,1,"你静静地看着女仆，心想：是该好好地睡一觉了zzz"));
        theRooms.add(bedroom= new Room("二楼睡房","公主的管家",		300,20,5,15,"你心想:啊，终于结束了，好累啊！我要美美地睡一觉"));

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
        System.out.println("欢迎来到城堡！");
        System.out.println("这是一个超级无聊的游戏。");
        System.out.println("但无聊中您也能体会到乐趣！");
        System.out.println("祝您游戏愉快！");
        System.out.println("请键入你的名字：");
        Scanner name = new Scanner(System.in);
        player = new Player(name.nextLine(),200,10,5);
        System.out.println("你好！ "+player);
        System.out.println("如果需要帮助，请输入 'help' ");
        System.out.print("现在");
        currentRoom.showPrompt();
    }
//    到达
    public void goRoom(String direction)
    {
    	if( currentRoom.CheckExit(direction) )
		{
    		currentRoom = currentRoom.showRoom(direction);
		}
    	else
    	{
    		System.out.println("没有这个出口。");
    	}
		currentRoom.showPrompt();
    }
//  战斗函数
  public void Fight() {
//  	减血赋值给原来的
  	player = currentRoom.fightBoss(player);
  	if(player.getBlood()>0)
  	currentRoom.showPrompt();
	}
//   检查是否可以休息
    public boolean TreatRoomCheck() {
    	return (currentRoom.equals("宾馆")||currentRoom.equals("卧室"));
	}
//    显示玩家当前属性
    public String PLayerToString() {
    	return player.stateToString();
	}
//  指定数量的补血
  public void Treat(int bloodMore) {
  	player.setBlood(player.getBlood() + bloodMore);
	}
//  补满
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
//    返回BOSS是否被打败过
    public boolean BossGetItem() {
		return currentRoom.BossGetItem();
	}
//	    游戏运行，接受指令
    private void gameRun() {
    	String line;
		Scanner in = new Scanner(System.in);
		while ( player.getBlood()>0 ) {
			
			System.out.print("请输入指令：");
			
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
				System.out.println("对不起，输入指令错误！");
			}
			
		}
		in.close();
    }
	
	public static void main(String[] args) {
		
		Game game = new Game();
		game.printWelcome();
		game.gameRun();
      
        
        System.out.println("退出游戏。再见！");
       
	}

}
