import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 
 */

/**
 *  Simple socket server, prints first line of input to console
 *  
 * @author lance brown
 * @version 1.0
 * @since 2021-06-26
 *
 */
public class MyServer {
	/**
	 * Method main
	 * Abstract Main method
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			ServerSocket ss = new ServerSocket(5555);
			Socket s = ss.accept();
			DataInputStream dis = new DataInputStream(s.getInputStream());
			String str = (String) dis.readUTF();
			System.out.println("Message: " + str);
			ss.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
}
