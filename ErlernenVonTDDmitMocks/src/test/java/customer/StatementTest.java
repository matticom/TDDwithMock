package customer;

import org.easymock.MockControl;
import org.junit.Before;
import org.junit.Test;

import Euro.Euro;

public class StatementTest {

	private MockControl controlStatement;
	private IStatement mockStatement;
	private MockControl controlRental;
	private IRental mockRental;
	private MockControl controlPrice;
	private IPrice mockPrice;

	@Before
	public void setUp() {
		controlStatement = MockControl.createControl(IStatement.class);
		mockStatement = (IStatement) controlStatement.getMock();
		controlRental = MockControl.createControl(IRental.class);
		mockRental = (IRental) controlRental.getMock();
		controlPrice = MockControl.createControl(IPrice.class);
		mockPrice = (IPrice) controlPrice.getMock();
	}

	@Test
	public void testCustomer() {
		mockStatement.printCustomerName("Zing Zang Zong");
		mockStatement.printTotalCharge();

		mockRental.printOn(mockStatement);

		controlStatement.replay();
		controlRental.replay();

		Customer customer = new Customer("Zing Zang Zong");
		customer.addRental(mockRental);
		customer.printOn(mockStatement);
		controlStatement.verify();
		controlRental.verify();
	}

	@Test
	public void testRental() {
		mockStatement.printMovieTitle("Amelie");
		mockPrice.printOn(mockStatement, 1);

		controlStatement.replay();
		controlPrice.replay();

		new Rental("Amelie", mockPrice, 1).printOn(mockStatement);

		controlStatement.verify();
		controlPrice.verify();
	}

	public void testBasePrice() {
		verifyPrice(1.50, 1);
		verifyPrice(1.50, 3);
	}

	public void testIncrementalPrice() {
		verifyPrice(3.00, 4);
		verifyPrice(7.50, 7);
	}

	private void verifyPrice(double charge, int daysRented) {
		mockStatement.printMovieCharge(new Euro(charge));
		controlStatement.replay();
		new Price().printOn(mockStatement, daysRented);
		controlStatement.verify();
		controlStatement.reset();
	}
}