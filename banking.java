public class banking{
    public static void main(String[] args) {
        
     // Create Savings Account
     Savingaccount savingsAccount = new Savingaccount("SA123", 1000.0, 0.05);
     savingsAccount.deposit(500);
     savingsAccount.applyInterest();
     savingsAccount.displayBalance();

     System.out.println("---------------------------");

     // Create Checking Account
     Checkingaccount checkingAccount = new Checkingaccount("CA456", 500.0, 200.0);
     checkingAccount.withdraw(600);
     checkingAccount.displayBalance();
     checkingAccount.displayOverdraftLimit();

     System.out.println("---------------------------");

     // Create Business Account
     Businessaccount businessAccount = new Businessaccount("BA789", 5000.0, 0.03, 1000.0, 0.02);
     businessAccount.withdraw(800);
     businessAccount.applytax();
     businessAccount.displayBalance();
 }
}