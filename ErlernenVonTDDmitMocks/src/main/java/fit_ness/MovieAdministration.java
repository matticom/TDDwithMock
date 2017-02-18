package fit_ness;

//alltests.html alltests-results.html
//Documents/AllFiles.html Reports/alltest-results.html --> Parameter für FileRunner.class
public class MovieAdministration extends fit.Fixture {
	private VideoStore store = SystemUnderTest.instance();
	private String movieTitle;
	private String priceCategory;
	private int movieNumber;
	
	public void newMovie() {
		movieNumber = store.nextMovieNumber();
	}

	public void save() throws MovieNumberAlreadyInUseException {
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
