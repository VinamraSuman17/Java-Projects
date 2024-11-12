import java.util.ArrayList;
public class Order {
    private Customer customer;
    private ArrayList<Product>  products;
    private String orderdate;

    public Order(Customer customer, Product product, String orderdate){
        this.customer=customer;
        this.products=new ArrayList<>();
        this.products.add(product);
        this.orderdate=orderdate;

        product.reducestock(1);
    }

    public Order(Customer customer1, ArrayList<Product> productList, String orderdate2) {
        //TODO Auto-generated constructor stub
    }

    public Customer getCustomer(){
        return customer;
    }
    public void setCustomer(Customer customer){
        this.customer=customer;
    }
    public ArrayList<Product> getProducts(){
        return products;
    }
    public void setProducts(ArrayList<Product> products){
        this.products=products;
    }
    public String getorderdate(){
        return orderdate;
    }
    public void setOrderdate(String orderdate){
        this.orderdate=orderdate;
    }

    public void displayorderinfo(){
        System.out.println("customer: "+customer.getName());
        System.out.println("order date: "+orderdate);
        System.out.println("Products order: ");
        for(Product product: products){
            System.out.println(" - "+product.getName()+"(price: rupees"+product.getprice()+")");
        }
    }

}
