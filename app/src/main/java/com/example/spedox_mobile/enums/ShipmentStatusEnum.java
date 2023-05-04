package com.example.spedox_mobile.enums;

public enum ShipmentStatusEnum {
    ORDER_RECEIVED("ERE"),
    GOODS_READY("EGR"),
    EXPORT_CUSTOM_CLEARANCE("ECC"),
    EXPORT_LOADED("ELO"),
    SHIPMENT_IN_WAY_TO_PORT("EIT"),
    SHIPMENT_IN_LOADING_PORT("EIP"),
    DURING_TRANSPORT("SEA"),
    SHIPMENT_IN_DESTINATION_PORT("IIP"),
    UNLOADED_FROM_SHIP("IUN"),
    IMPORT_CUSTOM_CLEARANCE_DONE("ICC"),
    SHIPMENT_INLAND_DELIVERY("IIT"),
    SHIPMENT_DELIVERED("IRE");


    public final String status;

    private ShipmentStatusEnum(String status) {
        this.status = status;
    }
}
