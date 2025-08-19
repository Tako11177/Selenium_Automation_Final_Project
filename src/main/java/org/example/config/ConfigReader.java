package org.example.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static Properties props = new Properties();

    static {
        try {
            FileInputStream fis = new FileInputStream("src/main/resources/config.properties");
            props.load(fis);
        } catch (IOException e) {
            throw new RuntimeException("Config file not found");
        }
    }

    public static String get(String key) {
        return props.getProperty(key);
    }
}
