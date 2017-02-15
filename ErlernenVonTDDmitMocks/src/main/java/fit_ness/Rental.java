package fit_ness;

import Euro.Euro;

public class Rental {
	private Movie movie;
	private int daysRented;

	
	public Rental(Movie movie, int daysRented) {
		this.movie = movie;
		this.daysRented = daysRented;
	}
	
	public String getMovieTitle() {
		return movie.getTitle();
	}


	public Euro getCharge() {
		return movie.getCharge(daysRented);
	}

}
