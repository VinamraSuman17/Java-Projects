package orders;

import payments.PaymentProcessor;
import exceptions.PaymentFailureException;
import exceptions.ProductUnavailableException;

public class OrderProcessor implements Runnable {
    private Order order;
    private PaymentProcessor paymentProcessor;
    private double paymentAmount;

    public OrderProcessor(Order order, PaymentProcessor paymentProcessor, double paymentAmount) {
        this.order = order;
        this.paymentProcessor = paymentProcessor;
        this.paymentAmount = paymentAmount;
    }

    @Override
    public void run() {
        try {
            System.out.println("Processing order: " + order.getOrderId());
            order.processOrder(); // Update inventory
            paymentProcessor.processPayment(order, paymentAmount); // Handle payment
            System.out.println("Order " + order.getOrderId() + " completed successfully.");
        } catch (ProductUnavailableException | PaymentFailureException e) {
            System.out.println("Order " + order.getOrderId() + " failed: " + e.getMessage());
            order.setStatus("Failed");
        }
    }
}
