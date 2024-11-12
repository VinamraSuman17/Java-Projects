package Bank;

public class transaction{
    private String type;
    //deposite or withdrawal
    private double amount;
    private String date;

    public transaction(String type, double amount,String date){
        this.type=type;
        this.amount=amount;
        this.date=date;
    }

    @Override
    public String toString(){
        return date+" - "+type+": "+amount;
    }
    
}
