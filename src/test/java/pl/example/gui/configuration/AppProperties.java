package pl.example.gui.configuration;

public class AppProperties {
    // kliknięcie z ctrl w propertyKey przniesie do danej property z kluczem
    public static String getUrl() {
        return properties.ConfigurationProperties.getProperty("gui", "app.url");
    }


}
