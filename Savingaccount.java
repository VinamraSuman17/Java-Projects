public class Savingaccount extends Bankaccount {
    private double interestrate;

    public Savingaccount(String accountnumber, double balance, double interestrate){
        super(accountnumber, balance);
        this.interestrate=interestrate;
    }

    @Override
    public double calculateinterest(){
        return balance*interestrate;
    }
    public void applyInterest() {
        double interest = calculateinterest();
        deposit(interest);
        System.out.println("Applied interest: " + interest + ", New balance: " + balance);
    }
}


