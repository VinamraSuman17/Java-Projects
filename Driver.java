package users;

import exceptions.NoDriverAvailableException;

public class Driver {
    private String driverId;
    private String name;
    private boolean isAvailable;

    public Driver(String driverId, String name) {
        this.driverId = driverId;
        this.name = name;
        this.isAvailable = true;
    }

    public String getDriverId() {
        return driverId;
    }

    public String getName() {
        return name;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public synchronized void acceptRide() throws NoDriverAvailableException {
        if (!isAvailable) {
            throw new NoDriverAvailableException("Driver " + name + " is not available.");
        }
        isAvailable = false;
        System.out.println("Driver " + name + " has accepted the ride.");
    }

    public synchronized void completeRide() {
        isAvailable = true;
        System.out.println("Driver " + name + " is now available.");
    }
}
