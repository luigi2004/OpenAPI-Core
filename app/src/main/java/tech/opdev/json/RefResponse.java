package tech.opdev.json;

import java.util.Map;

public class RefResponse implements Reference, Response{

    private Response resolved;
    private final String reference;

    public RefResponse(String ref) {
        reference = ref;
        resolved = null;
    }

    @Override
    public String description() {
        return resolved.description();
    }

    @Override
    public Map<String, Object> headers() {
        return resolved.headers();
    }

    @Override
    public Map<String, Object> content() {
        return resolved.content();
    }

    @Override
    public Map<String, Object> links() {
        return resolved.links();
    }

    @Override
    public String ref() {
        return reference;
    }
    
}
