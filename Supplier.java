package suppliers;

public class Supplier {
    private String supplierId;
    private String name;
    private String contact;

    public Supplier(String supplierId, String name, String contact) {
        this.supplierId = supplierId;
        this.name = name;
        this.contact = contact;
    }

    public String getSupplierId() {
        return supplierId;
    }

    public String getName() {
        return name;
    }

    public String getContact() {
        return contact;
    }

    public String toString() {
        return "Supplier ID: " + supplierId + ", Name: " + name + ", Contact: " + contact;
    }
}
