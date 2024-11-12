import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private Customer customer;
    private List<Product> products;
    private static final double TAX_RATE = 0.08;
    private static final double DISCOUNT_THRESHOLD = 100.00;
    private static final double DISCOUNT_RATE = 0.10;

    public ShoppingCart(Customer customer) {
        this.customer = customer;
        this.products = new ArrayList<>();
    }

    // ADD product to cart
    public void addProduct(Product product) {
        products.add(product);
    }

    // Remove products
    public void removeProduct(Product product) {
        products.remove(product);
    }

    // calculate total cost of cart
    public double calculateTotal() {
        double total = 0.0;
        for (Product product : products) {
            total += product.getPrice() * product.getQuantity();
        }
        // apply discount
        if (total > DISCOUNT_THRESHOLD) {
            total -= total * DISCOUNT_RATE;
        }
        // apply tax
        total += total * TAX_RATE;
        return total;

    }

    public void displayCart() {
        System.out.println("Shopping cart for " + customer.getName() + ":");
        for (Product product : products) {
            System.out.println(product.getName() + "-$" + product.getPrice() + "x" + product.getQuantity());

        }
        System.out.println("Total Cost : $ " + calculateTotal());
    }

}