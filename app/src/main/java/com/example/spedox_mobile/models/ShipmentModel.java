package com.example.spedox_mobile.models;

public class ShipmentModel {
    private String id;
    private String blNumber;

    public String getId() {
        return id;
    }

    public String getBlNumber() {
        return blNumber;
    }

    public ShipmentModel(String id, String blNumber) {
        this.id = id;
        this.blNumber = blNumber;
    }
}
