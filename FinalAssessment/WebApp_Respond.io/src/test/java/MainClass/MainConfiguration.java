package MainClass;

import java.io.*;
import java.util.*;

public class MainConfiguration {

    Properties prop;
    FileInputStream fs;
    String baseUrl;
    String email;
    String password;


    public MainConfiguration() {
        try {
            prop = new Properties();
            fs = new FileInputStream("ConfigProperties/configuration.properties");
            prop.load(fs);
        } catch (Exception ex) {
            ex.getMessage();
        }
    }

    public String getUrlValue() {
        baseUrl = prop.getProperty("baseUrl");
        return baseUrl;
    }

    public String getEmail() {
        email = prop.getProperty("email");
        return email;
    }

    public String getPassword() {
        password = prop.getProperty("password");
        return password;
    }


}
