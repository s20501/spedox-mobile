package com.example.spedox_mobile.enums;

public enum ShipmentDirectionEnum {
    IMPORT("IMPORT"),
    EXPORT("EXPORT");

    public final String directionEnum;

    ShipmentDirectionEnum(String directionEnum) {
        this.directionEnum = directionEnum;
    }
}
