package com.mtit.osgi.paymentproducer;

import java.util.HashMap;
import java.util.Map;

public class PaymentServiceImpl implements PaymentService {
    private Map<String, Double> payments = new HashMap<>();

    @Override
    public void processPayment(String orderId, double amount) {
        payments.put(orderId, amount);
        System.out.println("Payment processed: " + orderId + " - Rs." + amount);
    }

    @Override
    public void refundPayment(String orderId) {
        if (payments.containsKey(orderId)) {
            payments.remove(orderId);
            System.out.println("Payment refunded: " + orderId);
        } else {
            System.out.println("Payment not found: " + orderId);
        }
    }
}