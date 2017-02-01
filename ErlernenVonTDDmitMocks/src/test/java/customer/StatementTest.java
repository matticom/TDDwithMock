package customer;

import org.easymock.MockControl;
import org.junit.Test;

public class StatementTest {
	
	@Test
	public void testCustomer() {
		MockControl controlStatement = MockControl.createControl(IStatement.class);
		IStatement mockStatement = (IStatement) controlStatement.getMock();
		mockStatement.printCustomerName("Zing Zang Zong");
		mockStatement.printTotalCharge();
		
		MockControl controlRental = MockControl.createControl(IRental.class);
		IRental mockRental = (IRental) controlRental.getMock();
		mockRental.printOn(mockStatement);
		
		controlStatement.replay();
		controlRental.replay();
		
		Customer customer = new Customer("Zing Zang Zong");
		customer.addRental(mockRental);
		customer.printOn(mockStatement);
		controlStatement.verify();
		controlRental.verify();
	}
}