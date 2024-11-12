public class Bankaccount {

   protected String accountnumber;
   protected double balance;
   
   public Bankaccount(String accountnumber, double balance){
    this.accountnumber=accountnumber;
    this.balance=balance;
   }

   public void deposit(double amount){
    balance+=amount;
    System.out.println("deposited: "+amount+" , new balance: "+balance);
   }

   public void withdraw(double amount){
    if(balance>amount){
        balance-=amount;
        System.out.println("withdraw: "+ amount+ ",new balance: "+ balance);
    }else{
        System.out.println("insufficient balance");
    }
    }

    public double calculateinterest(){
        return 0;
    }
    public void displayBalance() {
        System.out.println("Account " + accountnumber + " balance: " + balance);
    }

}
