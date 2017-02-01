package customer;

import java.util.ArrayList;
import java.util.List;

public class Customer {

	private String name;
	private List<IRental> rentalList;

	public Customer(String name) {
		this.name = name;
		rentalList = new ArrayList<IRental>();
	}

	public void addRental(IRental rental) {
		rentalList.add(rental);
	}

	public void printOn(IStatement statement) {
		statement.printCustomerName(name);
		printRentalsOn(statement);
		statement.printTotalCharge();
	}

	private void printRentalsOn(IStatement statement) {
		for (IRental rental : rentalList) {
			rental.printOn(statement);
		}
	}
}
