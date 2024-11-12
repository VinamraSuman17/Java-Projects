public abstract class Vehicle {
    private final String fueltype;
    private final int maxspeed;
    private double fuellevel;

    //constructor
    public Vehicle(String fueltype, int maxspeed, double fuellevel){
        this.fueltype=fueltype;
        this.maxspeed=maxspeed;
        this.fuellevel=fuellevel;
    }

    public String getFueltype(){
        return fueltype;
    }
    public int getMaxspeed(){
        return maxspeed;
    }
    public double getFuellevel(){
        return fuellevel;
    }

    public void refuel(double fuel){
        this.fuellevel+=fuel;
        System.out.println("Total fuel :"+fuellevel);
    }

    public abstract void drive();

    public String getVehicleDetails(){
        return  "Fuel Type: " + fueltype + ", Max Speed: " + maxspeed + " km/h, Fuel Level: " + fuellevel;
    }
}

