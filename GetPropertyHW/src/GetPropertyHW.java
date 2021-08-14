import java.security.AccessControlException;

/**
 * 
 */

/**
 *  Demonstrates System props and security manager
 *  
 * @author lance brown
 * @version 1.0
 * @since 2021-08-05
 *
 */
public class GetPropertyHW {

	/**
	 * Method main
	 * Abstract main method
	 * @param args none
	 */
	public static void main(String[] args) {
		System.out.println("java.home:" + System.getProperty("java.home"));
		System.out.println("user.name:" + System.getProperty("user.name"));
		System.out.println("user.dir:" + System.getProperty("user.dir"));
		System.out.println("os.name:" + System.getProperty("os.name"));
		System.out.println("os.version:" + System.getProperty("os.version"));
		
		try {
			SecurityManager securityManager = new SecurityManager();
			System.setSecurityManager(securityManager);
			System.out.println("Security Manager is set as " + System.getSecurityManager());
			} catch (SecurityException e) {
				System.out.println("Security Manager is already set" + System.getSecurityManager());
				
			}
		try {
			System.setProperty("user.name", "LB1");
		    System.out.println("Java User name is : " + System.getProperty("user.name"));
		} catch (AccessControlException e) {
			System.out.println("Write access to the user.name system property is not allowed!");
		}
		

	}

}
