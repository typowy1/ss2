package properties;

import java.util.ResourceBundle;

public class ConfigurationProperties {
    public static String getProperty(String propertyName, String propertyKey) {
        return ResourceBundle.getBundle(propertyName).getString(propertyKey);
    }
}
