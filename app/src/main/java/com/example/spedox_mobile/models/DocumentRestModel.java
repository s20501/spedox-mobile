package com.example.spedox_mobile.models;


import java.io.File;

public class DocumentRestModel {
    private String id;
    private String type;
  //  private DocumentStatusEnum status;
    private String clientId;
    private String shipmentId;
//    private Date addedAt;
//    private Date updatedAt;
    private String creator;
    private File file;

    public void setType(String type) {
        this.type = type;
    }


    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public void setShipmentId(String shipmentId) {
        this.shipmentId = shipmentId;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getClientId() {
        return clientId;
    }

    public String getShipmentId() {
        return shipmentId;
    }

    public String getCreator() {
        return creator;
    }

    public File getFile() {
        return file;
    }

    public DocumentRestModel(String id, String type, String clientId, String shipmentId, String creator, File file) {
        this.id = id;
        this.type = type;
        this.clientId = clientId;
        this.shipmentId = shipmentId;
        this.creator = creator;
        this.file = file;
    }

    public DocumentRestModel(String id, String type, String shipmentId, File file) {
        this.id = id;
        this.type = type;
        this.shipmentId = shipmentId;
        this.file = file;
    }
}
