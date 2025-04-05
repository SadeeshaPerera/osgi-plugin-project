package com.mtit.osgi.discountconsumer;

import com.mtit.osgi.discountproducer.DiscountService;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

public class Activator implements BundleActivator {
    private ServiceReference<?> reference;

    @Override
    public void start(BundleContext context) throws Exception {
        System.out.println("Discount Consumer Started!");
        reference = context.getServiceReference(DiscountService.class.getName());
        if (reference != null) {
            DiscountService discountService = (DiscountService) context.getService(reference);
            discountService.applyDiscount("ORD123", 10.0);
            System.out.println("Discount: " + discountService.getDiscount("ORD123") + "%");
        } else {
            System.out.println("Discount Service not found!");
        }
    }

    @Override
    public void stop(BundleContext context) throws Exception {
        System.out.println("Discount Consumer Stopped!");
        if (reference != null) {
            context.ungetService(reference);
        }
    }
}