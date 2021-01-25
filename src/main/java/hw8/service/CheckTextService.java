package hw8.service;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.SneakyThrows;
import org.hamcrest.Matchers;

import java.util.Map;
import java.util.Properties;

import static org.apache.http.HttpStatus.SC_MULTIPLE_CHOICES;
import static org.apache.http.HttpStatus.SC_OK;

public class CheckTextService {
    private RequestSpecification specification;

    public CheckTextService() {
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        specification = new RequestSpecBuilder()
                .setBaseUri(getProperties().getProperty("service.uri"))
                .addFilter(new RequestLoggingFilter())
                .addFilter(new ResponseLoggingFilter())
                .build();
    }

    @SneakyThrows
    public Properties getProperties() {
        Properties properties = new Properties();
        String fileName = "hw8/test.properties";
        properties.load(getClass().getClassLoader().getResourceAsStream(fileName));
        return properties;
    }

    public Response getNoParams() {
        Response response = RestAssured.given(specification).get(getProperties().getProperty("service.uri"));
        response.then()
                .statusCode(Matchers.lessThan(SC_MULTIPLE_CHOICES))
                .statusCode(Matchers.greaterThanOrEqualTo(SC_OK));
        return response;
    }

    public Response getWithParams(Map<String, Object> params) {
        RequestSpecification specification = RestAssured.given(this.specification);
        for (Map.Entry<String, Object> param : params.entrySet())
            specification.param(param.getKey(), param.getValue());
        return specification.get(getProperties().getProperty("service.uri"));
    }
}
