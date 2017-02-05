package fit_ness;

import static org.junit.Assert.*;

import org.junit.Test;

import customer.Movie;

public class VideoStoreTest {
	
	@Test
	public void testMovieHandling() {
		VideoStore store = new VideoStore();
		Movie movie = store.newMovie(1, "don’t care", "don’t care");
		assertSame(movie, store.getMovie(1));
		assertNotNull(movie);
	}
}
