public class Electronics extends Product {
    private String brand;
    private int warrantyInMonths;

    // Constructor
    public Electronics(String name, double price, int stockQuantity, String brand, int warrantyInMonths) {
        super(name, price, stockQuantity);
        this.brand = brand;
        this.warrantyInMonths = warrantyInMonths;
    }

    // Getter and setter for specialized attributes
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getWarrantyInMonths() {
        return warrantyInMonths;
    }

    public void setWarrantyInMonths(int warrantyInMonths) {
        this.warrantyInMonths = warrantyInMonths;
    }

    // Overridden method to display product details
    public void displayProductInfo() {
        System.out.println("Electronics - " + getName() + " by " + brand + " with " + warrantyInMonths + " months warranty.");
    }
}