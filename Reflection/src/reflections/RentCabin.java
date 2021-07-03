package reflections;


/**
 *  Class object for rental data
 *  
 * @author lance brown
 * @version 1.0
 * @since 2021-06-29
 *
 */
public class RentCabin {
	int rate;
	String type;
	public int price;
	
	/**
	 * @param sqft number of square feet of unit
	 */
	public RentCabin(int sqft) {
		if(sqft < 1000) {
			type = "small";
			rate = 100;
			
		}else if(sqft < 2000) {
			type = "mid";
			rate = 200;
		}else {
			type = "large";
			rate = 300;
		}
	}

	/**
	 * @return the rate
	 */
	public int getRate() {
		return rate;
	}

	/**
	 * @param rate the rate to set
	 */
	public void setRate(int rate) {
		this.rate = rate;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	
	/**
	 * Method computeRentalCost
	 * Abstract calculates cost and sets the public price field
	 * @param numDays number of days for rental
	 */
	public void computeRentalCost(int numDays) {
		int price;
		price = numDays * getRate();
		this.price = price;
		
	}
	
}
