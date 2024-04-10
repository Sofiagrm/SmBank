package components;

import java.time.LocalDate;

public class Credit extends Flow {

	public Credit(String comment, double amount, int accountNr, boolean effect, LocalDate date) {
		super(comment, amount, accountNr, effect, date);
	}

}
