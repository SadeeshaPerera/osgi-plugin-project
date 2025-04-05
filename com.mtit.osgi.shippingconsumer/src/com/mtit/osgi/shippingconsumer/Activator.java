package com.mtit.osgi.shippingconsumer;

import com.mtit.osgi.shippingproducer.ShippingService;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

public class Activator implements BundleActivator {
    private ServiceReference<?> reference;

    @Override
    public void start(BundleContext context) throws Exception {
        System.out.println("Shipping Consumer Started!");
        reference = context.getServiceReference(ShippingService.class.getName());
        if (reference != null) {
            ShippingService shippingService = (ShippingService) context.getService(reference);
            String shipmentId = shippingService.createShipment("ORD123", "No2, Main Road, Colombo-05");
            System.out.println("Shipment Details: " + shippingService.getShipmentDetails(shipmentId));
        } else {
            System.out.println("Shipping Service not found!");
        }
    }

    @Override
    public void stop(BundleContext context) throws Exception {
        System.out.println("Shipping Consumer Stopped!");
        if (reference != null) {
            context.ungetService(reference);
        }
    }
}