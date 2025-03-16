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
            // Считываем данные из values.json
            JsonNode values = objectMapper.readTree(new File(valuesFilePath));

            // Считываем данные из tests.json
            JsonNode tests = objectMapper.readTree(new File(testsFilePath));

            // Заполняем структуру tests значениями из values
            fillValues(tests.get("tests"), values);

            // Записываем результат в report.json
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(reportFilePath), tests);

            System.out.println("Файл report.json успешно создан.");
        } catch (IOException e) {
            System.out.println("Ошибка при работе с файлами: " + e.getMessage());
        }
    }

    private static void fillValues(JsonNode tests, JsonNode values) {
        if (tests.isArray()) {
            // Если текущий узел — массив, обрабатываем каждый элемент
            for (JsonNode test : tests) {
                fillValues(test, values);
            }
        } else if (tests.isObject()) {
            // Если текущий узел — объект, проверяем наличие id и заполняем value
            if (tests.has("id")) {
                int id = tests.get("id").asInt();
                if (values.has(Integer.toString(id))) {
                    ((ObjectNode) tests).put("value", values.get(Integer.toString(id)).asText());
                }
            }

            // Рекурсивно обрабатываем дочерние элементы
            if (tests.has("values")) {
                fillValues(tests.get("values"), values);
            }
        }
    }
}
