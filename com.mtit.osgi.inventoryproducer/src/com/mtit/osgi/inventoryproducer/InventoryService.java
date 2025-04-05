package com.mtit.osgi.inventoryproducer;

public interface InventoryService {
    void addStock(String productName, int quantity);
    void removeStock(String productName, int quantity);
    int checkStock(String productName);
}