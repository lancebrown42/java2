import java.io.BufferedReader;
import java.io.InputStreamReader;


/**
 * 
 */

/**
 * @author lance
 *
 */
public class GetUserInput {

	/**
	 * Method main
	 * Abstract TODO
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int intInput = 0;
		
		System.out.printf("1-View Customers\n2-Create Modified Customers File\n");
		intInput = ReadIntegerFromUser();
		if(intInput ==1) {
			ViewCustomers.viewCustomers();
		}else if(intInput ==2) {
			ModifyCustomers.modifyCustomers();
		}else {
			System.out.println("Unhandled");
		}
		
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
			if(intInput < 1 || intInput > 2) {
				//Utitilizing Exceptions for Extra Credit?
				throw new IllegalArgumentException("Invalid selection");
			}
		} catch(IllegalArgumentException e) {
			System.out.println(e.getMessage());
			intInput = ReadIntegerFromUser();
		}catch(Exception e) {
		
			System.out.println(e.toString());
			intInput = ReadIntegerFromUser();
		}
		return intInput;
	}

}
