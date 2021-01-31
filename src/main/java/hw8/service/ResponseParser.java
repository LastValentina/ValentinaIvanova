package hw8.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import hw8.dto.CheckTextDto;
import hw8.dto.ListOfCheckTextDto;
import io.restassured.response.Response;
import lombok.SneakyThrows;

import java.util.List;

public class ResponseParser {

    @SneakyThrows
    public List<CheckTextDto> getDataFromResponse(Response response) {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(response.getBody().asString(), new TypeReference<List<CheckTextDto>>() {
        });
    }

    @SneakyThrows
    public List<ListOfCheckTextDto> getDataListFromResponse(Response response) {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(response.getBody().asString(), new TypeReference<List<ListOfCheckTextDto>>() {
        });
    }

}