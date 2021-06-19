/**
 * 
 */

/**
 * @author Lance Brown
 * @version 1.0
 * @since 2021-05-28
 *
 */
public class CExceptions {

	/**
	 * Method main
	 * Abstract Throws 5 different kinds of exceptions
	 * @param args
	 */
	public static void main(String[] args) {
		//Exercise 1 - Arithmetic exception
		try {
			int intNum1 = 30;
			int intNum2 = 0;
			double dblOutput;
			dblOutput = intNum1/intNum2;
		}catch(ArithmeticException e) {
			System.out.println("You should not divide a number by zero");
		}
		//Exercise 2 - ArrayIndexOutOfBounds Exception
		try {
			int aintFoo[] = {1,2,3};
			int intWrong = aintFoo[5];
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("Array Index Out of Bounds");
		}
		//Exercise 3- NumberFormat Exception
		try {
			int intNum=Integer.parseInt("XYZ");
		}catch(NumberFormatException e) {
			System.out.println("Number format exception occurred");
		}
		//Exercise 4 - StringIndexOutOfBound Exception
		try {
			String strBar = "Words";
			char chrWrong = strBar.charAt(10);
		}catch(StringIndexOutOfBoundsException e) {
			System.out.println("String index out of bounds");
		}
		//Exercise 5 - NullPointer Exception
		try {
			String strFoo =null;
			int intLength = strFoo.length();
		}catch(NullPointerException e) {
			System.out.println("Null pointer exception");
		}
	}

}
