package tech.opdev.json;

import java.util.List;

import jakarta.json.JsonObject;

public interface PathItem {
    static PathItem from(JsonObject asJsonObject) {
        if(asJsonObject.containsKey("$ref")) {
            return new RefPathItem(asJsonObject.getString("$ref"));
        }
        return new StdPathItem(asJsonObject);
    }
    
    String summary();
    String description();
    Operation get();
    Operation put();
    Operation post();
    Operation delete();
    Operation options();
    Operation head();
    Operation patch();
    Operation trace();

    List<Server> servers();
    List<Object> parameters();
}
