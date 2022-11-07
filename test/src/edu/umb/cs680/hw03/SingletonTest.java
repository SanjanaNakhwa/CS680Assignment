package edu.umb.cs680.hw03;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.function.Try;
import static org.junit.jupiter.api.Assertions.*;

public class SingletonTest{

    @Test
    public void singletonNotNull() {
        Singleton instance = Singleton.getInstance();
        Assertions.assertNotNull(instance);
    }

    @Test
    public void singletonIdentical(){
        Singleton instance1 = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();
        Assertions.assertEquals(instance1.hashCode(), instance2.hashCode());

    }
}




