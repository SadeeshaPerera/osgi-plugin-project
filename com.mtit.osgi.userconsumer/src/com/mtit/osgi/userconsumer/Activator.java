package com.mtit.osgi.userconsumer;

import com.mtit.osgi.userproducer.UserService;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

public class Activator implements BundleActivator {
    private ServiceReference<?> reference;

    @Override
    public void start(BundleContext context) throws Exception {
        System.out.println("User Consumer Started!");
        reference = context.getServiceReference(UserService.class.getName());
        if (reference != null) {
            UserService userService = (UserService) context.getService(reference);
            userService.registerUser("Nimal_Perera", "nimal123@gmail.com");
            System.out.println("User Details: " + userService.getUserDetails("Nimal_Perera"));
        } else {
            System.out.println("User Service not found!");
        }
    }

    @Override
    public void stop(BundleContext context) throws Exception {
        System.out.println("User Consumer Stopped!");
        if (reference != null) {
            context.ungetService(reference);
        }
    }
}