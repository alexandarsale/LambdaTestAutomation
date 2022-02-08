package com.pagefact.Utils;

import com.pagefact.constants.FrameworkConstants;
import com.pagefact.exceptions.InvalidFilePathException;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

public final class ReadPropertyFile {

    private ReadPropertyFile() {
    }

    /*Usage of static block is that it will load at the time of
     class loading. So adding the code to reade the confing properties in static block
     will load as the first thing when the class is loaded, this will save
     all the config properties in memory so that other tests can read it faster */
    private static Properties properties = new Properties();

    static {
        FileInputStream fs;
        try {
            fs = new FileInputStream(FrameworkConstants.getConfigFilePath());
            properties.load(fs);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getValue(String key) {
        String value;
        value = properties.getProperty(key);
        if (Objects.isNull(value)) {
            throw new InvalidFilePathException("Property name " + key + " is not found. Please check config.properties");
        }
        return value;
    }
}
