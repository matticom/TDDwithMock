package customer;

import Euro.Euro;

public class Price implements IPrice {

	@Override
	public void printOn(IStatement statement, int daysRented) {
		Euro flat = new Euro(1.50);
		Euro incremental = new Euro(1.50).times(daysRented - 2);
		statement.printMovieCharge(Euro.max(flat, incremental));
	}

}
