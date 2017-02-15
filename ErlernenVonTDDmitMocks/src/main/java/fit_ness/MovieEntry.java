package fit_ness;

public class MovieEntry extends fit.ColumnFixture {
	private VideoStore store = SystemUnderTest.instance();
	public int number;
	public String title;
	public String category;

	public boolean isValid() {
		try {
			store.newMovie(number, title, category);
			return true;
		} catch (MovieNumberAlreadyInUseException e) {
			return false;
		}
		
	}
}
