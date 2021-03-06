package castle;

import java.util.ArrayList;
import java.util.HashMap;
import role.*;

public class Room {

	private Boss Boss = null;
	private String description;
	private HashMap<String, Room> exits = new HashMap<String, Room>();
	private ArrayList<Boss> role = new ArrayList<Boss>();
//构造方法

    public Room(String description) {
    	this.description = description;
    }
    
    public Room(String description, String BossName, int blood, int strike, int miss, int experience, String dieText) {	
    	this.description = description;
    	Boss = new Boss(BossName,blood,strike,miss,experience,dieText);
    	role.add(Boss);
    }
//    设置一个出口。
    public void setExit(String str,Room room){
    	exits.put(str, room);
    }
//   显示房间的详情。
    public void showPrompt() {
    	StringBuffer sb = new StringBuffer();
    	String ifaBoss = "这里安全。";
    	System.out.println("你在" + this.description);
		System.out.print("出口有: ");
		for ( String str : exits.keySet() ){
			sb.append(str+' ');
		}
        System.out.println(sb);
        if(Boss != null) {
        	if( Boss.IfGet())
        	{
        		ifaBoss = "这里的Boss是"+Boss+",你大吼一声：我不会怕你的！";
        	}
        	else
        	{
        		ifaBoss = "这里的Boss是"+Boss+",已经被你打败过啦";
        	}
        }
        System.out.println(ifaBoss);
    }
//   使用此类的返回值，赋给原本的Room。
    public Room showRoom(String direction) {
	    return exits.get(direction);
    }
//   战斗函数
    public Player fightBoss(Player player) {
		return Boss.fight(player);
	}
//    返回房间名
    @Override
    public String toString()
    {
        return description;
    }
//    检查房间名
    @Override
	public boolean equals(Object anotherOne) {
		return description.equals(anotherOne);
	}
//    检查Boss是否已经被挑战过
    public boolean BossGetItem() {
		return Boss.IfGet();
	}
    
    public boolean CheckExit(String exit) {
    	return exits.containsKey(exit);
	}
}