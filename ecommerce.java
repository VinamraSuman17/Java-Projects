import java.util.ArrayList;
public class ecommerce{
    public static void main(String[] args) {
          // Create Products
          Product phone = new Electronics("Smartphone", 699.99, 50, "TechBrand", 24);
          Product shirt = new Clothing("T-Shirt", 19.99, 100, "L", "Cotton");
  
          // Create Customer
          Customer customer1 = new Customer("ashish", "ashish@gmail.com", "123 indore");
  
          // Create Orders
          ArrayList<Product> productList = new ArrayList<>();
          productList.add(phone);
          productList.add(shirt);
  
          // Single product order
          Order order1 = new Order(customer1, phone, "2024-09-19");
  
          // Multiple products order
          Order order2 = new Order(customer1, productList, "2024-09-20");
  
          // Display order information
          order1.displayorderinfo();
          order2.displayorderinfo();
    }
}