import java.time.LocalDate;
import java.util.*;

public class hotelbookingsystem {
    public static void main(String[] args) {
         // Create some rooms
        Room room1 = new singleroom(101, 100.0);
        Room room2 = new doubleroom(102, 150.0);

        List<Room> availableRooms = new ArrayList<>();
        availableRooms.add(room1);
        availableRooms.add(room2);

        // Create a guest
        Guest guest1 = new Guest(1, "ashish", "ashish@gmail.com", "123456789");

        // Create a booking
        List<Room> bookedRooms = new ArrayList<>();
        Booking booking = new Booking(1, guest1, bookedRooms, LocalDate.of(2024, 9, 20), LocalDate.of(2024, 9, 25));

        // Book a room by room type
        booking.createBooking(guest1, "Single", LocalDate.of(2024, 9, 20), LocalDate.of(2024, 9, 25), availableRooms);

        // Create payment
        Payment payment = new Payment(101, 500.0, "Credit Card");
        payment.processPayment();
        booking.assignPayment(payment);

        // Get booking details
        System.out.println(booking.getBookingDetails());
        System.out.println(booking.getPaymentStatus());
    }
}
