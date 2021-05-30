package tech.opdev.json;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jakarta.json.JsonObject;
import jakarta.json.JsonString;

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
    List<Server> servers;
    Map<String, Response> responses;
    Map<String, Callback> callbacks;

    public Operation(JsonObject asJsonObject) {
        callbacks = new HashMap<>();
        responses = new HashMap<>();
        security = new ArrayList<>();
        servers = new ArrayList<>();
        parameters = new ArrayList<>();
        asJsonObject.forEach((key, value) -> {
            switch (key) {
                case "summary":
                    summary = ((JsonString)value).getString();
                    break;
                case "description":
                    description = ((JsonString)value).getString();
                    break;
                case "operationId":
                    name = ((JsonString)value).getString();
                    break;
                case "callbacks":
                    value.asJsonObject().entrySet().stream().forEach(c -> {
                        PathItem pathItem = PathItem.getFrom(c.getValue().asJsonObject().getJsonObject("name"));
                        String expression = c.getValue().asJsonObject().getString("name");
                        callbacks.put(c.getKey(), new Callback(expression, pathItem));
                    });
                    break;
                case "security":
                    value.asJsonArray().forEach(s -> {
                        security.add(null);
                    });
                    break;
                case "servers":
                    value.asJsonArray().forEach(s -> {
                        servers.add(Server.from(s.asJsonObject()));
                    });
                    break;
                case "parameters":
                    value.asJsonArray().forEach(s -> {
                        parameters.add(null);
                    });
                    break;
                case "responses":
                    value.asJsonObject().forEach((k,v)-> responses.put(k, Response.from(v.asJsonObject())));
                    break;
                case "externalDocs":
                    externalDocs = new ExternalDocument(value.asJsonObject().getString("url"), value.asJsonObject().getString("description", ""));
                    break;
                default:
                    break;
            }
        });
    }
}
