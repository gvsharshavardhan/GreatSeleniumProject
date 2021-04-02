package com.rp.utilities;

public final class DynamicXpathUtil {


    private DynamicXpathUtil() {
    }

    public static String getXpath(String xpath, String value) {
        return String.format(xpath, value);
    }
}
