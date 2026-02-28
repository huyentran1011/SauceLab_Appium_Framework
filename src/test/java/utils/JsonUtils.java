package utils;

import POJO.LoginData;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

public class JsonUtils {
    private static final ObjectMapper mapper = new ObjectMapper();

    public static <T> List<T> readJsonByKey(String fileName, String key, Class<T[]> clazz) {
        try {
            ObjectMapper mapper = new ObjectMapper();

            InputStream is = JsonUtils.class
                    .getClassLoader()
                    .getResourceAsStream("testData/" + fileName);

            JsonNode root = mapper.readTree(is);
            JsonNode node = root.get(key);

            return Arrays.asList(mapper.treeToValue(node, clazz));

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // ✅ For SINGLE object JSON
    public static <T> T readObject(String fileName, Class<T> clazz) {
        try {
            InputStream is = JsonUtils.class
                    .getClassLoader()
                    .getResourceAsStream("testData/" + fileName);

            return mapper.readValue(is, clazz);

        } catch (Exception e) {
            throw new RuntimeException("Failed to read JSON object", e);
        }
    }

    // ✅ For ARRAY JSON
    public static <T> List<T> readList(String fileName, Class<T[]> clazz) {
        try {
            InputStream is = JsonUtils.class
                    .getClassLoader()
                    .getResourceAsStream("testData/" + fileName);

            return Arrays.asList(mapper.readValue(is, clazz));

        } catch (Exception e) {
            throw new RuntimeException("Failed to read JSON list", e);
        }
    }
}
