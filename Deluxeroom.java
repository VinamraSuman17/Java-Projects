public class Deluxeroom extends Room{
    public Deluxeroom(int roomnumber){
        super(roomnumber,"Deluxeroom");
    }
    @Override
    public void bookroom(){
        System.out.println("Deluxe room "+roomnumber+" includes complimentary breakfast.");
    }
}
