public class Payment {
    private int paymentId;
    private double amount;
    private String paymentMethod;
    private boolean paymentStatus;

    // Constructor
    public Payment(int paymentId, double amount, String paymentMethod) {
        this.paymentId = paymentId;
        this.amount = amount;
        this.paymentMethod = paymentMethod;
        this.paymentStatus = false; // Initially, the payment is not processed
    }

    // Method to process payment
    public void processPayment() {
        this.paymentStatus = true;
    }

    // Getters
    public boolean getPaymentStatus() {
        return paymentStatus;
    }

    public double getAmount() {
        return amount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }
}
