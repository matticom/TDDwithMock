package customer;

import Euro.Euro;

public interface IPrice {
	public void printOn(IStatement statement, int daysRented);
	Euro getCharge(int daysRented);
}
