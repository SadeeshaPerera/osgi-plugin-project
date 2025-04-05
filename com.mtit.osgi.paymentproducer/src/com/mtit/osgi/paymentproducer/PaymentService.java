package com.mtit.osgi.paymentproducer;

public interface PaymentService {
    void processPayment(String orderId, double amount);
    void refundPayment(String orderId);
}