package compound;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Function to test Molar Weight
 *
 */
public class TestMolarMass {

	@Test
	public void testMolarMass1() {
		try {
			assertEquals(46, MolarMass.calculateMolarMass("C(OH)2"));
		} catch(Exception e) {
			System.out.println(e.getMessage());
			fail();
		}
	}

	@Test
	public void testMolarMass2() {
		try {
			assertEquals(86, MolarMass.calculateMolarMass("CHOC(CH3)3"));
		} catch(Exception e) {
			System.out.println(e.getMessage());
			fail();
		}
	}
	
	@Test
	public void testMolarMass3() {
		try {
			assertEquals(154, MolarMass.calculateMolarMass("C12H10"));
		} catch(Exception e) {
			System.out.println(e.getMessage());
			fail();
		}
	}
	
	@Test
	public void testMolarMass4() {
		try {
			assertEquals(261, MolarMass.calculateMolarMass("CO4H2(CH2)12CH3"));
		} catch(Exception e) {
			System.out.println(e.getMessage());
			fail();
		}
	}
}
