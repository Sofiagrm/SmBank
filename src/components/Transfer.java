package components;

import java.time.LocalDate;

public class Transfer extends Flow {

	private int issuingAccountNr;
	
	public Transfer(String comment, double amount, int accountNr, boolean effect, LocalDate date, int issuingAccountNr) {
		super(comment, amount, accountNr, effect, date);
		
		this.issuingAccountNr = issuingAccountNr;
	}

	public int getIssuingAccountNr() {
		return this.issuingAccountNr;
	}

	public void setIssuingAccountNr(int issuingAccountNr) {
		this.issuingAccountNr = issuingAccountNr;
	}
	
	public String toString() {
		String return_string = super.toString();
		
		return return_string.substring(0, return_string.length()-1) + ", issuingAccountNr=" + this.issuingAccountNr + "]";
	}

}
