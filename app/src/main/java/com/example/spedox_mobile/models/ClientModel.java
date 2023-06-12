package com.example.spedox_mobile.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Represents a client model.
 * This class holds information about shipmeny client.
 */
public class ClientModel implements Serializable {

    @SerializedName("id")
    private Long id;
    @SerializedName("name")
    private String name;
    @SerializedName("nip")
    private String nip;

    /**
     * Gets the ID of the client.
     *
     * @return The ID of the client.
     */
    public Long getId() {
        return id;
    }

    /**
     * Gets the name of the client.
     *
     * @return The name of the client.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the NIP (National Identification Number) of the client.
     *
     * @return The NIP of the client.
     */
    public String getNip() {
        return nip;
    }

    /**
     * Constructs a new ClientModel object with the  ID, name, and NIP.
     *
     * @param id   The ID of the client.
     * @param name The name of the client.
     * @param nip  The NIP of the client.
     */
    public ClientModel(Long id, String name, String nip) {
        this.id = id;
        this.name = name;
        this.nip = nip;
    }
}