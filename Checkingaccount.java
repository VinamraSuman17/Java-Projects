public class Checkingaccount extends Bankaccount{
    private double overdraftlimit;
     public Checkingaccount(String accountnumber,  double balance, double overdraftlimit){
        super(accountnumber,balance);
        this.overdraftlimit=overdraftlimit;
     }

     @Override
     public void withdraw(double amount){
        if(balance+overdraftlimit>=amount){
            balance-=amount;
            System.out.println("Withdraw: "+amount+", new balance: "+balance);
        }else{
            System.out.println("Insufficient balance.");
        }

     }
     public void displayOverdraftLimit() {
        System.out.println("Overdraft limit: " + overdraftlimit);
    }
}
