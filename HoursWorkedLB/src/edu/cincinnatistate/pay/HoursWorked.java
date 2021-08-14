/**
 * 
 */
package edu.cincinnatistate.pay;

/**
 *  Class object for hours worked.
 * 
 *  
 * @author lance brown
 * @version 1.0
 * @since 2021-07-06
 */

public class HoursWorked {
	

	/**
	 * Abstract: Total hours worked
	 */
	private int totalHrs;
	public HoursWorked(int intHours) {
		setTotalHrs(intHours);
	}
	/**
	 * @return the totalHrs
	 */
	public int getTotalHrs() {
		return totalHrs;
	}
	/**
	 * @param totalHrs the totalHrs to set
	 */
	public void setTotalHrs(int totalHrs) {
		this.totalHrs = totalHrs;
	}
	/**
	 * Method addHours
	 * Abstract add hours to total
	 * @param intHours hours worked
	 */
	public void addHours(int intHours) {
		this.totalHrs += intHours;
	}
	/**
	 * Method subHours
	 * Abstract Subtract hours from total
	 * @param intHours hours not worked
	 */
	public void subHours(int intHours) {
		this.totalHrs -= intHours;
	}

}
