package com.example.spedox_mobile.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ClientModel implements Serializable {

    @SerializedName("id")
    private Long id;
    @SerializedName("name")
    private String name;
    @SerializedName("nip")
    private String nip;


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getNip() {
        return nip;
    }

    public ClientModel(Long id, String name, String nip) {
        this.id = id;
        this.name = name;
        this.nip = nip;
    }
}
