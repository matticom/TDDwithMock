package fit_ness;

import static org.junit.Assert.*;
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
		} catch (Exception ex) {}
	}
}
