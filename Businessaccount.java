public class Businessaccount extends Bankaccount implements Taxable{
    private double interestRate;
    private double transactionLimit;
    private double taxrate;
    public Businessaccount(String accountnumber, double balance, double interestRate, double transactionLimit, double taxrate) {
        super(accountnumber, balance);
        this.interestRate = interestRate;
        this.transactionLimit = transactionLimit;
        this.taxrate=taxrate;
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= transactionLimit) {
            super.withdraw(amount);
        } else {
            System.out.println("Transaction exceeds the limit.");
        }
    }

    @Override
    public double calculateinterest() {
        return balance * interestRate;
    }
    @Override
    public double calculatetax(){
        return balance*taxrate;
    }

    public void applytax(){
        double tax = calculatetax();
        withdraw(tax);
        System.out.println("tax applied :"+tax+", new balance: "+balance);
    }
}
