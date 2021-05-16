package tech.opdev.json;

import java.util.List;
import java.util.Map;

import lombok.Builder;
import lombok.Singular;

@Builder
public class Document {
    String version;
    Info info;
    @Singular final Map<String, PathItem> paths;
    String jsonSchemaDialect;
    @Singular final List<Server> servers;
    @Singular final Map<String, Object> webhooks;
    @Singular final Map<String, Object> components;
    @Singular final List<Object> secruities;
    @Singular final List<Object> tags;
    ExternalDocument externalDocs;
}
