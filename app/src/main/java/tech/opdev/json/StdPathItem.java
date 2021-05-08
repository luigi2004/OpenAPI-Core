package tech.opdev.json;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jakarta.json.JsonObject;
import lombok.Data;
import lombok.extern.log4j.Log4j2;

@Data
@Log4j2
public class StdPathItem implements PathItem{

    String summary;
    String description;
    Map<String, Object> operations;
    List<Object> servers;
    List<Object> parameters;

    StdPathItem(JsonObject asJsonObject) {
        operations = new HashMap<>();
        servers = new ArrayList<>();
        parameters = new ArrayList<>();
        asJsonObject.entrySet().stream().filter(obj->!obj.getKey().startsWith("x-")).forEach(i->{
            String key = i.getKey();
            switch (key) {
                case "summary":
                    summary = asJsonObject.getString(key);
                    break;
                case "description":
                    description = asJsonObject.getString(key);
                    break;
                case "service":
                    break;
                case "parameters":
                    break;
                default:
                log.info("Key: {}", key);
                    operations.put(i.getKey(), new Operation(i.getValue().asJsonObject()));
                    break;
            }
        });
    }

    @Override
    public String summary() {
        return summary;
    }

    @Override
    public String description() {
        return description;
    }

    @Override
    public Object get() {
        return operations.get("get");
    }

    @Override
    public Object put() {
        return operations.get("put");
    }

    @Override
    public Object post() {
        return operations.get("post");
    }

    @Override
    public Object delete() {
        return operations.get("delete");
    }

    @Override
    public Object options() {
        return operations.get("options");
    }

    @Override
    public Object head() {
        return operations.get("head");
    }

    @Override
    public Object patch() {
        return operations.get("patch");
    }

    @Override
    public Object trace() {
        return operations.get("trace");
    }

    @Override
    public List<Object> servers() {
        return servers;
    }

    @Override
    public List<Object> parameters() {
        return parameters;
    }
    
}
