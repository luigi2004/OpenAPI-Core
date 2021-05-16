package tech.opdev.json;

import javax.annotation.Nullable;

import lombok.NonNull;
import lombok.Value;

@Value 
public class ExternalDocument {
    @Nullable
    String description;
    @NonNull
    String url;
}
