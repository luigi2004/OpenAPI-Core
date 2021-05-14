package tech.opdev.json;

import java.util.Map;
import java.util.Optional;

import jakarta.json.JsonObject;
import lombok.Builder;

@Builder
public class Info {
    public static Info from(JsonObject asJsonObject) {
        InfoBuilder builder = Info.builder();
        builder.title(asJsonObject.getString("title"));
        builder.version(asJsonObject.getString("version"));
        asJsonObject.entrySet().stream().forEach(prop -> {
            switch (prop.getKey()) {
                case "summary":
                    builder.summary(Optional.of(prop.getValue().asJsonObject().getString("summary")));
                    break;
                case "description":
                    builder.description(Optional.of(prop.getValue().asJsonObject().getString("description")));
                    break;
                case "termsOfService":
                    builder.termsOfService(Optional.of(prop.getValue().asJsonObject().getString("termsOfService")));
                    break;
                case "contact":
                    builder.contact(Optional.empty());
                    break;
                case "license":
                    builder.license(Optional.empty());
                    break;
                default:
                    break;
            }
        });
        return builder.build();
    }

    private String title;
    private Optional<String> summary;
    private Optional<String> description;
    private Optional<String> termsOfService;
    private Optional<Map<String, Object>> contact;
    private Optional<Map<String, Object>> license;
    private String version;
}
