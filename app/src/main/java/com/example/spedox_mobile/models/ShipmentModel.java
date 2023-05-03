package com.example.spedox_mobile.models;

import com.google.gson.annotations.SerializedName;

public class ShipmentModel {
    @SerializedName("id")
    private String id;

    @SerializedName("blNumber")
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
