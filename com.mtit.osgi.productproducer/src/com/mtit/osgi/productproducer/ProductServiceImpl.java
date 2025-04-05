package com.mtit.osgi.productproducer;

import java.util.HashMap;
import java.util.Map;

public class ProductServiceImpl implements ProductService {
    private Map<String, Double> products = new HashMap<>();

    @Override
    public void addProduct(String name, double price) {
        products.put(name, price);
        System.out.println("Product added: " + name + " - Rs." + price);
    }

    @Override
    public void updateProduct(String name, double price) {
        if (products.containsKey(name)) {
            products.put(name, price);
            System.out.println("Product updated: " + name + " - Rs." + price);
        } else {
            System.out.println("Product not found: " + name);
        }
    }

    @Override
    public void deleteProduct(String name) {
        if (products.containsKey(name)) {
            products.remove(name);
            System.out.println("Product deleted: " + name);
        } else {
            System.out.println("Product not found: " + name);
        }
    }

    @Override
    public String getProductDetails() {
        return products.toString();
    }
}