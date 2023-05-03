package com.example.spedox_mobile.models;

import com.google.gson.annotations.SerializedName;

public class ShipmentModel {

    @SerializedName("status")
    private String status;

    @SerializedName("blNumber")
    private String blNumber;


    public String getBlNumber() {
        return blNumber;
    }

    public String getStatus() {
        return status;
    }

    public ShipmentModel(String status, String blNumber) {
        this.status = status;
        this.blNumber = blNumber;
    }
}
