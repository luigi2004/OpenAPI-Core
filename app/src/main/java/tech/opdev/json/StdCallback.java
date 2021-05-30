package tech.opdev.json;

import lombok.Value;

@Value
public class StdCallback implements Callback{
    private final String expression;
    private final PathItem pathItem;


    @Override
    public String expression() {
        return expression;
    }

    @Override
    public PathItem pathItem() {
        return pathItem;
    }
    
}
