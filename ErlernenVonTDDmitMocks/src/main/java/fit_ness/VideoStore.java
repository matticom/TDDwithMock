package fit_ness;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VideoStore {
	private Map<Integer, Movie> movies = new HashMap<Integer, Movie>();
	private NumberSequence sequence = new NumberSequence();
	private Map<Integer, RentalItem> items = new HashMap<Integer, RentalItem>();

	public Movie newMovie(int number, String title, String category) throws MovieNumberAlreadyInUseException {
		if (getMovie(number) != null)
			throw new MovieNumberAlreadyInUseException(number);
		Price price = Price.getPrice(category);
		Movie movie = new Movie(sequence.nextNumber(), title, price);
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
		addRentalItem(rental);
		rentals.add(rental);
		return rental;
	}

	public int numberOfRentals() {
		return rentals.size();
	}

	private void addRentalItem(Rental rental) {
		int movieNumber = rental.getMovieNumber();
		Integer key = new Integer(movieNumber);
		RentalItem item = items.get(key);
		if (item == null) {
			Movie movie = rental.getMovie();
			item = new RentalItem(movie);
			items.put(key, item);
		}
		item.addRental(rental);
	}

	public List<RentalItem> allRentalItems() {
		return new ArrayList<RentalItem>(items.values());
	}
}
