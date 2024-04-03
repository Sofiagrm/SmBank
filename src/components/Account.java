package components;

public abstract class Account {
	
	private String label;
	private double balance = 0;
	private int accountNumber;
	private Client client;
	
	private static int nrOfAccounts = 0;	
	
	
	public Account(String label, Client client) {
		this.label = label;
		this.client = client;
		this.accountNumber = Account.nrOfAccounts;
		
		Account.nrOfAccounts += 1;
	}
	
	public String getLabel () {
		return this.label;
	}
	
	public void setLabel (String newLabel) {
		this.label = newLabel;
	}

	public double getBalance () {
		return this.balance;
	}
	
	public void setBalance (double newBalance) {
		this.balance = newBalance;
	}
	
	public Client getClient () {
		return this.client;
	}

	public void setClient (Client newClient) {
		this.client = newClient;
	}
	
	public int getaccountNumber () {
		return this.accountNumber;
	}
	
	/*
	 * Account ordem
	 * Nr; 1
	 * Owner :
	 * Client nr
	 * name
	 * first name
	 * balance: 0.0
	 */
	
	public String toString() {
		String newLine = System.getProperty("line.separator");
		
	    return "Account Numnber : " + this.accountNumber + ""
	    		.concat(newLine)
	            .concat("Account Label  : " + this.label)
	            .concat(newLine)
	            .concat("Owner : ")
	            .concat(newLine)
	            .concat(this.client.toString())
	            .concat(newLine)
	            .concat("  balance : " + this.balance)
	            .concat(newLine)
	            .concat("--------------------");

	}
	
}
	
	