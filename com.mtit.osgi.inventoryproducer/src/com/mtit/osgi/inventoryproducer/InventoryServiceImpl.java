package com.mtit.osgi.inventoryproducer;

import java.util.HashMap;
import java.util.Map;

public class InventoryServiceImpl implements InventoryService {
    private Map<String, Integer> inventory = new HashMap<>();

    @Override
    public void addStock(String productName, int quantity) {
        inventory.put(productName, inventory.getOrDefault(productName, 0) + quantity);
        System.out.println("Stock added: " + productName + " - " + quantity);
    }

    @Override
    public void removeStock(String productName, int quantity) {
        if (inventory.containsKey(productName)) {
            int currentStock = inventory.get(productName);
            if (currentStock >= quantity) {
                inventory.put(productName, currentStock - quantity);
                System.out.println("Stock removed: " + productName + " - " + quantity);
            } else {
                System.out.println("Insufficient stock for: " + productName);
            }
        } else {
            System.out.println("Product not found: " + productName);
        }
    }

    @Override
    public int checkStock(String productName) {
        return inventory.getOrDefault(productName, 0);
    }
}