package com.works.project.models;

import java.time.OffsetDateTime;

public class Meta {
    private String createdAt;
    private String updatedAt;
    private String barcode;
    private String qrCode;

    public String getCreatedAt() { return createdAt; }
    public void setCreatedAt(String value) { this.createdAt = value; }

    public String getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(String value) { this.updatedAt = value; }

    public String getBarcode() { return barcode; }
    public void setBarcode(String value) { this.barcode = value; }

    public String getQrCode() { return qrCode; }
    public void setQrCode(String value) { this.qrCode = value; }
}
