public class Standardroom extends Room implements Roomservice{
    public Standardroom(int roomnumber){
        super(roomnumber,"Standard Room");
    }
    @Override
    public void requestRoomservice(){
        System.out.println("Room service requested for standard Room "+roomnumber);
    }


}

