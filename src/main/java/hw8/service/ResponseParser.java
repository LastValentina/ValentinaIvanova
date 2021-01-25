package hw8.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import hw8.dto.CheckTextDto;
import io.restassured.response.Response;
import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.List;

public class ResponseParser {
    @SneakyThrows
    public List<CheckTextDto> getDataFromResponse(Response response) {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(response.getBody().asString(), new TypeReference<List<CheckTextDto>>() {
        });
    }

    public int getWordQtyFromResponse(Response response) {
        List<CheckTextDto> jsonList = getDataFromResponse(response);
        return jsonList.size();
    }

    public List<String> getProvidedWords(Response response) {
        List<CheckTextDto> jsonList = getDataFromResponse(response);
        List<String> s = new ArrayList<>();
        for (CheckTextDto dto : jsonList) {
            s.addAll(dto.getS());
        }
        return s;
    }

}
