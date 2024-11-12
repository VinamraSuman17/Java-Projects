public class bus extends Vehicle implements Maintenance{
    private final int passengerCapacity;

    // Constructor
    public bus(String fueltype, int maxspeed, double fuellevel, int passengerCapacity) {
        super(fueltype, maxspeed, fuellevel); // Calling base class constructor
        this.passengerCapacity = passengerCapacity;
    }

    // Overriding drive() method
    @Override
    public void drive() {
        System.out.println(
                "Driving the bus with " + passengerCapacity + " passengers at a speed of " + getMaxspeed() + " km/h.");
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }
    @Override
    public void performMaintenance() {
        System.out.println("Performing maintenance on the car. Checking oil, tires, and engine.");
    }
}
