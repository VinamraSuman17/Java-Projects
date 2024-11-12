package exceptions;

public class InvalidRideRequestException extends Exception {
    public InvalidRideRequestException(String message) {
        super(message);
    }
}
