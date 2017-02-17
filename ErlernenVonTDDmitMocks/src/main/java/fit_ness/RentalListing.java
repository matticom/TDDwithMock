package fit_ness;

public class RentalListing extends fit.RowFixture {
	private VideoStore store = SystemUnderTest.instance();

	public Object[] query() throws Exception {
		return store.allRentalItems().toArray();
	}

	public Class getTargetClass() {
		return RentalItem.class;
	}
}
