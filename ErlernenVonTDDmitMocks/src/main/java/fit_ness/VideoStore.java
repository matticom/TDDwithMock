package fit_ness;

import java.util.HashMap;
import java.util.Map;

import customer.Movie;
import customer.Price;

public class VideoStore {
	private Map<Integer, Movie> movies = new HashMap<Integer, Movie>();

	public Movie newMovie(int number, String title, String category) {
		Price price = Price.getPrice(category);
		Movie movie = new Movie(title, price);
		Integer key = new Integer(number);
		movies.put(key, movie);
		return movie;
	}

	public Movie getMovie(int number) {
		Integer key = new Integer(number);
		return (Movie) movies.get(key);
	}
}
