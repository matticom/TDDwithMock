package fit_ness;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VideoStore {
	private Map<Integer, Movie> movies = new HashMap<Integer, Movie>();
	private NumberSequence sequence = new NumberSequence();

	public Movie newMovie(int number, String title, String category) throws MovieNumberAlreadyInUseException {
		if (getMovie(number) != null)
			throw new MovieNumberAlreadyInUseException(number);
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

	public int nextMovieNumber() {
		return sequence.nextNumber();
	}

	private List<Rental> rentals = new ArrayList<Rental>();

	public Rental addRental(int movieNumber, int daysRented) throws UnknownMovieException, MinRentedDaysException {
		Movie movie = getMovie(movieNumber);
		if (movie == null)
			throw new UnknownMovieException(movieNumber);
		if (daysRented < 1)
			throw new MinRentedDaysException(daysRented); 
		Rental rental = new Rental(movie, daysRented);
		rentals.add(rental);
		return rental;
	}

	public int numberOfRentals() {
		return rentals.size();
	}
}
