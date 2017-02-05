package customer;

import Euro.Euro;

public class Price implements IPrice {

	public final static Price NEWRELEASE = new Price(new Euro(2.00), new Euro(1.75), 2);
	public final static Price REGULAR = new Price(new Euro(1.50), new Euro(1.50), 3);

	private Euro basePrice;
	private Euro pricePerDay;
	private int daysDiscounted;

	public Price() {
		basePrice = new Euro(1.50);
		pricePerDay = new Euro(1.50);
		daysDiscounted = 3;
	}

	public Price(Euro basePrice, Euro pricePerDay, int daysDiscounted) {
		this.basePrice = basePrice;
		this.pricePerDay = pricePerDay;
		this.daysDiscounted = daysDiscounted;
	}

	@Override
	public Euro getCharge(int daysRented) {
		if (daysRented <= daysDiscounted)
			return basePrice;
		int additionalDays = daysRented - daysDiscounted;
		return basePrice.plus(pricePerDay.times(additionalDays));
	}

	@Override
	public void printOn(IStatement statement, int daysRented) {
		Euro flat = new Euro(1.50);
		Euro incremental = new Euro(1.50).times(daysRented - 2);
		statement.printMovieCharge(Euro.max(flat, incremental));
	}

	public static Price getPrice(String category) {
		return "regular price".equals(category) ? Price.REGULAR : null;
	}

}
