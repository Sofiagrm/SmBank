package components;

public class Transfer extends Flow{

	private int originAccountNr;
	
	Transfer(String comment, double amount, int accountNr, boolean effect, int originAccountNr) {
		super(comment, amount, accountNr, effect);
		
		this.setOriginAccountNr(originAccountNr);
	}

	public int getOriginAccountNr() {
		return originAccountNr;
	}

	public void setOriginAccountNr(int originAccountNr) {
		this.originAccountNr = originAccountNr;
	}

}
