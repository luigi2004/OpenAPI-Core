package tech.opdev.json;

import java.util.Optional;

import jakarta.json.JsonObject;
import lombok.Data;
import lombok.NonNull;

@Data
public class ExternalDocument {
    Optional<String> description;
    @NonNull
    String url;

    public static ExternalDocument from(JsonObject asJsonObject) {
        ExternalDocument doc = new ExternalDocument(asJsonObject.getString("url"));
        if(asJsonObject.containsKey("description")) {
            doc.setDescription(Optional.of(asJsonObject.getString("description")));
        }
        return doc;
    }
}
