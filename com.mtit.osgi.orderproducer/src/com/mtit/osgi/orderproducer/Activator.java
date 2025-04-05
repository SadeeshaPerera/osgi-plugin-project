package com.mtit.osgi.orderproducer;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {
    private ServiceRegistration<?> registration;

    @Override
    public void start(BundleContext context) throws Exception {
        System.out.println("Order Producer Started!");
        OrderService orderService = new OrderServiceImpl();
        registration = context.registerService(OrderService.class.getName(), orderService, null);
    }

    @Override
    public void stop(BundleContext context) throws Exception {
        System.out.println("Order Producer Stopped!");
        registration.unregister();
    }
}