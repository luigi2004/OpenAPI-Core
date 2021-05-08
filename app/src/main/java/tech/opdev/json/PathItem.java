package tech.opdev.json;

import java.util.List;

import jakarta.json.JsonObject;

public interface PathItem {
    static PathItem getFrom(JsonObject asJsonObject) {
        if(asJsonObject.containsKey("$ref")) {
            return new RefPathItem(asJsonObject.getString("$ref"));
        }
        return new StdPathItem(asJsonObject);
    }
    
    String summary();
    String description();
    Object get();
    Object put();
    Object post();
    Object delete();
    Object options();
    Object head();
    Object patch();
    Object trace();

    List<Object> servers();
    List<Object> parameters();
}
