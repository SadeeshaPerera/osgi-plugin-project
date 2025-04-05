package com.mtit.osgi.shippingproducer;

public interface ShippingService {
	String createShipment(String orderId, String address);
    void cancelShipment(String shipmentId);
    String getShipmentDetails(String shipmentId);
}