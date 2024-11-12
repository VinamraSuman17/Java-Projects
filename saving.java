package Bank;

public class saving extends account {
    private static final double INTEREST_RATE= 0.03;
    public saving(String accountNumber, String accountHolderName, double initialBalance){
        super(accountNumber,accountHolderName,initialBalance);
    }
    @Override
    public void deposit(double amount){
        if(amount>0){
            balance += amount;
            System.out.println("Deposited "+amount+", New balance "+balance);
        }else{
            System.out.println("invalid deposited amount");
        }
    }
    @Override
    public void withdraw(double amount){
        if(amount>0&&(balance-amount)>=MIN_BALANCE){
            balance-=amount;
            System.out.println("withdraw "+amount+"amount"+", new balance "+balance);
        }else{
            System.out.println("insufficient balance");
        }
    }

    public void calculateInterest(){
        double interest = balance*INTEREST_RATE;
        balance+=interest;

        System.out.println("Interest calculated "+interest+",New balance "+balance);
    }
    @Override
    public void printAccountDetails(){
        System.out.println("Savings account - account holder: "+accountHolderName+",balance: "+balance);
    }
}
