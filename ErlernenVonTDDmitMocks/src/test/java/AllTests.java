import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import customer.StatementTest;
import fit_ness.NumberSequenceTest;
import fit_ness.PriceTest;
import fit_ness.VideoStoreTest;


@RunWith(Suite.class)
@SuiteClasses({ 
	StatementTest.class,
	NumberSequenceTest.class,
	PriceTest.class,
	VideoStoreTest.class
})

public class AllTests {

}
