package com.works.project.models;

import java.io.IOException;

public enum Category {
    BEAUTY, FRAGRANCES, FURNITURE, GROCERIES;

    public String toValue() {
        switch (this) {
            case BEAUTY: return "beauty";
            case FRAGRANCES: return "fragrances";
            case FURNITURE: return "furniture";
            case GROCERIES: return "groceries";
        }
        return null;
    }

    public static Category forValue(String value) throws IOException {
        if (value.equals("beauty")) return BEAUTY;
        if (value.equals("fragrances")) return FRAGRANCES;
        if (value.equals("furniture")) return FURNITURE;
        if (value.equals("groceries")) return GROCERIES;
        throw new IOException("Cannot deserialize Category");
    }
}
