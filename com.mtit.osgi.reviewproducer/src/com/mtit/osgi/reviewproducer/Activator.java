package com.mtit.osgi.reviewproducer;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {
    private ServiceRegistration<?> registration;

    @Override
    public void start(BundleContext context) throws Exception {
        System.out.println("Review Producer Started!");
        ReviewService reviewService = new ReviewServiceImpl();
        registration = context.registerService(ReviewService.class.getName(), reviewService, null);
    }

    @Override
    public void stop(BundleContext context) throws Exception {
        System.out.println("Review Producer Stopped!");
        registration.unregister();
    }
}