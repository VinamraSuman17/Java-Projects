package Bank;

public class bankmanagement {
    //main class
    public static void main(String[] args) {
        saving savings = new saving("SA123","Vinamra",500);
        savings.deposit(200);
        savings.addTransaction("deposit", 200);
        savings.withdraw(100);
        savings.addTransaction("withdraw", 100);
        savings.calculateInterest();
        savings.addTransaction("interest", savings.balance);
        savings.printTransactionHistory();

        checking checking = new checking("CA123","suman",300);
        checking.deposit(150);
        checking.addTransaction("deposit", 150);
        checking.withdraw(50);
        checking.addTransaction("withdraw", 50);
        checking.printTransactionHistory();
        
    }
}
