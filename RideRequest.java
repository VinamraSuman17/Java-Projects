package rides;

import users.User;
import exceptions.InvalidRideRequestException;

public class RideRequest {
    private String requestId;
    private User user;
    private String destination;

    public RideRequest(String requestId, User user, String destination) throws InvalidRideRequestException {
        if (user == null || destination == null || destination.isEmpty()) {
            throw new InvalidRideRequestException("Invalid ride request: User or destination cannot be null/empty.");
        }
        this.requestId = requestId;
        this.user = user;
        this.destination = destination;
    }

    public String getRequestId() {
        return requestId;
    }

    public User getUser() {
        return user;
    }

    public String getDestination() {
        return destination;
    }
}
