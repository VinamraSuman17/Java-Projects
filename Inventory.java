package inventory;

import exceptions.OutOfStockException;
import exceptions.InvalidProductException;


public class Inventory {
    private Product[] products;
    private int productCount;

    public Inventory(int size){
        products = new Product[size];
        productCount=0;
    }

    public void addProduct(Product product) throws InvalidProductException{
        if(productCount>=products.length){
            throw new InvalidProductException("inventory is full. Cannot add more products.");
        }
        products[productCount] = product;
        productCount++;
    }

    public Product findProduct(String productId) throws InvalidProductException{
        for(int i=0; i< productCount; i++){
            if(products[i].getProductId().equals(productId)){
                return products[i];
            }
        }
        throw new InvalidProductException("product Id not found: "+ productId);
    }
    public void updateStock(String productId, int quantity) throws InvalidProductException {
        Product product = findProduct(productId);
        product.setQuantity(product.getQuantity() + quantity);
    }

    public void reduceStock(String productId, int quantity) throws OutOfStockException, InvalidProductException {
        Product product = findProduct(productId);
        if (product.getQuantity() < quantity) {
            throw new OutOfStockException("Not enough stock for product: " + productId);
        }
        product.setQuantity(product.getQuantity() - quantity);
    }

    public void displayProducts() {
        for (int i = 0; i < productCount; i++) {
            System.out.println(products[i]);
        }
    }
}

