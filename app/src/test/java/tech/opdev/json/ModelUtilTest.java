package tech.opdev.json;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import tech.opdev.json.util.ModelUtil;

public class ModelUtilTest {
    @Test
    public void hasDefaultConstructor() {
        
    }
    
    public static class TestWithDefault {
        private int a;
        public TestWithDefault() {
            a = 0;
        }
    }
}
