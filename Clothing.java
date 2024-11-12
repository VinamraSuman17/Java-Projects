public class Clothing extends Product {
    private String size;
    private String material;

    // Constructor
    public Clothing(String name, double price, int stockQuantity, String size, String material) {
        super(name, price, stockQuantity);
        this.size = size;
        this.material = material;
    }

    // Getter and setter for specialized attributes
    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    // Overridden method to display product details
    public void displayProductInfo() {
        System.out.println("Clothing - " + getName() + " (" + material + ", size " + size + ")");
    }
}

