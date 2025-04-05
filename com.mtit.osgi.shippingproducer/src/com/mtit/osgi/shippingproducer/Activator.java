package com.mtit.osgi.shippingproducer;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {
    private ServiceRegistration<?> registration;

    @Override
    public void start(BundleContext context) throws Exception {
        System.out.println("Shipping Producer Started!");
        ShippingService shippingService = new ShippingServiceImpl();
        registration = context.registerService(ShippingService.class.getName(), shippingService, null);
    }

    @Override
    public void stop(BundleContext context) throws Exception {
        System.out.println("Shipping Producer Stopped!");
        registration.unregister();
    }
}