package role;

public class Player extends role {
	
	private int level = 0;
	protected int[] limit = new int[11];
	
	public Player(String name, int blood, int strike, int miss) {
		super(name, blood, strike, miss);
		limit[0] = 5;
		limit[1] = 10;
		limit[2] = 30;
		limit[3] = 50;
		limit[4] = 80;
		limit[5] = 120;
		limit[6] = 160;
		limit[7] = 200;
		limit[8] = 250;
		limit[9] = 320;
		limit[10] = 999999;
	}
	public int getStrike() {
		return strike;
	}
	public int getMiss() {
		return miss;
	}

	public String stateToString() {
		return "�ȼ���"+(level+1)+"\n����ֵ��"+experience+"/"+limit[level]+"\n������"+name+"\n������"+strike+"\n������"+miss+"\n����ֵ��"+getBlood();
	}

	@Override
	public String toString() {
		return name;
	}
	
	public int win(int experience) {
		this.experience += experience;
		if( this.experience >= limit[level] )
		{
			this.experience -= limit[level];
			level ++;
			strike += level*2;
			miss += level*2;
			setBlood(getBlood() + level*20);
			System.out.println("��ϲ��������~\\(�R���Q)/~������\n�������Լӳ�Ŷ~");
		}
		return experience;
	}
}
