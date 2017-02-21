package role;

import handler.handlerSleep;

public class Boss extends role {
	private String dieText = "";

	boolean survive = true;
	boolean getItem = true;
	
	public Boss(String name, int blood, int strike, int miss, int experience,
			String dieText) {
		super(name, blood, strike, miss);
		this.experience=experience;
		this.dieText  = name + "�������㰧�󣬲�������̵�ɱ���������������������ľ���";
	}
	@Override
	public Player fight(Player player) {

		int bloodsave = this.getBlood();
		int bloodsave2 = player.getBlood();
		int beBeat = (this.strike - player.miss);
		int Beat = (player.strike - this.miss);

		if( beBeat <= 0 ) {
			beBeat = 0;
		}
//			�򲻹�
		if( Beat <= 0 ){
			player.setBlood(player.getBlood() - 10);
			System.out.println("��Ĺ�����С��"+this.name+"�ķ�������\n��Ķ��ӣ���ʧ10������ֵ��");
		}
		else
		{
			while(survive){
//					�����Ѫ
				this.setBlood(this.getBlood() - Beat);
				player.setBlood(player.getBlood() - beBeat);
//					�ж�
				if( player.getBlood() <= 0 ){
					
					bloodsave2 -= 5;
					player.setBlood(bloodsave2);

					this.setBlood(bloodsave);
					System.out.println("�������е�����ֵ�޷���"+this.name+"��\n��Ķ��ӣ���ʧ5������ֵ��");
					break;
				}
				if( this.getBlood() <= 0 ){
//						�Ȱ�Ѫ����ȥ
					this.setBlood(bloodsave);
					System.out.println(dieText+"\nʤ�����飡�㻹ʣ"+player.getBlood()+"������ֵ��");
					System.out.println("����ս�������"+player.win(GetExperience())+"�㾭��ֵ��");
					survive = false;
					getItem = false;
					handlerSleep sleep = new handlerSleep();
					System.out.print("ս������");
					for( int i = 800; i >= 0; i -= 100 )
					{
						sleep.SleepTime(i);
					}
					System.out.println();
				}
			}
		}
		if(player.getBlood()<=0){
			System.out.println("��������ֵ��������������");
			System.out.println("������Ϸ��Ʋ�ȫ�����޷�������Ϸ�����˳���Ϸ��");	
		}
		survive = true;
		return player;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.name;
	}
	
	public boolean IfGet() {
		// TODO Auto-generated method stub
		return getItem;
	}
	
	public int GetExperience() {
		if( getItem )
		{
			System.out.println("Boss��ս�ɹ��������ս�����Ͷ���5�㾭�齱����");
			return (this.experience+5);
		}
		else
		{
			return this.experience;
		}
	}

}
