package tech.opdev.json;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import jakarta.json.JsonObject;
import jakarta.json.JsonValue;
import lombok.Value;

@Value
public class Server {
    String url;
    String description;
    Map<String, Variable> variables;

    public static Server from(JsonObject asJsonObject) {
        JsonObject vJsonObject = asJsonObject.getJsonObject("variables");
        return new Server(
            asJsonObject.getString("url"), 
            asJsonObject.getString("description", ""), 
            vJsonObject.asJsonObject().entrySet().stream().map(v -> new Object(){
                public Variable var = new Variable(
                v.getValue().asJsonObject().getString("description", ""), 
                v.getValue().asJsonObject().getString("default"), 
                v.getValue().asJsonObject().getJsonArray("enums").stream().map(JsonValue::toString).collect(Collectors.toList()));
                public String k = v.getKey();
            }
            ).collect(Collectors.toMap(variable->variable.k, variable -> variable.var))
        );
    }

    @Value
    static class Variable {
        String description;
        String defaultValue;
        List<String> enums;        
    }
}
