package com.mtit.osgi.productproducer;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {
    private ServiceRegistration<?> registration;

    @Override
    public void start(BundleContext context) throws Exception {
        System.out.println("Product Producer Started!");
        ProductService productService = new ProductServiceImpl();
        registration = context.registerService(ProductService.class.getName(), productService, null);
    }

    @Override
    public void stop(BundleContext context) throws Exception {
        System.out.println("Product Producer Stopped!");
        registration.unregister();
    }
}