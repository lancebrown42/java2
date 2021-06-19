/**
 * 
 */

/**
 * @author lance
 *
 */
public class test extends Thread {
	public void run() {
		System.out.println("answer");
	}
	public static void main(String args[]) {
		test obj=new test();
		obj.start();
	}
}
