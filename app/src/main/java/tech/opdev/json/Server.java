package tech.opdev.json;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import jakarta.json.JsonObject;
import lombok.NonNull;
import lombok.Value;

@Value
public class Server {
    String url;
    String description;
    Map<String, Variable> variables;

    public static Server from(JsonObject asJsonObject) {

        return new Server(
            asJsonObject.getString("url"), 
            asJsonObject.getString("description", ""), 
            "variables");
    }

    public static class Variable {
        List<String> enums;
        final long defaultIndex;
        Variable(String sub) {
            enums = new ArrayList<>();
            enums.add(sub);
            defaultIndex = 0;
        }

        Variable(String defaultSub, String... otherSubs) {
            this(defaultSub);
            for(String sub : otherSubs) {
                enums.add(sub);
            }
        }
        
    }
}
