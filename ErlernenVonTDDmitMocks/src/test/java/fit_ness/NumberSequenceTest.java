package fit_ness;

import static org.junit.Assert.*;

import org.junit.Test;

public class NumberSequenceTest {

	@Test
	public void testSequence() {
		NumberSequence sequence = new NumberSequence();
		assertEquals(1, sequence.nextNumber());
		assertEquals(2, sequence.nextNumber());
		assertEquals(3, sequence.nextNumber());
	}
}
