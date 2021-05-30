package tech.opdev.json;

public class RefCallback implements Callback, Reference{
    
    private Callback actual;
    private String reference;

    public RefCallback(String ref) {
        this.reference = ref;
    }

    @Override
    public String ref() {
        return null;
    }

    @Override
    public String expression() {
        return actual.expression();
    }

    @Override
    public PathItem pathItem() {
        return actual.pathItem();
    }
    
}
