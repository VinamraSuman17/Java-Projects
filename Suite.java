public class Suite extends Room implements Roomservice,Laundryservice{

    private boolean hasjacuzzi;
    public Suite(int roomnumber) {
        super(roomnumber, "Suite");
        this.hasjacuzzi=true;
    }
    public void requestRoomservice() {
        System.out.println("Room Service requested for Suite " + roomnumber);
    }
    
    @Override
    public void requestLaundryservice() {
        System.out.println("Laundry Service requested for Suite " + roomnumber);
    }

    @Override
    public void bookroom(){
        System.out.println("suite" + roomnumber+"comes woth a complimentary bottle of wine.");
    }
    
}
