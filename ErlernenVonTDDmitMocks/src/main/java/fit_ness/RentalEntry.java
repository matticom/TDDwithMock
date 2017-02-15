package fit_ness;

public class RentalEntry extends fit.ColumnFixture {
	private VideoStore store = SystemUnderTest.instance();
	public int movieNumber;
	public int daysRented;

	public double charge() throws Exception {
		Rental rental = store.addRental(movieNumber, daysRented);
		return rental.getCharge().getAmount();
	}
}
