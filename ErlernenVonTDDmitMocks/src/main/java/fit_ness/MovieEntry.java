package fit_ness;

public class MovieEntry extends fit.ColumnFixture {
	private VideoStore store = new VideoStore();//SystemUnderTest.instance();
	public int number;
	public String title;
	public String category;

	public boolean isValid() {
		summary.put("java version", System.getProperty("java.version"));
		summary.put("operating system", System.getProperty("os.name"));
		try {
			store.newMovie(number, title, category);
			return true;
		} catch (MovieNumberAlreadyInUseException e) {
			return false;
		}
		
	}
}
