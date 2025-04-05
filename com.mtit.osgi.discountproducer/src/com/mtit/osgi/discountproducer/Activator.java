package com.mtit.osgi.discountproducer;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {
    private ServiceRegistration<?> registration;

    @Override
    public void start(BundleContext context) throws Exception {
        System.out.println("Discount Producer Started!");
        DiscountService discountService = new DiscountServiceImpl();
        registration = context.registerService(DiscountService.class.getName(), discountService, null);
    }

    @Override
    public void stop(BundleContext context) throws Exception {
        System.out.println("Discount Producer Stopped!");
        registration.unregister();
    }
}