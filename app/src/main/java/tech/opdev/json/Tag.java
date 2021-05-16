package tech.opdev.json;

import lombok.Value;

@Value
public class Tag {
    private String name;
    private String description;
    private ExternalDocument externalDocs;
}
