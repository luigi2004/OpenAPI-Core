package tech.opdev.json;

import java.util.Map;
import java.util.Optional;

import jakarta.json.JsonObject;
import lombok.Data;

@Data
public class Info {
    public Info(JsonObject asJsonObject) {
        title = asJsonObject.getString("title");
        version = asJsonObject.getString("version");
        asJsonObject.entrySet().stream().forEach(prop -> {
            switch (prop.getKey()) {
                case "summary":
                    summary = Optional.of(prop.getValue().asJsonObject().getString("summary"));
                    break;
                case "description":
                    description = Optional.of(prop.getValue().asJsonObject().getString("description"));
                    break;
                case "termsOfService":
                    termsOfService = Optional.of(prop.getValue().asJsonObject().getString("termsOfService"));
                    break;
                case "contact":
                    contact = Optional.empty();
                    break;
                case "license":
                    license = Optional.empty();
                    break;
                default:
                    break;
            }
        });
    }

    private String title;
    private Optional<String> summary;
    private Optional<String> description;
    private Optional<String> termsOfService;
    private Optional<Map<String, Object>> contact;
    private Optional<Map<String, Object>> license;
    private String version;
}
