package com.example.spedox_mobile.enums;

public enum IcotermsEnum {
    EX_WORKS("EXW"),
    DELIVERED_AT_PLACE("DAP"),
    FREE_ON_BOARD("FOB"),
    COST_INSURANCE_AND_FREIGHT("CIF");

    public final String icoTermenum;

    IcotermsEnum(String icoTermenum) {
        this.icoTermenum = icoTermenum;
    }
}
