public class truck extends Vehicle implements Maintenance{
    private final double loadcapacity;
    
    public truck(String fueltype, int maxspeed, double fuellevel, double loadcapacity){
        super(fueltype, maxspeed, fuellevel);
        this.loadcapacity=loadcapacity;
    }

    @Override
    public void drive(){
        System.out.println("Driving the truck with a load capacity of " + loadcapacity + " tons at a speed of " + getMaxspeed() + " km/h.");
    }

    public double getLoadcapacity(){
        return loadcapacity;
    }
    @Override
    public void performMaintenance() {
        System.out.println("Performing maintenance on the car. Checking oil, tires, and engine.");
    }
}
