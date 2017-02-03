package customer;

import java.util.HashMap;
import java.util.Map;

public class Videostore {
	private Customer customer;
	private static Map<String, Customer> customers = new HashMap<String, Customer>();
	
	private Videostore(Customer customer) {
		this.customer = customer;
	}
	
	public static Videostore bindCustomer(String name) {
		if (!customers.containsKey(name)) {
			customers.put(name, new Customer(name));
		}
		Customer customer = customers.get(name);
		return new Videostore(customer);
	}

	public void rentMovie(String movieTitle, int daysRented) {
		IPrice price = new Price();
		IRental rental = new Rental(movieTitle, price, daysRented);
		customer.addRental(rental);
	}

	public void printStatement() {
		IPrinter printer = new Printer();
		IStatement statement = new Statement(printer);
		customer.printOn(statement);
	}

}
