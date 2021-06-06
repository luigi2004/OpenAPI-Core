package tech.opdev.json;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonObjectBuilder;
import jakarta.json.bind.adapter.JsonbAdapter;

import lombok.Builder;
import lombok.Singular;
import lombok.Value;
import tech.opdev.json.util.ModelUtil;

@Builder
@Value
public class Document {
    String version;
    Info info;
    @Singular final Map<String, PathItem> paths;
    String jsonSchemaDialect;
    @Singular final List<Server> servers;
    @Singular final Map<String, PathItem> webhooks;
    @Singular final Map<String, Object> components;
    @Singular final List<Object> secruities;
    @Singular final List<Object> tags;
    ExternalDocument externalDocs;

    public static Document from(JsonObject obj) {
        return Document.builder()
            .version(obj.getString("openapi"))
            .jsonSchemaDialect(obj.getString("jsonSchemaDialect", ""))
            .info(Info.from(obj.getJsonObject("info")))
            .servers(ModelUtil.list(obj.getJsonArray("server"), Server.class))
            .paths(ModelUtil.map(obj.getJsonObject("paths"), PathItem.class))
            .tags(ModelUtil.list(obj.getJsonArray("tags"), Tag.class))
            .secruities(ModelUtil.list(obj.getJsonArray("security"), Security.class))
            .webhooks(ModelUtil.map(obj.getJsonObject("webhooks"), PathItem.class))
        .build();
    }

    public JsonObject toJsonObject() {
        return Json.createObjectBuilder()
            .add("version", version)
            .add("name", jsonSchemaDialect)
        .build();
    }

}
