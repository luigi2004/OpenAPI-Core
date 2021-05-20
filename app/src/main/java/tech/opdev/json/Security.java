package tech.opdev.json;

import java.util.Map;

import jakarta.json.JsonObject;
import lombok.Singular;
import lombok.Value;

@Value
public class Security {
    private String type;
    private String description;
    private String name;
    private String in;
    private String scheme;
    private String bearerFormat;
    private String openIdConnectUrl;
    private Flows flows;

    public static Security from(JsonObject aJsonObject) {
        return new Security(
            aJsonObject.getString("type"), 
            aJsonObject.getString("description", ""),
            aJsonObject.getString("name"), 
            aJsonObject.getString("in"), 
            aJsonObject.getString("scheme"), 
            aJsonObject.getString("bearerFormat", ""),
            aJsonObject.getString("openIdConnectUrl"), 
            Flows.from(aJsonObject.getJsonObject("flows"))
        );
    }

    @Value
    private static class Flows {
        private Flow implicit;
        private Flow password;
        private Flow clientCredentials;
        private Flow authorizationCode;
        static Flows from(JsonObject aJsonObject) {
            return new Flows(
                Flow.from(aJsonObject.getJsonObject("implicit")), 
                Flow.from(aJsonObject.getJsonObject("password")), 
                Flow.from(aJsonObject.getJsonObject("clientCredentials")),
                Flow.from(aJsonObject.getJsonObject("authorizationCode"))
            );
        }

        @Value
        private static class Flow {
            private String authorizationUrl;
            private String tokenUrl;
            private String refreshUrl;
            @Singular
            private Map<String, String> scopes;

            static Flow from(JsonObject aJsonObject) {
                return null;
            }
        }
    }
}
