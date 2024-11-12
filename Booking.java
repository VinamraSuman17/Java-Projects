import java.time.LocalDate;
import java.util.*;

public class Booking{
    private int bookingId;
    private Guest guest;
    private List<Room> rooms;
    private Payment payment;
    private LocalDate checkindate;
    private LocalDate checkoutdate;

    //constructor
    public Booking(int bookingId, Guest guest, List<Room> rooms, LocalDate checkInDate, LocalDate checkOutDate) {
        this.bookingId = bookingId;
        this.guest = guest;
        this.rooms = rooms;
        this.checkindate = checkInDate;
        this.checkoutdate = checkOutDate;
    }

    public void createBooking(Guest guest, String roomType, LocalDate checkInDate, LocalDate checkOutDate, List<Room> availableRooms) {
        for (Room room : availableRooms) {
            if (room.getRoomtype().equals(roomType) && room.isAvailable()) {
                room.bookroom();
                this.rooms.add(room);
                break;
            }
        }
    }
    public void createBooking(Guest guest, int roomNumber, LocalDate checkInDate, LocalDate checkOutDate, List<Room> availableRooms) {
        for (Room room : availableRooms) {
            if (room.getRoomnumber() == roomNumber && room.isAvailable()) {
                room.bookroom();
                this.rooms.add(room);
                break;
            }
        }
    }
    public String getBookingDetails() {
        StringBuilder details = new StringBuilder("Booking ID: " + bookingId + "\nGuest: " + guest.getName() + "\nRooms:\n");
        for (Room room : rooms) {
            details.append("Room Number: ").append(room.getRoomnumber()).append(", Room Type: ").append(room.getRoomtype()).append("\n");
        }
        details.append("Check-in Date: ").append(checkindate).append("\nCheck-out Date: ").append(checkoutdate);
        return details.toString();
    }

    // Method to cancel booking
    public void cancelBooking() {
        for (Room room : rooms) {
            room.releaseroom(); // Make rooms available again
        }
    }

    // Method to assign a payment
    public void assignPayment(Payment payment) {
        this.payment = payment;
    }

    // Get payment status
    public String getPaymentStatus() {
        if (payment != null && payment.getPaymentStatus()) {
            return "Payment successful";
        } else {
            return "Payment pending";
        }
    }
}