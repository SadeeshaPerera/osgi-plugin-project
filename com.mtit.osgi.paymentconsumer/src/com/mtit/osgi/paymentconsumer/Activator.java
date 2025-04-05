package com.mtit.osgi.paymentconsumer;

import com.mtit.osgi.paymentproducer.PaymentService;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

public class Activator implements BundleActivator {
    private ServiceReference<?> reference;

    @Override
    public void start(BundleContext context) throws Exception {
        System.out.println("Payment Consumer Started!");
        reference = context.getServiceReference(PaymentService.class.getName());
        if (reference != null) {
            PaymentService paymentService = (PaymentService) context.getService(reference);
            paymentService.processPayment("ORD123", 1200.0);
        } else {
            System.out.println("Payment Service not found!");
        }
    }

    @Override
    public void stop(BundleContext context) throws Exception {
        System.out.println("Payment Consumer Stopped!");
        if (reference != null) {
            context.ungetService(reference);
        }
    }
}