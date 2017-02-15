package fit_ness;

public class UnknownMovieException extends Exception {
	private int movieNumber;

	public UnknownMovieException(int movieNumber) {
		this.movieNumber = movieNumber;
	}

	public String getMessage() {
		return "unknown movie number: " + movieNumber;
	}

	public int getMovieNumber() {
		return movieNumber;
	}
}
