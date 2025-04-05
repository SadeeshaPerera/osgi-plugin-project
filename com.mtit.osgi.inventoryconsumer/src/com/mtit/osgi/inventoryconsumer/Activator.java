package com.mtit.osgi.inventoryconsumer;

import com.mtit.osgi.inventoryproducer.InventoryService;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

public class Activator implements BundleActivator {
    private ServiceReference<?> reference;

    @Override
    public void start(BundleContext context) throws Exception {
        System.out.println("Inventory Consumer Started!");
        reference = context.getServiceReference(InventoryService.class.getName());
        if (reference != null) {
            InventoryService inventoryService = (InventoryService) context.getService(reference);
            inventoryService.addStock("Laptop", 10);
            inventoryService.addStock("Phone", 20);
            System.out.println("Laptop Stock: " + inventoryService.checkStock("Laptop"));
        } else {
            System.out.println("Inventory Service not found!");
        }
    }

    @Override
    public void stop(BundleContext context) throws Exception {
        System.out.println("Inventory Consumer Stopped!");
        if (reference != null) {
            context.ungetService(reference);
        }
    }
}