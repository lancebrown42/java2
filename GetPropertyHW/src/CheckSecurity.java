/**
 * 
 */

/**
 * @author lance
 *
 */
public class CheckSecurity {

	/**
	 * Method main
	 * Abstract TODO
	 * @param args
	 */
	public static void main(String[] args) {
	      System.out.println(System.getProperty("os.name"));

	      SecurityManager s = System.getSecurityManager();
	      if(s == null) {
	    	  
	    	  System.out.println("The SecurityManager not been established.");
	      }


	}

}
