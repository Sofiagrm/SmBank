package components;

public abstract class Flow {
	private String comment = "";
	private int identifier;
	private double amount;
	private int accountNr;
	private boolean effect;
	private long date;
	
	private static int nrOfFlows = 0;
	
	Flow (String comment, double amount, int accountNr, boolean effect) {
		this.comment = comment;
		this.amount = amount;
		this.accountNr = accountNr;
		this.effect = effect;
		this.date = System.currentTimeMillis();
		
		this.accountNr = Flow.nrOfFlows;
		
		Flow.nrOfFlows += 1;
	}

	/**
	 * @return the comment
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * @param comment the comment to set
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}

	/**
	 * @return the identifier
	 */
	public int getIdentifier() {
		return identifier;
	}

	/**
	 * @param identifier the identifier to set
	 */
	public void setIdentifier(int identifier) {
		this.identifier = identifier;
	}

	/**
	 * @return the amount
	 */
	public double getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(double amount) {
		this.amount = amount;
	}

	/**
	 * @return the accountNr
	 */
	public int getAccountNr() {
		return accountNr;
	}

	/**
	 * @param accountNr the accountNr to set
	 */
	public void setAccountNr(int accountNr) {
		this.accountNr = accountNr;
	}

	/**
	 * @return the effect
	 */
	public boolean isEffect() {
		return effect;
	}

	/**
	 * @param effect the effect to set
	 */
	public void setEffect(boolean effect) {
		this.effect = effect;
	}

	/**
	 * @return the date
	 */
	public long getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(long date) {
		this.date = date;
	}

}
