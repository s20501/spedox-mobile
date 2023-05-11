package com.example.spedox_mobile.models;

import com.example.spedox_mobile.enums.ShipmentStatusEnum;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ShipmentModel implements Serializable {

    @SerializedName("status")
    private ShipmentStatusEnum status;

    @SerializedName("blNumber")
    private String blNumber;

    @SerializedName("shipper")
    private ClientModel clientModel;

    public ShipmentStatusEnum getStatus() {
        return status;
    }

    public String getBlNumber() {
        return blNumber;
    }

    public ClientModel getClientModel() {
        return clientModel;
    }

    public ShipmentModel(ShipmentStatusEnum status, String blNumber, ClientModel clientModel) {
        this.status = status;
        this.blNumber = blNumber;
        this.clientModel = clientModel;
    }
}
