package tech.opdev.json;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jakarta.json.JsonObject;
import lombok.Data;

@Data
public class Operation {
    String description;
    String name;
    String summary;
    boolean deprecated;
    ExternalDocument externalDocs;
    Object requestBody;
    List<String> tags;
    List<Object> parameters;
    List<Object> security;
    List<Object> servers;
    Map<String, Response> responses;
    Map<String, Object> callbacks;

    public Operation(JsonObject asJsonObject) {
        callbacks = new HashMap<>();
        security = new ArrayList<>();
        servers = new ArrayList<>();
        parameters = new ArrayList<>();
        asJsonObject.entrySet().stream().forEach(i -> {
            switch (i.getKey()) {
                case "summary":
                    summary = asJsonObject.getString("summary");
                    break;
                case "description":
                    description = asJsonObject.getString("description");
                    break;
                case "operationId":
                    name = asJsonObject.getString("operationId");
                    break;
                case "callbacks":
                    i.getValue().asJsonObject().entrySet().stream().forEach(c -> {
                        callbacks.put(c.getKey(), null);
                    });
                    break;
                case "security":
                    i.getValue().asJsonArray().forEach(s -> {
                        security.add(null);
                    });
                    break;
                case "servers":
                    i.getValue().asJsonArray().forEach(s -> {
                        servers.add(null);
                    });
                    break;
                case "parameters":
                    i.getValue().asJsonArray().forEach(s -> {
                        parameters.add(null);
                    });
                    break;
                case "responses":
                    i.getValue().asJsonObject().forEach((k,v)-> responses.put(k, Response.from(v.asJsonObject())));
                    break;
                case "externalDocs":
                    JsonObject ed = i.getValue().asJsonObject();
                    externalDocs = new ExternalDocument(ed.getString("url"), ed.getString("description", ""));
                    break;
                default:
                    break;
            }
        });
    }
}
