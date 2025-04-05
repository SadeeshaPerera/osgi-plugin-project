package com.mtit.osgi.reviewproducer;

public interface ReviewService {
    void addReview(String productName, String review);
    void updateReview(String productName, String review);
    void deleteReview(String productName);
    String getReview(String productName);
}