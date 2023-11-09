package API.apiHelper.aidar;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


public class SDConverter {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static <T> T deserialize(String json, Class<T> classes ) throws JsonProcessingException {
        return objectMapper.readValue(json, classes);
    }
    public static <T> String serialize(T tClass) throws JsonProcessingException {
        return objectMapper.writeValueAsString(tClass);
    }
}
