package com.mtit.osgi.userproducer;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {
    private ServiceRegistration<?> registration;

    @Override
    public void start(BundleContext context) throws Exception {
        System.out.println("User Producer Started!");
        UserService userService = new UserServiceImpl();
        registration = context.registerService(UserService.class.getName(), userService, null);
    }

    @Override
    public void stop(BundleContext context) throws Exception {
        System.out.println("User Producer Stopped!");
        registration.unregister();
    }
}