package com.example.spedox_mobile.enums;

public enum ShipmentTypeEnum {
    FULL_CONTAINER_LOAD("FCL"),
    LESS_THAN_CONTAINER_LOAD("LTC");

    public final String shipmentType;

    ShipmentTypeEnum(String shipmentType) {
        this.shipmentType = shipmentType;
    }
}
