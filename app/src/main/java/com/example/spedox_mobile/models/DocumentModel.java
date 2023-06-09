package com.example.spedox_mobile.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class DocumentModel implements Serializable {

    @SerializedName("fileName")
    private String fileName;

    public String getFileName() {
        return fileName;
    }

    public DocumentModel(String fileName) {
        this.fileName = fileName;
    }
}
