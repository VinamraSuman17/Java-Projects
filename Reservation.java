package reservations;

import rooms.Room;
import exceptions.OverbookingException;

public class Reservation {
    private String reservationId;
    private Room room;
    private String guestName;
    private String status;

    public Reservation(String reservationId, Room room, String guestName) {
        this.reservationId = reservationId;
        this.room = room;
        this.guestName = guestName;
        this.status = "Pending";
    }

    public String getReservationId() {
        return reservationId;
    }

    public Room getRoom() {
        return room;
    }

    public String getGuestName() {
        return guestName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void confirmReservation() throws OverbookingException {
        room.bookRoom(); // Book the room if available
        this.status = "Confirmed";
        System.out.println("Reservation " + reservationId + " confirmed for guest: " + guestName);
    }
}
