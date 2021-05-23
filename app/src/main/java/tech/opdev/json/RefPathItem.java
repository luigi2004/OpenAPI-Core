package tech.opdev.json;

import java.util.List;

public class RefPathItem implements PathItem, Reference{

    String reference;
    PathItem resolved;

    RefPathItem(String ref) {
        reference = ref;
    }

    @Override
    public String ref() {
        return reference;
    }

    @Override
    public String summary() {
        return resolved.summary();
    }

    @Override
    public String description() {
        return resolved.description();
    }

    @Override
    public Operation get() {
        return resolved.get();
    }

    @Override
    public Operation put() {
        return resolved.put();
    }

    @Override
    public Operation post() {
        return resolved.post();
    }

    @Override
    public Operation delete() {
        return resolved.delete();
    }

    @Override
    public Operation options() {
        return resolved.options();
    }

    @Override
    public Operation head() {
        return resolved.head();
    }

    @Override
    public Operation patch() {
        return resolved.patch();
    }

    @Override
    public Operation trace() {
        return resolved.trace();
    }

    @Override
    public List<Server> servers() {
        return resolved.servers();
    }

    @Override
    public List<Object> parameters() {
        return resolved.parameters();
    }
    
    public void resolve(PathItem item) {
        resolved = item;
    }
}
