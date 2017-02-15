package fit_ness;

import java.util.HashMap;
import java.util.Map;

import customer.Price;

public class Prices {
	static private Map<String, Price> prices = new HashMap<String, Price>();
	static {
		prices.put("regular price", Price.REGULAR);
		prices.put("new release", Price.NEWRELEASE);
	}

	public static Price getPrice(String category) {
		return (Price) prices.get(category);
	}
}
