package fit_ness;

public class MovieNumberAlreadyInUseException extends Exception {
	private int movieNumber;

	public MovieNumberAlreadyInUseException(int movieNumber) {
		this.movieNumber = movieNumber;
	}

	public String getMessage() {
		return "movie number already in use: " + movieNumber;
	}

	public int getMovieNumber() {
		return movieNumber;
	}
}
