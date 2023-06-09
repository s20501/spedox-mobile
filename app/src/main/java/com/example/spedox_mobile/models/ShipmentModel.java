package com.example.spedox_mobile.models;

import com.example.spedox_mobile.enums.IcotermsEnum;
import com.example.spedox_mobile.enums.ShipmentDirectionEnum;
import com.example.spedox_mobile.enums.ShipmentStatusEnum;
import com.example.spedox_mobile.enums.ShipmentTypeEnum;
import com.google.gson.annotations.SerializedName;
import java.util.Date;

import java.io.Serializable;
import java.util.List;

public class ShipmentModel implements Serializable {

    @SerializedName("id")
    private String id;

    @SerializedName("documents")
    private List<DocumentModel> documents;

    @SerializedName("status")
    private ShipmentStatusEnum status;

    @SerializedName("blNumber")
    private String blNumber;

    @SerializedName("client")
    private ClientModel clientModel;

    @SerializedName("shipper")
    private ClientModel shipper;

    @SerializedName("consignee")
    private ClientModel consignee;

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


    @SerializedName("destinationDate")
    private Date destinationDate;

    private ShipmentTypeEnum type;

    private String value;

    private String valueCurrency;

    private boolean insurance;

    public List<DocumentModel> getDocuments() {
        return documents;
    }

    public ShipmentStatusEnum getStatus() {
        return status;
    }

    public String getBlNumber() {
        return blNumber;
    }

    public ClientModel getClientModel() {
        return clientModel;
    }

    public ClientModel getConsignee() {
        return consignee;
    }

    public ClientModel getShipper() {
        return shipper;
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

    public String getId() {
        return id;
    }


    public ShipmentModel(String id, List<DocumentModel> documents, ShipmentStatusEnum status, String blNumber, ClientModel clientModel, ClientModel shipper, ClientModel consignee, ShipmentDirectionEnum direction, IcotermsEnum icoterms, String portOfLoading, Date loadingDate, String portOfDestination, Date destinationDate, ShipmentTypeEnum type, String value, String valueCurrency, boolean insurance) {
        this.id = id;
        this.documents = documents;
        this.status = status;
        this.blNumber = blNumber;
        this.clientModel = clientModel;
        this.shipper = shipper;
        this.consignee = consignee;
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
