package com.mtit.osgi.discountproducer;

import java.util.HashMap;
import java.util.Map;

public class DiscountServiceImpl implements DiscountService {
    private Map<String, Double> discounts = new HashMap<>();

    @Override
    public void applyDiscount(String orderId, double discount) {
        discounts.put(orderId, discount);
        System.out.println("Discount applied: " + orderId + " - " + discount + "%");
    }

    @Override
    public void removeDiscount(String orderId) {
        if (discounts.containsKey(orderId)) {
            discounts.remove(orderId);
            System.out.println("Discount removed: " + orderId);
        } else {
            System.out.println("Discount not found: " + orderId);
        }
    }

    @Override
    public double getDiscount(String orderId) {
        return discounts.getOrDefault(orderId, 0.0);
    }
}