package castle;

import java.util.ArrayList;
import java.util.HashMap;
import role.*;

public class Room {

	private Boss Boss = null;
	private String description;
	private HashMap<String, Room> exits = new HashMap<String, Room>();
	private ArrayList<Boss> role = new ArrayList<Boss>();
//���췽��

    public Room(String description) {
    	this.description = description;
    }
    
    public Room(String description, String BossName, int blood, int strike, int miss, int experience, String dieText) {	
    	this.description = description;
    	Boss = new Boss(BossName,blood,strike,miss,experience,dieText);
    	role.add(Boss);
    }
//    ����һ�����ڡ�
    public void setExit(String str,Room room){
    	exits.put(str, room);
    }
//   ��ʾ��������顣
    public void showPrompt() {
    	StringBuffer sb = new StringBuffer();
    	String ifaBoss = "���ﰲȫ��";
    	System.out.println("����" + this.description);
		System.out.print("������: ");
		for ( String str : exits.keySet() ){
			sb.append(str+' ');
		}
        System.out.println(sb);
        if(Boss != null) {
        	if( Boss.IfGet())
        	{
        		ifaBoss = "�����Boss��"+Boss+",����һ�����Ҳ�������ģ�";
        	}
        	else
        	{
        		ifaBoss = "�����Boss��"+Boss+",�Ѿ������ܹ���";
        	}
        }
        System.out.println(ifaBoss);
    }
//   ʹ�ô���ķ���ֵ������ԭ����Room��
    public Room showRoom(String direction) {
	    return exits.get(direction);
    }
//   ս������
    public Player fightBoss(Player player) {
		return Boss.fight(player);
	}
//    ���ط�����
    @Override
    public String toString()
    {
        return description;
    }
//    ��鷿����
    @Override
	public boolean equals(Object anotherOne) {
		return description.equals(anotherOne);
	}
//    ���Boss�Ƿ��Ѿ�����ս��
    public boolean BossGetItem() {
		return Boss.IfGet();
	}
    
    public boolean CheckExit(String exit) {
    	return exits.containsKey(exit);
	}
}