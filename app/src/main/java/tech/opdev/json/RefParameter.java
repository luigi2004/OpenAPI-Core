package tech.opdev.json;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RefParameter implements Reference, Parameter {
    private Parameter actual;
    private final String reference;

    @Override
    public String in() {
        // TODO Auto-generated method stub
        return actual.in();
    }

    @Override
    public String name() {
        // TODO Auto-generated method stub
        return actual.name();
    }

    @Override
    public String description() {
        // TODO Auto-generated method stub
        return actual.description();
    }

    @Override
    public boolean isRequired() {
        // TODO Auto-generated method stub
        return actual.isRequired();
    }

    @Override
    public boolean isDeprecated() {
        // TODO Auto-generated method stub
        return actual.isDeprecated();
    }

    @Override
    public boolean allowEmptyValue() {
        // TODO Auto-generated method stub
        return actual.allowEmptyValue();
    }

    @Override
    public String ref() {
        // TODO Auto-generated method stub
        return reference;
    }
    
}
