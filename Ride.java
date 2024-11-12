package rides;

import users.Driver;
import users.User;

public class Ride {
    private String rideId;
    private User user;
    private Driver assignedDriver;
    private String status;

    public Ride(String rideId, User user) {
        this.rideId = rideId;
        this.user = user;
        this.status = "Pending";
    }

    public String getRideId() {
        return rideId;
    }

    public User getUser() {
        return user;
    }

    public Driver getAssignedDriver() {
        return assignedDriver;
    }

    public String getStatus() {
        return status;
    }

    public void setAssignedDriver(Driver assignedDriver) {
        this.assignedDriver = assignedDriver;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void startRide() {
        this.status = "Ongoing";
        System.out.println("Ride " + rideId + " has started.");
    }

    public void completeRide() {
        this.status = "Completed";
        System.out.println("Ride " + rideId + " has been completed.");
    }
}
