public class VehicleManagementSystem {
    public static void main(String[] args) {
        // Create vehicles
        car car = new car("Petrol", 200, 50.0, 4);
        truck truck = new truck("Diesel", 120, 80.0, 15.0);
        bus bus = new bus("Diesel", 100, 60.0, 50);

        // Driving the vehicles
        car.drive();
        truck.drive();
        bus.drive();

        // Perform maintenance
        car.performMaintenance();
        truck.performMaintenance();
    }
}
