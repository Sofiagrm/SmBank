// 1.2.1 Creation of the Account class

package components;

import java.util.Random;

public abstract class Account implements Comparable<Account>{
	
	protected String label;
	protected double balance = 0.0;
	protected int accountNumber;
	protected Client client;
	
	private static int nrOfAccounts = 0;	
	
	
	public Account(String label, Client client) {
		this.label = label;
		this.client = client;
		
		//generate random balance between 50 and 100
		Random r = new Random();
		double randomValue = (-50) + (50 - (-50)) * r.nextDouble();
		this.balance = randomValue;
		
		this.accountNumber = Account.nrOfAccounts;
		
		Account.nrOfAccounts += 1;
	}
	
	public static void resetNrOfAccounts () {
		Account.nrOfAccounts = 0;
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
	
	public void setBalance (Flow flow) {
		if(Debit.class == flow.getClass()) {
			this.balance = this.balance - flow.getAmount();
		}
		else if(Credit.class == flow.getClass()) {
			this.balance = this.balance + flow.getAmount();
		}
		else {
			if (this.accountNumber == ((Transfer)flow).getIssuingAccountNr()) {
				this.balance = this.balance - flow.getAmount();
			}
			else if (this.accountNumber == ((Transfer)flow).getAccountNr() )  {
				this.balance = this.balance + flow.getAmount();
			}
		}
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
	
    // overriding the compareTo method of Comparable class
    @Override 
    public int compareTo(Account AccountToCompare) {
        double balance_to_compare = ((Account)AccountToCompare).getBalance();
        
        int to_return = 0;
        
        if (this.balance > balance_to_compare) {
        	to_return = 1;
        }
        else if (this.balance < balance_to_compare) {
        	to_return = -1;
        }
        
 
        return to_return;
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
	            .concat("Account Owner : ")
	            .concat(newLine)
	            .concat(this.client.toString())
	            .concat(newLine)
	            .concat("  Account balance : " + this.balance)
	            .concat(newLine)
	            .concat("--------------------");

	}
	
}
	
	