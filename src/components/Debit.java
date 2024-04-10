package components;

import java.time.LocalDate;

public class Debit extends Flow {

	public Debit(String comment, double amount, int accountNr, boolean effect, LocalDate date) {
		super(comment, amount, accountNr, effect, date);
	}

}

