import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
/**
 *  Connects to database and prints a column from a table
 *  
 * @author lance brown
 * @version 1.0
 * @since 2021-05-21
 *
 */
public class DBProcessPart1 {
	private static Connection m_conAdministrator;
	private static String strTable;
	private static String strPrimaryKey;
	private static String strColumn;
	/**
	 * Method main
	 * Abstract main method
	 * @param args
	 */
	public static void main(String[] args) {
		strTable = "TEmployees";
		strPrimaryKey="intEmployeeID";
		strColumn="strFirstName";
		//other table
		//strTable = "TLocations";
		//strPrimaryKey="intLocationID";
		//strColumn="strLocation";
		try {
			if((OpenDatabaseConnectionMSAccessJRE8())==true) {
				LoadListFromDatabase(strTable, strPrimaryKey, strColumn);
			}
			else {
				System.out.println("Error loading table");
			}
			System.out.println("Success");
		}
		catch (Exception e) {
			System.out.println("I/O Error: " + e.getMessage());
		}
	}
	/**
	 * Method OpenDatabaseConnectionMSAccessJRE8
	 * Abstract Connects to MSAccess db
	 * @return blnResult Success boolean
	 */
	public static boolean OpenDatabaseConnectionMSAccessJRE8() {
		boolean blnResult = false;
		try {
			String strConnectionString = "";
			strConnectionString = "jdbc:ucanaccess://" + System.getProperty( "user.dir" )
			+ "\\Database\\dbHCM.accdb";
			m_conAdministrator = DriverManager.getConnection(strConnectionString);
			blnResult = true;
		}
		catch(Exception e) {
			System.out.println("Error opening DB: " + e);
		}

		return blnResult;
	}
	/**
	 * Method LoadListFromDatabase
	 * Abstract Loads table and prints ID and content of second column
	 * @param strTable Table being accessed
	 * @param strPrimaryKeyColumn column name of primary key
	 * @param strNameColumn name of the non-id column
	 * @return blnResult Success boolean
	 */
	public static boolean LoadListFromDatabase( String strTable, String strPrimaryKeyColumn, 
			   String strNameColumn) {
		boolean blnResult = false;
		try {
			String strSelect = "";
			Statement sqlCommand = null;
			ResultSet rstTSource = null;
			int intID = 0;
			String strName = "";
			
			strSelect = "SELECT " + strPrimaryKeyColumn + ", " + strNameColumn + " FROM " + strTable + " ORDER BY " + strPrimaryKeyColumn;
			sqlCommand = m_conAdministrator.createStatement();
			rstTSource = sqlCommand.executeQuery(strSelect);
			while(rstTSource.next()==true) {
				intID = rstTSource.getInt( 1 );
				strName = rstTSource.getString( 2 );
				System.out.println("Table: " + strTable + " ID: " + intID + " Name: " + strName);
			}
			rstTSource.close( );
			sqlCommand.close( );
			blnResult = true;
		}
		catch(Exception e) {
			System.out.println("Error loading list from db: " + e);
		}
		return blnResult;
	}

}
