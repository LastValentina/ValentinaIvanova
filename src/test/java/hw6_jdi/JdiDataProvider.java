package hw6_jdi;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import hw6_jdi.entities.MetalsColorsJ;
import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Map;

public class JdiDataProvider {

    @DataProvider
    public Object[][] provideDataSetForMetalColortest() {
        String fileName = "hw6_jdi/JDI_ex8_metalsColorsDataSet.json";
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(fileName);
        InputStreamReader streamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
        BufferedReader reader = new BufferedReader(streamReader);

        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, MetalsColorsJ> jsonMap = null;
        try {
            jsonMap = objectMapper.readValue(reader,
                    new TypeReference<Map<String, MetalsColorsJ>>() {
                    });
        } catch (IOException e) {
            e.printStackTrace();
        }

        Object[][] dataSet = new Object[jsonMap.size()][1];
        for (int i = 1; i <= jsonMap.size(); i++) {
            String key = "data_" + i;
            dataSet[i - 1][0] = jsonMap.get(key);
        }
        return dataSet;
    }
}