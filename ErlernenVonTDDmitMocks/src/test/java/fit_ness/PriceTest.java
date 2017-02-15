package fit_ness;

import static org.junit.Assert.*;

import org.junit.Test;

import customer.Price;

public class PriceTest {

	@Test
	public void testRegularPrice() {
		Price price = Price.getPrice("regular price");
		assertSame(Price.REGULAR, price);
	}

	@Test
	public void testNewRelease() {
		Price price = Prices.getPrice("new release");
		assertSame(Price.NEWRELEASE, price);
	}

	@Test
	public void testUnknownCategory() {
		assertNull(Price.getPrice("unknown"));
	}
}
