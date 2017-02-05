package fit_ness;

public class NumberSequence {
	private int nextNumber = 1;

	public synchronized int nextNumber() {
		return nextNumber++;
	}
}
