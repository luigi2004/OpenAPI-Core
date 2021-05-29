package tech.opdev.json;

import java.util.Arrays;

import jakarta.json.JsonObject;
import lombok.Builder;

@Builder
public class Info {
    public static Info from(JsonObject asJsonObject) {
        InfoBuilder builder = Info.builder();
        builder.title(asJsonObject.getString("title"));
        builder.version(asJsonObject.getString("version"));
        
        asJsonObject.entrySet().stream().filter(i-> !Arrays.asList("title", "version").contains(i.getKey())).forEach(prop -> {
            JsonObject iJsonObject = prop.getValue().asJsonObject();
            switch (prop.getKey()) {
                case "summary":
                    builder.summary(iJsonObject.getString("summary"));
                    break;
                case "description":
                    builder.description(iJsonObject.getString("description"));
                    break;
                case "termsOfService":
                    builder.termsOfService(iJsonObject.getString("termsOfService"));
                    break;
                case "contact":
                    builder.contact(new Contact(iJsonObject.getString("name"), iJsonObject.getString("url"), iJsonObject.getString("email")));
                    break;
                case "license":
                    builder.license(new License(iJsonObject.getString("name"), iJsonObject.getString("url",iJsonObject.getString("identifier"))));
                    break;
                default:
                    break;
            }
        });
        return builder.build();
    }

    private String title;
    private String summary;
    private String description;
    private String termsOfService;
    private Contact contact;
    private License license;
    private String version;
}
