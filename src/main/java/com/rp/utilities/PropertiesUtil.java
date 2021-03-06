package com.rp.utilities;

import com.rp.constants.FrameWorkConstants;
import com.rp.enums.ConfigProperties;
import com.rp.exceptions.ImproperPropertyFileUsageException;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

public final class PropertiesUtil {

    private static final Properties prop = new Properties();
    private static final Map<String, String> configMap = new HashMap<>();

    private PropertiesUtil() {

    }

    static {
        try (FileInputStream fileInputStream = new FileInputStream(FrameWorkConstants.getPROPERTYFILEPATH())) {
            prop.load(fileInputStream);
/*
            for (Map.Entry entry : prop.entrySet()) {
                configMap.put(String.valueOf(entry.getKey()), String.valueOf(prop.get(entry.getValue())));
            }
*/
            prop.entrySet().forEach(e -> configMap.put(String.valueOf(e.getKey()),
                    String.valueOf(e.getValue()).trim()));


        } catch (IOException e) {
            e.printStackTrace();
            System.exit(0);
        }
    }

    public static String get(ConfigProperties key) {
        if (Objects.isNull(configMap.get(key.toString().toLowerCase())) || Objects.isNull(key)) {
            throw new ImproperPropertyFileUsageException("property name :" + key + " is not found. Please check config.properties file!!");
        } else {
            return configMap.get(key.name().toLowerCase());
        }
    }

    public static String getPropertyValue(ConfigProperties key) {
        if (Objects.isNull(prop.getProperty(key.toString().toLowerCase())) || Objects.isNull(key)) {
            throw new ImproperPropertyFileUsageException("property name :" + key + " is not found. Please check config.properties file!!");
        } else {
            return prop.getProperty(key.name().toLowerCase());
        }
    }
}