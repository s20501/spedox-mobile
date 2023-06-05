package com.example.spedox_mobile.models;

import com.example.spedox_mobile.enums.IcotermsEnum;
import com.example.spedox_mobile.enums.ShipmentDirectionEnum;
import com.example.spedox_mobile.enums.ShipmentStatusEnum;
import com.example.spedox_mobile.enums.ShipmentTypeEnum;
import com.google.gson.annotations.SerializedName;
import java.util.Date;

import java.io.Serializable;

public class ShipmentModel implements Serializable {

    @SerializedName("status")
    private ShipmentStatusEnum status;

    @SerializedName("blNumber")
    private String blNumber;

    @SerializedName("shipper")
    private ClientModel clientModel;

    @SerializedName("direction")
    private ShipmentDirectionEnum direction;

    @SerializedName("icoterms")
    private IcotermsEnum icoterms;

    @SerializedName("portOfLoading")
    private String portOfLoading;

    @SerializedName("loadingDate")
    private Date loadingDate;


    @SerializedName("portOfDestination")
    private String portOfDestination;

   // private ClientModel shipper;

   // private ClientModel consignee;

    private Date destinationDate;

    private ShipmentTypeEnum type;

    private String value;

    private String valueCurrency;

    private boolean insurance;

    public ShipmentStatusEnum getStatus() {
        return status;
    }

    public String getBlNumber() {
        return blNumber;
    }

    public ClientModel getClientModel() {
        return clientModel;
    }

    public IcotermsEnum getIcoterms() {
        return icoterms;
    }

    public ShipmentDirectionEnum getDirection() {
        return direction;
    }

    public String getPortOfLoading() {
        return portOfLoading;
    }

    public Date getLoadingDate() {
        return loadingDate;
    }

    public String getPortOfDestination() {
        return portOfDestination;
    }

    public Date getDestinationDate() {
        return destinationDate;
    }

    public ShipmentTypeEnum getType() {
        return type;
    }

    public String getValue() {
        return value;
    }

    public String getValueCurrency() {
        return valueCurrency;
    }

    public boolean isInsurance() {
        return insurance;
    }


    public ShipmentModel(ShipmentStatusEnum status, String blNumber, ClientModel clientModel, ShipmentDirectionEnum direction, IcotermsEnum icoterms, String portOfLoading, Date loadingDate, String portOfDestination, ClientModel shipper, ClientModel consignee, Date destinationDate, ShipmentTypeEnum type, String value, String valueCurrency, boolean insurance) {
        this.status = status;
        this.blNumber = blNumber;
        this.clientModel = clientModel;
        this.direction = direction;
        this.icoterms = icoterms;
        this.portOfLoading = portOfLoading;
        this.loadingDate = loadingDate;
        this.portOfDestination = portOfDestination;
        this.destinationDate = destinationDate;
        this.type = type;
        this.value = value;
        this.valueCurrency = valueCurrency;
        this.insurance = insurance;
    }
}
