public class car extends Vehicle implements Maintenance{
    private final int numberofdoors;

    //constructor
    public car(String fueltype, int maxspeed, double fuellevel, int numberofdoors){
        super(fueltype, maxspeed, fuellevel);
        this.numberofdoors=numberofdoors;
    }

    @Override
    public void drive(){
        System.out.println("Driving the car at speed of "+ getMaxspeed()+"km/h");
    }
    public int getNumberofdoors(){
        return numberofdoors;
    }
    @Override
    public void performMaintenance() {
        System.out.println("Performing maintenance on the car. Checking oil, tires, and engine.");
    }
}
