package hw8.service;

import lombok.SneakyThrows;

import java.util.Properties;

public class ServiceUrl {
    private String uri;
    private String baseUrl;
    private String epText;
    private String epTexts;

    @SneakyThrows
    public ServiceUrl() {
        String fileName = "hw8/test.properties";
        Properties properties = new Properties();
        properties.load(getClass().getClassLoader().getResourceAsStream(fileName));
        this.uri = properties.getProperty("service.uri");
        baseUrl = properties.getProperty("base.url");
        epText = properties.getProperty("ep.text");
        epTexts = properties.getProperty("ep.texts");
    }

    public String getServiceUrl() {
        return this.uri;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public String getEpText() {
        return epText;
    }

    public String getEpTexts() {
        return epTexts;
    }

}
