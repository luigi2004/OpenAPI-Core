package tech.opdev.json;

import java.util.Map;

import lombok.Builder;
import lombok.Singular;

/**
 * MediaContent
 */
@Builder
public class MediaContent {
    private Object schema;
    @Singular
    private Map<String, Object> examples;
    @Singular
    private Map<String, Object> encodings;
}