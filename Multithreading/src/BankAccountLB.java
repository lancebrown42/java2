/**
 * 
 */

/**
 * @author Lance Brown
 * @version 1.0
 * @since 2021-06-05
 *
 */
public class BankAccountLB implements Runnable {
	//declare Account object
	private Account acct = new Account();

	/**
	 * Method main
	 * Abstract Instantiates 2 threads and runs them
	 * @param args
	 */
	public static void main(String[] args) {
		BankAccountLB udtAccount = new BankAccountLB();
		//user threads
		Thread one = new Thread(udtAccount);
		Thread two = new Thread(udtAccount);
		one.setName("Jade");
		two.setName("Rocket");
		one.start();
		two.start();
	}
	/**
	 * Method run
	 * Abstract Method to call withdrawal and deposit for each thread.
	 */

	@Override
	public void run() {
		for(int i = 0; i < 5; i++) {
			makeWithdrawal(100);
			if(acct.getBalance() < 0) {
				System.out.println("Account is Overdrawn. A convenience fee will be applied");
			}
		}
		makeDeposit(200);
	}
	/**
	 * Method makeWithdrawal
	 * Abstract attempts to subtract a given amount amt from the account and displays the result
	 * @param amt amount to be withdrawn
	 */
	private synchronized void makeWithdrawal(int amt) {
		if(acct.getBalance() >= amt) {
			System.out.println(Thread.currentThread().getName() + " is withdrawing " + amt);
			try {
				Thread.sleep(100);
			} catch (InterruptedException ex) {
			}
			acct.withdraw(amt);
			System.out.println(Thread.currentThread().getName() + " completed the withdrawal");
		} else {
			System.out.println("Not enough in account for " + Thread.currentThread().getName() + " to withdraw " + amt + " current balance is " + acct.getBalance());
		}
	}
	/**
	 * Method makeDeposit
	 * Abstract adds a given amount amt to the account and displays the result
	 * @param amt amount to be deposited
	 */
	private void makeDeposit(int amt) {
		System.out.println(Thread.currentThread().getName() + " is depositing " + amt);
		acct.deposit(amt);
		System.out.println(Thread.currentThread().getName() + " completed deposit of " + amt + " new balance is " + acct.getBalance());
		
	}

}
	

class Account{
	private int intBalance = 500;
	/**
	 * Method getBalance
	 * Abstract returns account balance
	 * @return intBalance
	 */
	public int getBalance() {
		return intBalance;
	}
	/**
	 * Method withdraw
	 * Abstract subtracts given intWithdrawalAmount from the account
	 * @param intWithdrawalAmount amount to be withdrawn
	 */
	public void withdraw(int intWithdrawalAmount) {
		intBalance -= intWithdrawalAmount;
	}
	/**
	 * Method deposit
	 * Abstract adds give intDepositAmount to the account
	 * @param intDepositAmount amount to be deposited
	 */
	public void deposit(int intDepositAmount) {
		intBalance += intDepositAmount;
	}
}
