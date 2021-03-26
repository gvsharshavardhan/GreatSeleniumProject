package com.rp.utilities;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rp.constants.FrameWorkConstants;
import com.rp.enums.ConfigProperties;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Objects;

public final class JsonUtil {
    private static HashMap configMap = new HashMap<>();

    private JsonUtil() {
    }

    static {
        try {
            configMap = new ObjectMapper().readValue(new File(FrameWorkConstants.getJSONFILEPATH()),
                    HashMap.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String get(ConfigProperties key) throws Exception {
        if (Objects.isNull(configMap.get(key.toString().toLowerCase())) || Objects.isNull(key)) {
            throw new Exception("property name :" + key + " is not found. Please check config.properties file!!");
        } else {
            return (String) configMap.get(key.name().toLowerCase());
        }
    }
}