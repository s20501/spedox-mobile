package com.example.spedox_mobile.models;

import com.example.spedox_mobile.enums.DocumentStatusEnum;
import com.example.spedox_mobile.enums.DocumentTypeEnum;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Represents a document model.
 * This class holds information about shipment documents
 */
public class DocumentModel implements Serializable {

    @SerializedName("fileName")
    private String fileName;

    @SerializedName("status")
    private DocumentStatusEnum documentStatus;

    @SerializedName("type")
    private DocumentTypeEnum documentType;

    /**
     * Gets the file name of the document.
     *
     * @return The file name of the document.
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * Gets the status of the document.
     *
     * @return The status of the document.
     */
    public DocumentStatusEnum getDocumentStatus() {
        return documentStatus;
    }

    /**
     * Gets the type of the document.
     *
     * @return The type of the document.
     */
    public DocumentTypeEnum getDocumentType() {
        return documentType;
    }

    /**
     * Constructs a new DocumentModel object with the specified file name, document status, and document type.
     *
     * @param fileName        The file name of the document.
     * @param documentStatus  The status of the document.
     * @param documentType    The type of the document.
     */
    public DocumentModel(String fileName, DocumentStatusEnum documentStatus, DocumentTypeEnum documentType) {
        this.fileName = fileName;
        this.documentStatus = documentStatus;
        this.documentType = documentType;
    }
}