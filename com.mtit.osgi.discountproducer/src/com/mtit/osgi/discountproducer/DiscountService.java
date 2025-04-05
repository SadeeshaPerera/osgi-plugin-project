package com.mtit.osgi.discountproducer;

public interface DiscountService {
    void applyDiscount(String orderId, double discount);
    void removeDiscount(String orderId);
    double getDiscount(String orderId);
}