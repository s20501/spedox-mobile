package com.example.spedox_mobile.enums;

import org.w3c.dom.DocumentType;

public enum DocumentTypeEnum {
    INVOICE("Faktura"),
    PACKING_LIST("List przewozowy"),
    BILL_OF_LADING("Dowód wyładunku\""),
    CE_CERTIFICATE("Certyfikat CE"),
    HEALTH_DEPARTMENT("Departament zdrowia"),
    VETERINARY_INSPECTORATE("Inspektorat weterynaryjny"),
    ENVIRONMENTAL_INSPECTORATE("Inspektorakt ochrony środowiska"),
    DANGEROUS_GOODS_DECLARATION("Deklaracja towarów niebiezpiecznych"),
    CUSTOM_DECLARATION("Deklaracja celna");

    private final String value;

    DocumentTypeEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static DocumentTypeEnum[] getAllValues() {
        return values();
    }
}
