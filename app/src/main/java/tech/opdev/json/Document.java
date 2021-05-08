package tech.opdev.json;

import java.util.Map;
import java.util.Optional;

import lombok.Data;

@Data
public class Document {
    String version;
    Info info;
    Optional<Map<String, PathItem>> paths;
    Optional<String> jsonSchemaDialect;
    Optional<Map<String, Object>> servers;
    Optional<Map<String, Object>> webhooks;
    Optional<Map<String, Object>> components;
    Optional<Map<String, Object>> secruity;
    Optional<Map<String, Object>> tags;
    Optional<Map<String, ExternalDocument>> externalDocs;
}
