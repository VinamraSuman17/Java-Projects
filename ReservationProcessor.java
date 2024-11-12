package reservations;

import payments.Payment;
import payments.PaymentProcessor;
import exceptions.InvalidPaymentException;
import exceptions.OverbookingException;

public class ReservationProcessor implements Runnable {
    private Reservation reservation;
    private Payment payment;
    private PaymentProcessor paymentProcessor;

    public ReservationProcessor(Reservation reservation, Payment payment, PaymentProcessor paymentProcessor) {
        this.reservation = reservation;
        this.payment = payment;
        this.paymentProcessor = paymentProcessor;
    }

    @Override
    public void run() {
        try {
            System.out.println("Processing reservation: " + reservation.getReservationId());
            reservation.confirmReservation(); // Confirm room booking
            paymentProcessor.processPayment(payment, reservation.getRoom().getPricePerNight()); // Process payment
            System.out.println("Reservation " + reservation.getReservationId() + " completed successfully.");
        } catch (OverbookingException | InvalidPaymentException e) {
            System.out.println("Reservation " + reservation.getReservationId() + " failed: " + e.getMessage());
            reservation.setStatus("Failed");
        }
    }
}
