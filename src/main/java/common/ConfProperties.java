package common;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public enum ConfProperties {
    INSTANCE;

    Properties PROPERTIES;

    private ConfProperties() {
        FileInputStream fileInputStream = null;
        try {
            //file conf path
            fileInputStream = new FileInputStream("src/main/resources/conf.properties");
            PROPERTIES = new Properties();
            PROPERTIES.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();

        } finally {
            if (fileInputStream != null)
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }

    public static String getPropertyChromeDriver() {
        return ConfProperties.INSTANCE.PROPERTIES.getProperty("chrome_driver");
    }

    public static String getPropertyMainPageLink() {
        return ConfProperties.INSTANCE.PROPERTIES.getProperty("main_page_link");
    }
}