/**
 * 
 */
import java.net.*;
/**
 *  Displays url and IP address information
 *  
 * @author lance brown
 * @version 1.0
 * @since 2021-06-26
 *
 */
public class HWNetworkGetNames {
	/**
	 * Method main
	 * Abstract Main method
	 * @param args
	 * @throws MalformedURLException
	 * @throws UnknownHostException
	 */
	public static void main(String[] args) throws MalformedURLException, UnknownHostException{
		InetAddress localhost = InetAddress.getLocalHost();
		InetAddress cstate = InetAddress.getByName("cincinnatistate.edu");
		InetAddress[] google = InetAddress.getAllByName("google.com");
		InetAddress stack = InetAddress.getByName("stackoverflow.com");
		
		System.out.println("Your system is: " + localhost);
		System.out.println("IP Address for www.cincinnatistate.edu");
		System.out.println(cstate.getHostAddress());
		System.out.println("Google's host address list:");
		for(InetAddress host : google) {
			System.out.println(host.getHostAddress());
		}
		System.out.println("My most used IP address for www.stackoverflow.com");
		System.out.println(stack.getHostAddress());
		
		
	}
}
