package fit_ness;

public class MovieAdministration extends fit.Fixture {
	private VideoStore store = new VideoStore();
	
	private NumberSequence sequence = new NumberSequence();
	private String movieTitle;
	private String priceCategory;
	private int movieNumber;
	
	public void newMovie() {
		movieNumber = sequence.nextNumber();
	}

	public void save() {
		store.newMovie(movieNumber, movieTitle, priceCategory);
	}

	public int movieNumber() {
		return movieNumber;
	}

	public void movieTitle(String title) {
		movieTitle = title;
	}

	public void priceCategory(String category) {
		priceCategory = category;
	}
}
