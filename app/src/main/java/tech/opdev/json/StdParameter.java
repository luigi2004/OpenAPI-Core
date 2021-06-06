package tech.opdev.json;

import jakarta.json.JsonObject;
import lombok.Builder;

@Builder
public class StdParameter implements Parameter {

    private final In in;
    private final String name;
    private final String description;
    private final boolean required;
    private final boolean deprecated;
    private final boolean allowEmptyValue;

    public static Parameter from(JsonObject object) {
        return builder()
            .in(In.valueOf(object.getString("in")))
            .name(object.getString("name"))
            .description(object.getString("description",""))
            .required(object.getBoolean("required"))
            .deprecated(object.getBoolean("deprecated"))
            .allowEmptyValue(object.getBoolean("allowEmptyValue"))
            .build();
    }

    @Override
    public In in() {
        return in;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public String description() {
        return description;
    }

    @Override
    public boolean isRequired() {
        return required;
    }

    @Override
    public boolean isDeprecated() {
        return deprecated;
    }

    @Override
    public boolean allowEmptyValue() {
        return allowEmptyValue;
    }
    
}
