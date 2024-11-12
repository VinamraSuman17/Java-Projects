abstract class smartdevice{
    protected String devicename;
    protected boolean status;// true for ON and false for OFF

    public smartdevice(String devicename){
        this.devicename=devicename;
        this.status=false;// devive are off in the start
    }

    public abstract void turnon();
    public abstract void turnoff();

    public String getDevicename(){
        return devicename;
    }
    public boolean ison(){
        return status;
    }
    public abstract void scheduleautomation();
}

class light extends smartdevice{
    private int brightness;

    public light(String devicename){
        super(devicename);
        this.brightness=0;
    }

    @Override
    public void turnon(){
        status=true;
        brightness=100;
        System.out.println(devicename+" is ON with brightness "+brightness+"%");
    }
    @Override
    public void turnoff(){
        status=false;
        brightness=0;
        System.out.println(devicename+ "is OFF");
    }
    @Override
    public void scheduleautomation(){
        System.out.println("scheduling automation for "+devicename+"(light)");
    }

    public void setBrightness(int brightness){
        this.brightness=brightness;
        System.out.println(devicename+" brightness set to "+ brightness+"%");
    }
}
class Thermostat extends smartdevice {
    private int temperature;

    public Thermostat(String devicename) {
        super(devicename);
        this.temperature = 22;  // Default temperature in Celsius
    }

    @Override
    public void turnon() {
        status = true;
        System.out.println(devicename + " is ON, temperature set to " + temperature + "°C.");
    }

    @Override
    public void turnoff() {
        status = false;
        System.out.println(devicename + " is OFF.");
    }

    @Override
    public void scheduleautomation() {
        System.out.println("Scheduling automation for " + devicename + " (Thermostat).");
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
        System.out.println(devicename + " temperature set to " + temperature + "°C.");
    }
}

// Subclass for Security Camera
class SecurityCamera extends smartdevice {
    private boolean recording;

    public SecurityCamera(String deviceName) {
        super(deviceName);
        this.recording = false;  // Default is not recording
    }

    @Override
    public void turnon() {
        status = true;
        startRecording();
        System.out.println(devicename + " is ON and recording.");
    }

    @Override
    public void turnoff() {
        status = false;
        stopRecording();
        System.out.println(devicename + " is OFF.");
    }

    @Override
    public void scheduleautomation() {
        System.out.println("Scheduling automation for " + devicename + " (Security Camera).");
    }

    public void startRecording() {
        recording = true;
        System.out.println(devicename + " started recording.");
    }

    public void stopRecording() {
        recording = false;
        System.out.println(devicename + " stopped recording.");
    }
}

// Interface for BatteryPowered devices
interface BatteryPowered {
    void checkBatteryLevel();
}

// Class that uses multiple inheritance (SmartDevice + BatteryPowered)
class BatteryCamera extends SecurityCamera implements BatteryPowered {
    private int batteryLevel;

    public BatteryCamera(String deviceName) {
        super(deviceName);
        this.batteryLevel = 100;  // Battery starts fully charged
    }

    @Override
    public void checkBatteryLevel() {
        System.out.println(devicename + " battery level is " + batteryLevel + "%.");
    }

    public void decreaseBattery() {
        if (batteryLevel > 0) {
            batteryLevel -= 10;
            System.out.println(devicename + " battery decreased, now at " + batteryLevel + "%.");
        } else {
            System.out.println(devicename + " battery is empty.");
        }
    }
}



public class smarthome {
    public static void main(String[] args) {
        light livingRoomLight = new light("Living Room Light");
        Thermostat homeThermostat = new Thermostat("Home Thermostat");
        BatteryCamera securityCamera = new BatteryCamera("Security Camera");

        // Operate devices
        livingRoomLight.turnon();
        livingRoomLight.setBrightness(75);
        livingRoomLight.turnoff();

        homeThermostat.turnon();
        homeThermostat.setTemperature(24);
        homeThermostat.turnoff();

        securityCamera.turnon();
        securityCamera.decreaseBattery();
        securityCamera.checkBatteryLevel();
        securityCamera.turnoff();

        // Schedule automation
        livingRoomLight.scheduleautomation();
        homeThermostat.scheduleautomation();
        securityCamera.scheduleautomation();
        
    }
}
