package com.mtit.osgi.orderproducer;

public interface OrderService {
	String createOrder(String productName, int quantity);
    void cancelOrder(String orderId);
    String getOrderDetails(String orderId);
}