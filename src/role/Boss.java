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
		this.dieText  = name + "跪着向你哀求，不过你残忍地杀死了他！并且抢夺了他的经验";
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
//			打不过
		if( Beat <= 0 ){
			player.setBlood(player.getBlood() - 10);
			System.out.println("你的攻击力小于"+this.name+"的防御力！\n落荒而逃！损失10点体力值！");
		}
		else
		{
			while(survive){
//					互相扣血
				this.setBlood(this.getBlood() - Beat);
				player.setBlood(player.getBlood() - beBeat);
//					判断
				if( player.getBlood() <= 0 ){
					
					bloodsave2 -= 5;
					player.setBlood(bloodsave2);

					this.setBlood(bloodsave);
					System.out.println("以你现有的体力值无法打倒"+this.name+"！\n落荒而逃！损失5点体力值！");
					break;
				}
				if( this.getBlood() <= 0 ){
//						先把血补回去
					this.setBlood(bloodsave);
					System.out.println(dieText+"\n胜利而归！你还剩"+player.getBlood()+"点体力值！");
					System.out.println("本次战斗获得了"+player.win(GetExperience())+"点经验值！");
					survive = false;
					getItem = false;
					handlerSleep sleep = new handlerSleep();
					System.out.print("战斗结束");
					for( int i = 800; i >= 0; i -= 100 )
					{
						sleep.SleepTime(i);
					}
					System.out.println();
				}
			}
		}
		if(player.getBlood()<=0){
			System.out.println("您的体力值不足您已死亡！");
			System.out.println("由于游戏设计不全，你无法保存游戏，将退出游戏！");	
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
			System.out.println("Boss挑战成功，获得挑战奖励和额外5点经验奖励！");
			return (this.experience+5);
		}
		else
		{
			return this.experience;
		}
	}

}
