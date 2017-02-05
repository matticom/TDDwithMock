package customer;

public class Movie {

	private String movieTitle;
	private IPrice price;
	
	public Movie(String movieTitle, IPrice price) {
		this.movieTitle = movieTitle;
		this.price = price;
	}
}
