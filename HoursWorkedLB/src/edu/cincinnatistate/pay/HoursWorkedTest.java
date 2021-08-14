/**
 * 
 */
package edu.cincinnatistate.pay;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *  JUnit test case for HoursWorked class
 *  
 * @author lance brown
 * @version 1.0
 * @since 2021-07-06
 *
 */

class HoursWorkedTest {
	private HoursWorked hw;

	/**
	 * Method setUp
	 * Abstract instantiates class instance to 8 before every test.
	 * @throws Exception
	 */
	@BeforeEach
	public void setUp() throws Exception{
		hw = new HoursWorked(8);
	}
	/**
	 * Method testAddHours
	 * Abstract tests adding hours
	 */
	@Test
	public void testAddHours() {
		hw.addHours(2);
		assertEquals(10, hw.getTotalHrs());
		hw.addHours(4);
		assertEquals(14, hw.getTotalHrs());
	}
	/**
	 * Method testSubHours
	 * Abstract tests subtracting hours, will fail by design on one case.
	 */
	@Test
	public void testSubHours() {
		hw.subHours(2);
		assertEquals(6, hw.getTotalHrs());
		hw.subHours(3);
		assertEquals(3, hw.getTotalHrs());
		//this is an error since it shouldn't allow hours below 0, but that case is unhandled in the class
		hw.subHours(4);
		assertEquals(0, hw.getTotalHrs());
	}

}
