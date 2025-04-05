package com.mtit.osgi.orderproducer;

import java.util.HashMap;
import java.util.Map;

public class OrderServiceImpl implements OrderService {
    private Map<String, String> orders = new HashMap<>();

    @Override
    public String createOrder(String productName, int quantity) {
        String orderId = "ORD" + System.currentTimeMillis();
        orders.put(orderId, productName + " - " + quantity);
        System.out.println("Order created: " + orderId + " - " + productName + " - " + quantity);
        
        return orderId;
    }

    @Override
    public void cancelOrder(String orderId) {
        if (orders.containsKey(orderId)) {
            orders.remove(orderId);
            System.out.println("Order canceled: " + orderId);
        } else {
            System.out.println("Order not found: " + orderId);
        }
    }

    @Override
    public String getOrderDetails(String orderId) {
        return orders.getOrDefault(orderId, "Order not found");
    }
}