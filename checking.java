package Bank;

 public class checking extends account {
    public checking(String accountNumber, String accountHolderName, double initialBalance){
        super(accountNumber,accountHolderName,initialBalance);
    }
    @Override
    public void deposit(double amount){
        if(amount>0){
            balance+=amount;
            System.out.println("Deposited "+amount+ ", New balance: "+balance);
        }else{
            System.out.println("invalid deposite amount.");
        }
    }
    @Override
    public void withdraw(double amount){
        if(amount>0&&(balance-amount)>=MIN_BALANCE){
            balance-=amount;
            System.out.println("Withdraw "+amount+", new balance "+balance);
        }else{
            System.out.println("withdrawal failed");
        }
    }
    @Override
    public void printAccountDetails(){
        System.out.println("checking account - account holder: "+ accountHolderName +",balance: "+balance);
    }
}
