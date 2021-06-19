/**
 * 
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
/**
 *  DisplayStudentInfo takes user input to select which information they want displayed,
 *  pulls the requested data from a DB and displays it.
 *  
 * @author lance brown
 * @version 1.0
 * @since 2021-06-11
 *
 */
public class DisplayStudentInfo implements Runnable {

	private static Connection m_conAdministrator;
	/**
	 * Method main
	 * Abstract main method
	 * @param args
	 */
	public static void main(String[] args) {

		DisplayStudentInfo udtStudentInfo = new DisplayStudentInfo();
		Thread tStudent = new Thread(udtStudentInfo);
		Thread tMajor = new Thread(udtStudentInfo);
		tStudent.setName("TContacts");
		tMajor.setName("TMajors");
		int intInput = 0;
		boolean valid = true;
		do {
			
		System.out.println("Enter Option 1 - see Student table");
		System.out.println("Enter Option 2 - view Major table");
		System.out.println("Enter Option 3 - view both");
		try {
			
		intInput = ReadIntegerFromUser();
		switch(intInput) {
			case 1:
				tStudent.start();
				break;
			case 2:
				tMajor.start();
				break;
			case 3:
				tStudent.start();
				tMajor.start();
				break;
			default:
				valid = false;
				
				if(intInput < 1 || intInput > 3) {
					
					throw new IndexOutOfBoundsException();
				}
				
		
		}
		} catch(IndexOutOfBoundsException e) {
			System.out.println("You have an issue with your index. Please contact level 1 Support for Project CS.");
		}
		} while(!valid);
	}
	/**
	 * Method run
	 * Abstract Method to call withdrawal and deposit for each thread.
	 */

	@Override
	public void run() {
		try {
        	
 			// Can we connect to the database?
 			if ( OpenDatabaseConnectionMSAccessJRE8( ) == true )
 			{	
				LoadListFromDatabase(Thread.currentThread().getName());
 				
 			}
 			else
 			{
 				// No, warn the user ...
 				System.out.println("Error loading the table");
 			}
 			
// 		System.out.println("Process Complete");
     }
         catch 	(Exception e) {
         	System.out.println("An I/O error occurred: " + e.getMessage());
     	}
		 finally {
			 System.out.println("Processing Complete by DisplayStudentInfo");
		 }
	}
	
	/**
	 * Method OpenDatabaseConnectionMSAccessJRE8
	 * Abstract Connects to MSAccess db
	 * @return blnResult Success boolean
	 */
	public synchronized boolean OpenDatabaseConnectionMSAccessJRE8() {
		boolean blnResult = false;
		try {
			String strConnectionString = "";
			strConnectionString = "jdbc:ucanaccess://" + System.getProperty( "user.dir" )
			+ "\\Database\\dbHCM.accdb";
			m_conAdministrator = DriverManager.getConnection(strConnectionString);
			blnResult = true;
		}
		catch(Exception e) {
			System.out.println("Database connection issue in method OpenDatabaseConnectionMSAccessJRE8. Please contact Support for Project CS");
			System.out.println("Error opening DB: " + e);
		}

		return blnResult;
	}
	/**
	 * Method LoadListFromDatabase
	 * Abstract Loads table and prints ID and content of second column
	 * @param strTable Table being accessed
	 * @return blnResult Success boolean
	 */
	public synchronized boolean LoadListFromDatabase( String strTable) {
		boolean blnResult = false;
		try {
			String strSelect = "";
			Statement sqlCommand = null;
			ResultSet rstTSource = null;
			int intID = 0;
			String strFirst = "";
			String strSecond = "";
			String strThird = "";
			String strEmail = "";
			String strMajor = "";
			
			
			
			strSelect = "SELECT * FROM " + strTable;
			sqlCommand = m_conAdministrator.createStatement();
			rstTSource = sqlCommand.executeQuery(strSelect);
			System.out.printf("-----------------%s-----------------\n", strTable.substring(1));
			while(rstTSource.next()==true) {
				intID = rstTSource.getInt( 1 );
				strFirst = rstTSource.getString( 2 );
				strSecond = rstTSource.getString( 3 );
				strThird = rstTSource.getString( 4 );
				try {
					strEmail = rstTSource.getString( 5 );
					strMajor = rstTSource.getString( 6 );
				} catch(Exception e) {
					//do nothing. The Course table will trigger this.
				}
				String[] row = {Integer.toString(intID), strFirst, strSecond, strThird, strEmail, strMajor};
				for(String item : row) {
					int intFieldSize = -4;
					if(item.length() >= 4) {
						intFieldSize = -12;
					}
					if(item.length() >= 12) {
						intFieldSize = -24;
					}
					if(item.length() > 22) {
						intFieldSize = -46;
					}
					String format = "%" + Integer.toString(intFieldSize) + "s";
					System.out.printf(format, item);
				}
				
				
				System.out.println();
			}
			rstTSource.close( );
			sqlCommand.close( );
			blnResult = true;
		}
		catch(IndexOutOfBoundsException e) {
			System.out.println("You have an issue with your index. Please contact level 1 Support for Project CS.");
		}
		catch(NullPointerException e) {
			System.out.println("The value pass is NULL - data needs to be fixed. Please contact level 1 Support for Project CS.");
		}
		catch(Exception e) {
			System.out.println("Error loading list from db: " + e);
		}
		return blnResult;
	}

	/**
	 * Method ReadIntegerFromUser
	 * Abstract: Reads integer value from user input
	 * @return intInput
	 */
	public static int ReadIntegerFromUser() {
		int intInput = 0;
		
		try {
			String strBuffer = "";
			BufferedReader burInput = new BufferedReader(new InputStreamReader(System.in));
			
			strBuffer = burInput.readLine();
			intInput = Integer.parseInt(strBuffer);
		} catch(NumberFormatException e) {
			System.out.println("The value provided is not a valid selection. Please try again or contact level 1 Support");
			System.out.println();
			intInput = ReadIntegerFromUser();
		}
		
		catch(Exception e) {
			System.out.println(e.toString());
			intInput = ReadIntegerFromUser();
		}
		return intInput;
	}

}

