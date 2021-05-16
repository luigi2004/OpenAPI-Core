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
    public Object get() {
        return resolved.get();
    }

    @Override
    public Object put() {
        return resolved.put();
    }

    @Override
    public Object post() {
        return resolved.post();
    }

    @Override
    public Object delete() {
        return resolved.delete();
    }

    @Override
    public Object options() {
        return resolved.options();
    }

    @Override
    public Object head() {
        return resolved.head();
    }

    @Override
    public Object patch() {
        return resolved.patch();
    }

    @Override
    public Object trace() {
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
