package com.example.spedox_mobile.models;

import com.example.spedox_mobile.enums.IcotermsEnum;
import com.example.spedox_mobile.enums.ShipmentDirectionEnum;
import com.example.spedox_mobile.enums.ShipmentStatusEnum;
import com.example.spedox_mobile.enums.ShipmentTypeEnum;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Represents a shipment model.
 * This class holds information about a shipment
 */
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

    /**
     * Gets the list of documents associated with the shipment.
     *
     * @return The list of documents associated with the shipment.
     */
    public List<DocumentModel> getDocuments() {
        return documents;
    }

    /**
     * Gets the status of the shipment.
     *
     * @return The status of the shipment.
     */
    public ShipmentStatusEnum getStatus() {
        return status;
    }

    /**
     * Gets the Bill of Lading (BL) number of the shipment.
     *
     * @return The Bill of Lading (BL) number of the shipment.
     */
    public String getBlNumber() {
        return blNumber;
    }

    /**
     * Gets the client model associated with the shipment.
     *
     * @return The client model associated with the shipment.
     */
    public ClientModel getClientModel() {
        return clientModel;
    }

    /**
     * Gets the consignee client model of the shipment.
     *
     * @return The consignee client model of the shipment.
     */
    public ClientModel getConsignee() {
        return consignee;
    }

    /**
     * Gets the shipper client model of the shipment.
     *
     * @return The shipper client model of the shipment.
     */
    public ClientModel getShipper() {
        return shipper;
    }

    /**
     * Gets the Incoterms (International Commercial Terms) of the shipment.
     *
     * @return The Incoterms of the shipment.
     */
    public IcotermsEnum getIcoterms() {
        return icoterms;
    }

    /**
     * Gets the direction of the shipment.
     *
     * @return The direction of the shipment.
     */
    public ShipmentDirectionEnum getDirection() {
        return direction;
    }

    /**
     * Gets the port of loading for the shipment.
     *
     * @return The port of loading for the shipment.
     */
    public String getPortOfLoading() {
        return portOfLoading;
    }

    /**
     * Gets the loading date of the shipment.
     *
     * @return The loading date of the shipment.
     */
    public Date getLoadingDate() {
        return loadingDate;
    }

    /**
     * Gets the port of destination for the shipment.
     *
     * @return The port of destination for the shipment.
     */
    public String getPortOfDestination() {
        return portOfDestination;
    }

    /**
     * Gets the destination date of the shipment.
     *
     * @return The destination date of the shipment.
     */
    public Date getDestinationDate() {
        return destinationDate;
    }

    /**
     * Gets the type of the shipment.
     *
     * @return The type of the shipment.
     */
    public ShipmentTypeEnum getType() {
        return type;
    }

    /**
     * Gets the value of the shipment.
     *
     * @return The value of the shipment.
     */
    public String getValue() {
        return value;
    }

    /**
     * Gets the currency of the shipment value.
     *
     * @return The currency of the shipment value.
     */
    public String getValueCurrency() {
        return valueCurrency;
    }

    /**
     * Checks if the shipment has insurance.
     *
     * @return true if the shipment has insurance, false otherwise.
     */
    public boolean isInsurance() {
        return insurance;
    }

    /**
     * Gets the ID of the shipment.
     *
     * @return The ID of the shipment.
     */
    public String getId() {
        return id;
    }

    /**
     * Constructs a new ShipmentModel object with the specified parameters.
     *
     * @param id                The ID of the shipment.
     * @param documents         The list of documents associated with the shipment.
     * @param status            The status of the shipment.
     * @param blNumber          The Bill of Lading (BL) number of the shipment.
     * @param clientModel       The client model associated with the shipment.
     * @param shipper           The shipper client model of the shipment.
     * @param consignee         The consignee client model of the shipment.
     * @param direction         The direction of the shipment.
     * @param icoterms          The Incoterms of the shipment.
     * @param portOfLoading     The port of loading for the shipment.
     * @param loadingDate       The loading date of the shipment.
     * @param portOfDestination The port of destination for the shipment.
     * @param destinationDate   The destination date of the shipment.
     * @param type              The type of the shipment.
     * @param value             The value of the shipment.
     * @param valueCurrency     The currency of the shipment value.
     * @param insurance         Indicates if the shipment has insurance.
     */
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