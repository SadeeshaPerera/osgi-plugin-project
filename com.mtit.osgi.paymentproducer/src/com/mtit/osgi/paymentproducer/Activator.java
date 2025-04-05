package com.mtit.osgi.paymentproducer;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {
    private ServiceRegistration<?> registration;

    @Override
    public void start(BundleContext context) throws Exception {
        System.out.println("Payment Producer Started!");
        PaymentService paymentService = new PaymentServiceImpl();
        registration = context.registerService(PaymentService.class.getName(), paymentService, null);
    }

    @Override
    public void stop(BundleContext context) throws Exception {
        System.out.println("Payment Producer Stopped!");
        registration.unregister();
    }
}