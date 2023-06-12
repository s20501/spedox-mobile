package com.example.spedox_mobile.models;

import java.io.File;

/**
 * Represents a REST model for a document.
 * This class holds information about a document rest model.
 */
public class DocumentRestModel {
    private String id;
    private String type;
    private String clientId;
    private String shipmentId;
    private String creator;
    private File file;

    /**
     * Sets the type of the document.
     *
     * @param type The type of the document.
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Sets the client ID associated with the document.
     *
     * @param clientId The client ID associated with the document.
     */
    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    /**
     * Sets the shipment ID associated with the document.
     *
     * @param shipmentId The shipment ID associated with the document.
     */
    public void setShipmentId(String shipmentId) {
        this.shipmentId = shipmentId;
    }

    /**
     * Sets the creator of the document.
     *
     * @param creator The creator of the document.
     */
    public void setCreator(String creator) {
        this.creator = creator;
    }

    /**
     * Sets the file of the document.
     *
     * @param file The file of the document.
     */
    public void setFile(File file) {
        this.file = file;
    }

    /**
     * Gets the ID of the document.
     *
     * @return The ID of the document.
     */
    public String getId() {
        return id;
    }

    /**
     * Gets the type of the document.
     *
     * @return The type of the document.
     */
    public String getType() {
        return type;
    }

    /**
     * Gets the client ID associated with the document.
     *
     * @return The client ID associated with the document.
     */
    public String getClientId() {
        return clientId;
    }

    /**
     * Gets the shipment ID associated with the document.
     *
     * @return The shipment ID associated with the document.
     */
    public String getShipmentId() {
        return shipmentId;
    }

    /**
     * Gets the creator of the document.
     *
     * @return The creator of the document.
     */
    public String getCreator() {
        return creator;
    }

    /**
     * Gets the file of the document.
     *
     * @return The file of the document.
     */
    public File getFile() {
        return file;
    }

    /**
     * Constructs a new DocumentRestModel object with the specified ID, type, client ID, shipment ID, creator, and file.
     *
     * @param id         The ID of the document.
     * @param type       The type of the document.
     * @param clientId   The client ID associated with the document.
     * @param shipmentId The shipment ID associated with the document.
     * @param creator    The creator of the document.
     * @param file       The file of the document.
     */
    public DocumentRestModel(String id, String type, String clientId, String shipmentId, String creator, File file) {
        this.id = id;
        this.type = type;
        this.clientId = clientId;
        this.shipmentId = shipmentId;
        this.creator = creator;
        this.file = file;
    }

    /**
     * Constructs a new DocumentRestModel object with the specified ID, type, shipment ID, and file.
     *
     * @param id         The ID of the document.
     * @param type       The type of the document.
     * @param shipmentId The shipment ID associated with the document.
     * @param file       The file of the document.
     */
    public DocumentRestModel(String id, String type, String shipmentId, File file) {
        this.id = id;
        this.type = type;
        this.shipmentId = shipmentId;
        this.file = file;
    }

    /**
     * Constructs a new empty DocumentRestModel object.
     */
    public DocumentRestModel() {
    }
}
