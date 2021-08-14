import java.security.AccessControlException;

/**
 * 
 */

/**
 * @author lance
 *
 */
public class EnableSecurity {
	public static void main(String[] args) {
		/*
		 No security manager is enabled by default. Thus all security checks 
		 to protected resources and operations are disabled. In order to enable 
		 security checks, the security manager must be enabled also
		*/
		// Security manager is disabled, read/write access to "user.name" system property is allowed
		System.setProperty("user.name", "LB");
		System.out.println("Java User name is : " + System.getProperty("user.name"));
		try {
			//enable security manager
			SecurityManager securityManager = new SecurityManager();
			System.setSecurityManager(securityManager);
			System.out.println("Security Manager is set as " + System.getSecurityManager());
			} catch (SecurityException se) {
				// SecurityManager already set
				System.out.println("Security Manager is already set" + System.getSecurityManager());
				
			}
			try {
			    // Security manager is enabled, read/write access to "user.name" system property is NOT allowed
				System.setProperty("user.name", "LB1");
			    System.out.println("Java User name is : " + System.getProperty("user.name"));
			} catch (AccessControlException ace) {
				System.out.println("Write access to the user.name system property is not allowed!");
			}
		}

}
