package tech.opdev.json;

import java.util.Map;

import jakarta.json.JsonObject;

public interface Response {
    String description();
    Map<String, Object> headers();
    Map<String, Object> content();
    Map<String, Object> links();
    static Response from(JsonObject aJsonObject){
        return null;
    }
}
