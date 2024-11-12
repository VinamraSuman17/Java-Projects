package payments;

import exceptions.InvalidRideRequestException;

public class PaymentProcessor {
    public synchronized void processPayment(Payment payment, double expectedAmount) throws InvalidRideRequestException {
        if (payment.getAmount() < expectedAmount) {
            throw new InvalidRideRequestException("Insufficient payment. Payment of $" + payment.getAmount() + " is not enough.");
        }
        payment.setStatus("Paid");
        System.out.println("Payment of $" + payment.getAmount() + " processed successfully.");
    }
}
