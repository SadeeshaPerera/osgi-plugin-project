package com.mtit.osgi.inventoryproducer;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {
    private ServiceRegistration<?> registration;

    @Override
    public void start(BundleContext context) throws Exception {
        System.out.println("Inventory Producer Started!");
        InventoryService inventoryService = new InventoryServiceImpl();
        registration = context.registerService(InventoryService.class.getName(), inventoryService, null);
    }

    @Override
    public void stop(BundleContext context) throws Exception {
        System.out.println("Inventory Producer Stopped!");
        registration.unregister();
    }
}