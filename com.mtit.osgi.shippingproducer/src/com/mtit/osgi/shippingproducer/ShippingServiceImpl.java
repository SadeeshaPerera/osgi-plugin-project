package com.mtit.osgi.shippingproducer;

import java.util.HashMap;
import java.util.Map;

public class ShippingServiceImpl implements ShippingService {
    private Map<String, String> shipments = new HashMap<>();

    @Override
    public String createShipment(String orderId, String address) {
        String shipmentId = "SHIP" + System.currentTimeMillis();
        shipments.put(shipmentId, orderId + " - " + address);
        System.out.println("Shipment created: " + shipmentId + " - " + orderId + " - " + address);
        
        return shipmentId;
    }

    @Override
    public void cancelShipment(String shipmentId) {
        if (shipments.containsKey(shipmentId)) {
            shipments.remove(shipmentId);
            System.out.println("Shipment canceled: " + shipmentId);
        } else {
            System.out.println("Shipment not found: " + shipmentId);
        }
    }

    @Override
    public String getShipmentDetails(String shipmentId) {
        return shipments.getOrDefault(shipmentId, "Shipment not found");
    }
}