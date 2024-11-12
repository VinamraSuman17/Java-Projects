import java.util.*;

class Product {
    private String name;
    private double price;
    private int quantity;

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return name + " - Price: " + price + " - Quantity: " + quantity;
    }
}

class ShoppingCart {
    private List<Product> products;
    private static final double taxrate = 0.08; //taxrate define by government 
    private static final double discountthreshold = 500.0; // minimum of 500 rupees shopping is must
    private static final double discountpercentage = 0.10; // 10% discount is available above the shopping of 500 rupees

    public ShoppingCart() {
        this.products = new ArrayList<>(); // making a arraylist for storing the products
    }

    // Add product to the cart
    public void addproduct(Product product) {
        products.add(product);
    }

    // remove pordutc from the cart
    public void removeproduct(Product product) {
        products.remove(product);
    }

    // calculate total cost
    public double calculatetotalcost() {
        double subtotal = 0.0;
        for (Product product : products) {
            subtotal += product.getPrice() * product.getQuantity();
        }
        // apply discount if applicable
        if (subtotal > discountthreshold) {
            System.out.println("Applying discount of " + (discountpercentage * 100) + "%");
            subtotal -= subtotal * discountpercentage;
        }
        // add tax
        double total = subtotal + (subtotal * taxrate);
        return total;

    }

    // display cart content
    public void displaycartcontent() {
        System.out.println("Shopping cart: ");
        for (Product product : products) {
            System.out.println(product);
        }
    }

    public boolean isEmpty() {
        return products.isEmpty();
    }
}

class Customer {
    private String name;
    private String email;

    public Customer(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "customer Name: " + name + ",Email: " + email;
    }
}

public class OnlineShopping {
    public static void main(String[] args) {
        // create customer
        Customer customer = new Customer("Ashish", "ashish@gmail.com");
        // create product
        Product product1 = new Product("laptop", 1000.00, 1);
        Product product2 = new Product("mouse", 50.00, 2);
        // create shoppinh cart
        ShoppingCart cart = new ShoppingCart();
        // add product to cart
        cart.addproduct(product1);
        cart.addproduct(product2);
        // display content of the cart
        cart.displaycartcontent();
        // calculate total cost
        double totalCost = cart.calculatetotalcost();
        System.out.println("Total cost: " + totalCost);
        // remove a product from the cart and display cart again
        cart.removeproduct(product2);
        cart.displaycartcontent();
        // recalculate total cost after removing a porduct
        totalCost = cart.calculatetotalcost();
        System.out.println("Total cost after removal: " + totalCost);
    }
}
