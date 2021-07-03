import java.io.*;
import java.net.*;

/**
 * 
 */

/**
 *  Connects to given URL, reads in page as bytestream and writes it to given html file
 *  
 * @author lance brown
 * @version 1.0
 * @since 2021-06-26
 *
 */
public class HWNetworkWebPage {

	/**
	 * Method main
	 * Abstract Main method
	 * @param args(String url, String filePath)
	 */
	public static void main(String[] args) {
		try {
			if(args.length < 2) {
				throw new IllegalArgumentException();
			}
			String url = args[0];
			String file = args[1];
			
			URL urlObj = new URL(url);
			URLConnection urlCon = urlObj.openConnection();
			InputStream inputStream = urlCon.getInputStream();
			BufferedInputStream reader = new BufferedInputStream(inputStream);
			BufferedOutputStream writer = new BufferedOutputStream(new FileOutputStream(file));
			
			byte[] buffer = new byte[4096];
			int bytesRead = -1;
			while((bytesRead = reader.read(buffer)) != -1) {
				writer.write(buffer, 0, bytesRead);
			}
			writer.close();
			reader.close();
			System.out.println("Prcess complete");
			
		}catch(IllegalArgumentException e) {
			System.err.println("Syntax error with url and filename");
		}
		catch(MalformedURLException e) {
			System.err.println("The specified URL is malformed " + e.getMessage());
		}
		catch(IOException e) {
			System.err.println("An I/O Error occured: " + e.getMessage());
		}
		catch(Exception e) {
			System.err.println("Unhandled exception: " + e.getMessage());
		}
	}
}
