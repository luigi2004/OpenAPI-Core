package tech.opdev.json.deserialization;

import jakarta.json.JsonObject;
import jakarta.json.bind.adapter.JsonbAdapter;
import tech.opdev.json.Document;

public class DocumentAdapter implements  JsonbAdapter<Document, JsonObject>{

    @Override
    public JsonObject adaptToJson(Document obj) throws Exception {
        return obj.toJsonObject();
    }

    @Override
    public Document adaptFromJson(JsonObject obj) throws Exception {
        return Document.from(obj);
    }

    
}
