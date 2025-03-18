package task3;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.File;
import java.io.IOException;

public class task3 {
    public static void main(String[] args) {
        String valuesFilePath = "src/task3/values.json";
        String testsFilePath = "src/task3/tests.json";
        String reportFilePath = "src/task3/report.json";
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            JsonNode values = objectMapper.readTree(new File(valuesFilePath));
            JsonNode tests = objectMapper.readTree(new File(testsFilePath));
            fillValues(tests.get("tests"), values);
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(reportFilePath), tests);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void fillValues(JsonNode tests, JsonNode values) {
        if (tests.isArray()) {
            for (JsonNode test : tests) {
                fillValues(test, values);
            }
        } else if (tests.isObject()) {
            if (tests.has("id")) {
                int id = tests.get("id").asInt();
                if (values.has(Integer.toString(id))) {
                    ((ObjectNode) tests).put("value", values.get(Integer.toString(id)).asText());
                }
            }
            if (tests.has("values")) {
                fillValues(tests.get("values"), values);
            }
        }
    }
}
