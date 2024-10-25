package com.example.skill21.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtil {
    private static final Properties PROPERTIES = new Properties();

    static
    {
        loadProperties();
    }
    private PropertiesUtil()
    {

    }
    public static String get(String key)
    {
        return PROPERTIES.getProperty(key);
    }
    private static void loadProperties()
    {
        try (FileInputStream fis = new FileInputStream("res/application.properties"))
        {
            PROPERTIES.load(fis);
        }
        catch (IOException ex)
        {
            throw new RuntimeException(ex);
        }
    }



}
