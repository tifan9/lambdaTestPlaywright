package services;

import java.io.IOException;
import java.util.Properties;

public class EnvironmentReaderService {
    private static Properties props = new Properties();
    static {
        String envFile = System.getProperty("env");
        if(envFile == null){
            envFile = "production";
        }
        // construct a relative path for the resources
        String filePath= envFile.concat(".properties");
        // read the file as a string
        try {
            props.load(EnvironmentReaderService.class.getClassLoader().getResourceAsStream(filePath));
        } catch (IOException e) {
            System.out.println("Error loading properties file");
            throw new RuntimeException(e);
        }

    }
    // Generate a Getter
    public static String getProperty(String key) {
        return props.getProperty(key);
    }
}
