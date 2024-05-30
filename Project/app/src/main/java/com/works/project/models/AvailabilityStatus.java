package com.works.project.models;

import java.io.IOException;

public enum AvailabilityStatus {
    IN_STOCK, LOW_STOCK;

    public String toValue() {
        switch (this) {
            case IN_STOCK: return "In Stock";
            case LOW_STOCK: return "Low Stock";
        }
        return null;
    }

    public static AvailabilityStatus forValue(String value) throws IOException {
        if (value.equals("In Stock")) return IN_STOCK;
        if (value.equals("Low Stock")) return LOW_STOCK;
        throw new IOException("Cannot deserialize AvailabilityStatus");
    }
}
