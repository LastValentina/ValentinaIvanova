package hw8.service;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;

import java.util.Map;

import static hw8.dto.Const.*;
import static org.apache.http.HttpStatus.SC_MULTIPLE_CHOICES;
import static org.apache.http.HttpStatus.SC_OK;

public class CommonService {
    static String basedUri = new ServiceUrl().getBaseUrl();
    private RequestSpecification specification;

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
        //      RequestSpecification specification = RestAssured.given(specification);
        //       RestAssured.given(specification);
//        for (Map.Entry<String, Object> param : params.entrySet())
//        {  specification.param(param.getKey(), param.getValue());}
        //       return specification.get(uri);
        specification.queryParams(params);
        return RestAssured.given(specification).get(uri);
    }

    //   public Response getWithParams(String uri, Map<String, Object> mainParams, Map<String, Object> params) {
    //             RequestSpecification specification = RestAssured.given(specification);
    //              RestAssured.given(specification);
    //       for (Map.Entry<String, Object> param : params.entrySet())
    //       {  specification.param(param.getKey(), param.getValue());}
    //              return specification.get(uri);
    //       specification.queryParams(mainParams);
    //       specification.requestParams();
    //       return RestAssured.given(specification).get(uri);
    //   }


    public Response getURL(String method, String uri, Map<String, String> params) {
        Response response = null;
        specification.queryParams(params);
        switch (method) {
            case HTTP_GET:
                response = RestAssured.given(specification).get(uri);
                break;
            case HTTP_POST:
                response = RestAssured.given(specification).post(uri);
                break;
            case HTTP_PUT:
                response = RestAssured.given(specification).put(uri);
                break;
            case HTTP_DELETE:
                response = RestAssured.given(specification).delete(uri);
                break;
            case HTTP_PATCH:
                response = RestAssured.given(specification).patch(uri);
                break;
        }
        return response;
    }

}
