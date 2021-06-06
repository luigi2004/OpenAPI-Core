package tech.opdev.json;

import jakarta.json.JsonObject;

public interface Parameter {
    In in();
    String name();
    String description();
    boolean isRequired();
    boolean isDeprecated();
    boolean allowEmptyValue();

    public static Parameter from(JsonObject json) {
        if(json.containsKey("$ref")) {
            return new RefParameter(json.getString("$ref"));
        } else {
            return null;
        }
    }

    enum In{
        PATH,
        QUERY,
        HEADER,
        COOKIE
    }
}
