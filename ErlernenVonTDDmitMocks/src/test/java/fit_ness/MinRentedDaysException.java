package fit_ness;

public class MinRentedDaysException extends Exception {
	private int daysRented;

	public MinRentedDaysException(int daysRented) {
		this.daysRented = daysRented;
	}

	public String getMessage() {
		return "less than one day rented: " + daysRented;
	}

	public int getdaysRented() {
		return daysRented;
	}
}
