package com.mtit.osgi.productconsumer;

import com.mtit.osgi.productproducer.ProductService;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

public class Activator implements BundleActivator {
    private ServiceReference<?> reference;

    @Override
    public void start(BundleContext context) throws Exception {
        System.out.println("Product Consumer Started!");
        reference = context.getServiceReference(ProductService.class.getName());
        if (reference != null) {
            ProductService productService = (ProductService) context.getService(reference);
            productService.addProduct("Laptop", 1200.0);
            productService.addProduct("Phone", 800.0);
            System.out.println("Product Details: " + productService.getProductDetails());
        } else {
            System.out.println("Product Service not found!");
        }
    }

    @Override
    public void stop(BundleContext context) throws Exception {
        System.out.println("Product Consumer Stopped!");
        if (reference != null) {
            context.ungetService(reference);
        }
    }
}