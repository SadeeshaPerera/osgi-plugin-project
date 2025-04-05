package com.mtit.osgi.orderconsumer;

import com.mtit.osgi.orderproducer.OrderService;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

public class Activator implements BundleActivator {
    private ServiceReference<?> reference;

    @Override
    public void start(BundleContext context) throws Exception {
        System.out.println("Order Consumer Started!");
        reference = context.getServiceReference(OrderService.class.getName());
        if (reference != null) {
            OrderService orderService = (OrderService) context.getService(reference);
            String orderId = orderService.createOrder("Laptop", 1);
            System.out.println("Order Details: " + orderService.getOrderDetails(orderId));
        } else {
            System.out.println("Order Service not found!");
        }
    }

    @Override
    public void stop(BundleContext context) throws Exception {
        System.out.println("Order Consumer Stopped!");
        if (reference != null) {
            context.ungetService(reference);
        }
    }
}