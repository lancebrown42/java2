import java.io.DataOutputStream;
import java.net.Socket;

/**
 * 
 */

/**
 *  Simple client for a socket
 *  
 * @author lance brown
 * @version 1.0
 * @since 2021-06-26
 *
 */
public class MyClient {  
	/**
	 * Method main
	 * Abstract main method
	 * @param args
	 */
	public static void main(String[] args) {  
		try{    
			Socket s=new Socket("localhost",5555);  
			DataOutputStream dout=new DataOutputStream(s.getOutputStream());
			dout.writeUTF("Check check 1 2 1 2");  
			dout.flush();  
			dout.close(); 
			s.close();  
		}
		catch(Exception e){
			System.out.println(e);
		}  
	}  
}  
