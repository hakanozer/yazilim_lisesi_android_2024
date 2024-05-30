package com.works.project.models;

import java.io.IOException;

public enum ReturnPolicy {
    NO_RETURN_POLICY, THE_30_DAYS_RETURN_POLICY, THE_60_DAYS_RETURN_POLICY, THE_7_DAYS_RETURN_POLICY, THE_90_DAYS_RETURN_POLICY;

    public String toValue() {
        switch (this) {
            case NO_RETURN_POLICY: return "No return policy";
            case THE_30_DAYS_RETURN_POLICY: return "30 days return policy";
            case THE_60_DAYS_RETURN_POLICY: return "60 days return policy";
            case THE_7_DAYS_RETURN_POLICY: return "7 days return policy";
            case THE_90_DAYS_RETURN_POLICY: return "90 days return policy";
        }
        return null;
    }

    public static ReturnPolicy forValue(String value) throws IOException {
        if (value.equals("No return policy")) return NO_RETURN_POLICY;
        if (value.equals("30 days return policy")) return THE_30_DAYS_RETURN_POLICY;
        if (value.equals("60 days return policy")) return THE_60_DAYS_RETURN_POLICY;
        if (value.equals("7 days return policy")) return THE_7_DAYS_RETURN_POLICY;
        if (value.equals("90 days return policy")) return THE_90_DAYS_RETURN_POLICY;
        throw new IOException("Cannot deserialize ReturnPolicy");
    }
}
