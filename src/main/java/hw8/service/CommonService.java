package hw8.service;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;

import java.util.Map;

import static org.apache.http.HttpStatus.SC_MULTIPLE_CHOICES;
import static org.apache.http.HttpStatus.SC_OK;

public class CommonService {
    static String basedUri = new ServiceUrl().getBaseUrl();
    protected RequestSpecification specification;

    public CommonService() {
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        specification = new RequestSpecBuilder()
                .setBaseUri(basedUri)
                .addFilter(new RequestLoggingFilter())
                .addFilter(new ResponseLoggingFilter())
                .build();
    }

    public Response getNoParams(String uri) {
        RestAssured.given(specification).get(uri)
                .then()
                .statusCode(Matchers.lessThan(SC_MULTIPLE_CHOICES))
                .statusCode(Matchers.greaterThanOrEqualTo(SC_OK));
        return RestAssured.given(specification).get(uri);
    }

    public Response getWithParams(String uri, Map<String, Object> params) {
        specification.queryParams(params);
        return RestAssured.given(specification).get(uri);
    }

}
