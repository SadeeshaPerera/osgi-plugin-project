package com.mtit.osgi.reviewconsumer;

import com.mtit.osgi.reviewproducer.ReviewService;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

public class Activator implements BundleActivator {
    private ServiceReference<?> reference;

    @Override
    public void start(BundleContext context) throws Exception {
        System.out.println("Review Consumer Started!");
        reference = context.getServiceReference(ReviewService.class.getName());
        if (reference != null) {
            ReviewService reviewService = (ReviewService) context.getService(reference);
            reviewService.addReview("Laptop", "Great product!");
            System.out.println("Review: " + reviewService.getReview("Laptop"));
        } else {
            System.out.println("Review Service not found!");
        }
    }

    @Override
    public void stop(BundleContext context) throws Exception {
        System.out.println("Review Consumer Stopped!");
        if (reference != null) {
            context.ungetService(reference);
        }
    }
}