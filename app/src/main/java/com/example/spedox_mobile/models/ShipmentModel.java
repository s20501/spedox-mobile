package com.example.spedox_mobile.models;

import com.example.spedox_mobile.enums.ShipmentStatusEnum;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ShipmentModel implements Serializable {

    @SerializedName("status")
    private ShipmentStatusEnum status;

    @SerializedName("blNumber")
    private String blNumber;


    public String getBlNumber() {
        return blNumber;
    }

    public ShipmentStatusEnum getStatus() {
        return status;
    }

    public ShipmentModel(ShipmentStatusEnum status, String blNumber) {
        this.status = status;
        this.blNumber = blNumber;
    }
}
