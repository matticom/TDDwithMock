package customer;

import Euro.Euro;

public interface IStatement {
	public void printCustomerName(String name);
	public void printTotalCharge();
	public void printMovieTitle(String title);
	public void printMovieCharge(Euro charge);
}
