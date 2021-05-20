package tech.opdev.json;

import java.util.Map;

import lombok.Builder;
import lombok.Singular;

@Builder
public class StdResponse implements Response{
    private final String description;
    @Singular 
    private Map<String, Object> contents;
    @Singular 
    private Map<String, Object> links;
    @Singular 
    private Map<String, Object> headers;

    @Override
    public String description() {
        return description;
    }

    @Override
    public Map<String, Object> headers() {
        return headers;
    }

    @Override
    public Map<String, Object> content() {
        return contents;
    }

    @Override
    public Map<String, Object> links() {
        return links;
    }
    
}
