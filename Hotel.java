import java.util.*;
public class Hotel {

    public void checkin(Room room){
        room.bookroom();
    }

    public void checkout(Room room){
        room.checkout();
    }
    public static void main(String[] args) {
        Hotel hotel= new Hotel();
        Room standard = new Standardroom(101);
        Room deluxe = new Deluxeroom(202);
        Room suite = new Suite(303);

        hotel.checkin(standard);
        hotel.checkin(deluxe);
        hotel.checkin(suite);

    }
}
