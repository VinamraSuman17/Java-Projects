public class Room {
    private int roomnumber;
    private String roomtype;
    private boolean isAvailable;
    private double pricepernight;

    //constructor
    public Room(int roomnumber, String roomtype, double pricepernight){
        this.roomnumber=roomnumber;
        this.roomtype=roomtype;
        this.isAvailable=true;
        this.pricepernight=pricepernight;
    }

    public int getRoomnumber(){
        return roomnumber;
    }
    public String getRoomtype(){
        return roomtype;
    }
    public boolean isAvailable(){
        return isAvailable;
    }
    public double getPricepernight(){
        return pricepernight;
    }
    public void bookroom(){
        this.isAvailable=false;
    }
    public void releaseroom(){
        this.isAvailable=true;
    }
}

class singleroom extends Room{
    public singleroom(int roomnumber,double pricepernight){
        super(roomnumber, "single", pricepernight);
    }
}

class doubleroom extends Room {
    public doubleroom(int roomNumber, double pricePerNight) {
        super(roomNumber, "Double", pricePerNight);
    }
}
