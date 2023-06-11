package com.example.spedox_mobile.models;

import com.example.spedox_mobile.enums.DocumentStatusEnum;
import com.example.spedox_mobile.enums.DocumentTypeEnum;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class DocumentModel implements Serializable {

    @SerializedName("fileName")
    private String fileName;

    @SerializedName("status")
    private DocumentStatusEnum documentStatus;

    @SerializedName("type")
    private DocumentTypeEnum documentType;

    public String getFileName() {
        return fileName;
    }

    public DocumentStatusEnum getDocumentStatus() {
        return documentStatus;
    }

    public DocumentTypeEnum getDocumentType() {
        return documentType;
    }

    public DocumentModel(String fileName, DocumentStatusEnum documentStatus, DocumentTypeEnum documentType) {
        this.fileName = fileName;
        this.documentStatus = documentStatus;
        this.documentType = documentType;
    }
}
