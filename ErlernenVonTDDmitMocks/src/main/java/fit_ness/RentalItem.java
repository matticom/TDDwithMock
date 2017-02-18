package fit_ness;

import Euro.Euro;

public class RentalItem {
	public int movieNumber;
	public String movieTitle;
	public int totalDaysRented = 0;
	private Euro totalCharge = new Euro(0.00);

	public RentalItem(Movie movie) {
		movieNumber = movie.getNumber();
		movieTitle = movie.getTitle();
	}

	public void addRental(Rental rental) {
		totalDaysRented += rental.getDaysRented();
		totalCharge = totalCharge.plus(rental.getCharge());
	}

	public String movieTitle() {
		return movieTitle;
	}

	public int movieNumber() {
		return movieNumber;
	}

	public int totalDaysRented() {
		return totalDaysRented;
	}

	public double totalCharge() {
		return totalCharge.getAmount();
	}
}
