package com.mtit.osgi.reviewproducer;

import java.util.HashMap;
import java.util.Map;

public class ReviewServiceImpl implements ReviewService {
    private Map<String, String> reviews = new HashMap<>();

    @Override
    public void addReview(String productName, String review) {
        reviews.put(productName, review);
        System.out.println("Review added: " + productName + " - " + review);
    }

    @Override
    public void updateReview(String productName, String review) {
        if (reviews.containsKey(productName)) {
            reviews.put(productName, review);
            System.out.println("Review updated: " + productName + " - " + review);
        } else {
            System.out.println("Review not found: " + productName);
        }
    }

    @Override
    public void deleteReview(String productName) {
        if (reviews.containsKey(productName)) {
            reviews.remove(productName);
            System.out.println("Review deleted: " + productName);
        } else {
            System.out.println("Review not found: " + productName);
        }
    }

    @Override
    public String getReview(String productName) {
        return reviews.getOrDefault(productName, "No review found");
    }
}