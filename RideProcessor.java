package rides;

import users.Driver;
import exceptions.NoDriverAvailableException;

public class RideProcessor implements Runnable {
    private Ride ride;
    private Driver driver;

    public RideProcessor(Ride ride, Driver driver) {
        this.ride = ride;
        this.driver = driver;
    }

    @Override
    public void run() {
        try {
            driver.acceptRide(); // Assign driver to the ride
            ride.setAssignedDriver(driver);
            ride.startRide(); // Start the ride
            Thread.sleep(3000); // Simulate ride duration
            ride.completeRide(); // Complete the ride
            driver.completeRide(); // Make the driver available again
        } catch (NoDriverAvailableException | InterruptedException e) {
            System.out.println("Ride " + ride.getRideId() + " failed: " + e.getMessage());
            ride.setStatus("Failed");
        }
    }
}
