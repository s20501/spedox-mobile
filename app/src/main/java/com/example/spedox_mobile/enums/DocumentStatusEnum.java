package com.example.spedox_mobile.enums;

public enum DocumentStatusEnum {
    PENDING("Oczekujace"),
    APPROVED("Zatwierdzone"),
    REJECTED("Odrzucone");

    private String status;

    DocumentStatusEnum(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}