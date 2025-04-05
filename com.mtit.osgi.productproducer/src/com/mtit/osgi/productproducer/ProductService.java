package com.mtit.osgi.productproducer;

public interface ProductService {
    void addProduct(String name, double price);
    void updateProduct(String name, double price);
    void deleteProduct(String name);
    String getProductDetails();
}