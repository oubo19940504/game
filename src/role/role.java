package role;

public class role {

	/**
	 * @param args
	 */
	protected String name = "";
	private int blood = 0;
	protected int strike = 0;
	protected int miss = 0;
	protected int experience=0 ;
	
	public role(String name, int blood, int strike, int miss) {
		this.name = name;
		this.setBlood(blood);
		this.strike = strike;
		this.miss = miss;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public boolean IfGet() {
		// TODO Auto-generated method stub
		return false;
	}

	public Player fight(Player player) {
		// TODO Auto-generated method stub
		return null;
	}

	public String stateToString() {
		// TODO Auto-generated method stub
		return null;
	}

	public int getBlood() {
		return blood;
	}

	public void setBlood(int blood) {
		this.blood = blood;
	}

}
