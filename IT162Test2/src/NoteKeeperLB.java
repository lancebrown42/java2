import java.io.*;



/**
 *  Takes user input to create/locate an output file, then takes
 *  further input to write to file. Finally prints result to console.
 *  
 * @author lance brown
 * @version 1.0
 * @since 2021-07-13
 *
 */
public class NoteKeeperLB {


	/**
	 * Method main
	 * Abstract Main method
	 * @param args n/a
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String strNote;
		String strPath;
		
		try {
			strPath = readPath();
			File foutput = new File(strPath);
			if(foutput.createNewFile()) {
				System.out.println("File created.");
			}else {
				System.out.println("File already exists.");
			}
			strNote = readNote();
			
			
			FileOutputStream fsOut = new FileOutputStream(foutput);
			ObjectOutputStream osOut = new ObjectOutputStream(fsOut);
			osOut.writeUTF(strNote);
			
			osOut.close();
			fsOut.close();
			
			FileInputStream fsIn = new FileInputStream(foutput);
			ObjectInputStream osIn = new ObjectInputStream(fsIn);
			String strReadFile = osIn.readUTF();
			osIn.close();
			fsIn.close();
			System.out.println("Save Successful with content:");
			System.out.println(strReadFile);
		} catch (FileNotFoundException e) {
			System.out.println("File not found. Contact support.");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("File could not be written");
			e.printStackTrace();
		}catch(Exception e) {
			System.err.println("Unhandled Exception: " + e.getMessage());
		}
	}
	/**
	 * Method readPath
	 * Abstract reads the file location from the user as a string.
	 * @return filepath string
	 */
	public static String readPath() {
		String strPath = "";
		try {
			System.out.println("Please provide a relative path to the output .txt file: ");
			String strBuffer=ReadStringFromUser();
			
			if(!strBuffer.trim().substring(strBuffer.length()-4).equals(".txt") ) {
				
				throw new IllegalArgumentException();
			}else {
				strPath = strBuffer;
			}
		}catch(IllegalArgumentException e) {
			System.err.println("Illegal input for file path. Please enter relative path to .txt file");
			strPath = readPath();
		}
		catch(Exception e) {
			System.err.println("Unhandled exception in reading path: " + e.getMessage());
		}
		return strPath;
	}
	/**
	 * Method readNote
	 * Abstract Reads user input to write to file. 
	 * @return string containing user input
	 */
	public static String readNote() {
		System.out.println("Enter your note. Press return twice to write to file and exit:");
		String strNote = "";
		try {
			String strBuffer = "";
			do {
				strBuffer = ReadStringFromUser();
				strNote += strBuffer + "\n";
			}while(!strBuffer.isEmpty());
		}catch(Exception e) {
			strNote = e.toString();
		}
		return strNote;
	}
	/**
	 * Method ReadStringFromUser
	 * Abstract Reads string from user input
	 * @return strInput
	 */
	public static String ReadStringFromUser() {
		String strInput = "";
		
		try {
			String strBuffer = "";
			BufferedReader burInput = new BufferedReader(new InputStreamReader(System.in));
			
			strBuffer = burInput.readLine();
			
			/**
			 * I don't think this is appropriate for this use case. Numbers are totally acceptable.
			 */
//			try {
//				if(!Float.isNaN(Float.parseFloat(strBuffer))) {//check if input is numeric
//					throw new Exception("Input is not a string");
//				}
//			} catch(Exception f) {
//				
//			}
			strInput = strBuffer;
		} catch(Exception e) {
			System.out.println("Invalid input: " + e.toString());
			strInput = ReadStringFromUser();
		}
		return strInput;
	}

}
