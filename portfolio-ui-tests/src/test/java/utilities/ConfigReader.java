package utilities;

import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    private static final Properties properties = new Properties();

    static {
        try (InputStream input = ConfigReader.class
                .getClassLoader()
                .getResourceAsStream("configuration.properties")) {

            properties.load(input);

        } catch (Exception e) {
            throw new RuntimeException("Configuration dosyası okunamadı.", e);
        }
    }

    public static String getProperty(String key) {
        return System.getProperty(key, properties.getProperty(key));
    }
}