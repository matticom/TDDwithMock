package fit_ness;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class VideoStoreTest {

	@Test
	public void testMovieHandling() throws Exception {
		VideoStore store = new VideoStore();
		Movie movie = store.newMovie(1, "don’t care", "don’t care");
		assertSame(movie, store.getMovie(1));
		assertNotNull(movie);
	}

	@Test
	public void testRentalHandling() throws Exception {
		VideoStore store = new VideoStore();
		store.newMovie(7, "Seven Samurai", "regular price");
		Rental rental = store.addRental(7, 42);
		assertEquals("Seven Samurai", rental.getMovieTitle());
		assertEquals(1, store.numberOfRentals());
	}

	@Test
	public void testUnknownMovie() {
		VideoStore store = new VideoStore();
		try {
			store.addRental(42, 7);
			fail("renting an unknown movie should fail");
		} catch (UnknownMovieException expected) {
			assertEquals(42, expected.getMovieNumber());
			assertEquals(0, store.numberOfRentals());
		} catch (MinRentedDaysException expected) {
		}
	}

	@Test
	public void testDaysRentedLessThanOne() {
		VideoStore store = new VideoStore();
		try {
			store.addRental(2, 0);
			fail("renting less than one day should fail");
		} catch (MinRentedDaysException expected) {
			assertEquals(0, expected.getdaysRented());
			assertEquals(0, store.numberOfRentals());
		} catch (UnknownMovieException expected) {
		}
	}

	@Test
	public void testMovieNumberAlreadyInUse() throws Exception {
		VideoStore store = new VideoStore();
		Movie one = store.newMovie(1, "Rashomon", "don’t care");
		try {
			store.newMovie(1, "don’t care", "don't care");
			fail("movie number should have been assigned already");
		} catch (MovieNumberAlreadyInUseException expected) {
			assertSame(one, store.getMovie(1));
			assertEquals(1, expected.getMovieNumber());
		} catch (Exception ex) {
		}
	}

	@Test
	public void testChargeOfRental() throws Exception {
		VideoStore store = new VideoStore();
		store.newMovie(2, "Bla", "new release");
		Rental rental = store.addRental(2, 3);
		assertEquals(3.75, rental.getCharge().getAmount(), 0.01);
	}

	@Test
	public void testRentalItem() throws Exception {
		VideoStore store = new VideoStore();
		store.newMovie(1, "Koyaanisqatsi", "new release");
		store.addRental(1, 1);
		store.addRental(1, 3);
		List<RentalItem> items = store.allRentalItems();
		assertEquals(1, items.size());
		RentalItem item = items.get(0);
		assertEquals(1, item.movieNumber);
		assertEquals("Koyaanisqatsi", item.movieTitle);
		assertEquals(4, item.totalDaysRented);
	}
}
