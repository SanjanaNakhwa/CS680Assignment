package edu.umb.cs680.hw05;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StateDesignPatternTest {

    @Test
    public void testLoginFunctionality(){
        SecurityContext ctx= new SecurityContext("ABC");
        assertTrue(ctx.getState() instanceof LoggedOut);
        ctx.login("123");
        assertTrue(ctx.getState() instanceof LoggedIn);
        ctx.logout();
        assertTrue(ctx.getState() instanceof LoggedOut);
    }

}
