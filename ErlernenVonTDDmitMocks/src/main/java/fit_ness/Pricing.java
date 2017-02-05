package fit_ness;

import customer.Price;

public class Pricing extends fit.ColumnFixture {
	public int daysRented;

	public double regularPrice() {
		return Price.REGULAR.getCharge(daysRented).getAmount();
	}

	public double newRelease() {
		return Price.NEWRELEASE.getCharge(daysRented).getAmount();
	}
}
