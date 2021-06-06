package tech.opdev.json;

import jakarta.json.JsonObject;

/**
 * Callback
 */
public interface Callback {
    String expression();
    PathItem pathItem();

    public static Callback from(JsonObject json) {
        if(json.containsKey("$ref")) {
            return new RefCallback(json.getString("$ref"));
        } else {
            return new StdCallback(json.getString("expression"), PathItem.getFrom(json.getJsonObject("name")));
        }
    }
}