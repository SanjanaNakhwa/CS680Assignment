package edu.umb.cs680.hw05;

import java.util.HashMap;
import java.util.Map;

public class Authenticator {
    protected static HashMap<String,String> userPasswordMap = new HashMap<>();

     static{
        userPasswordMap.put("ABC", "123");
        userPasswordMap.put("DEF", "456");
        userPasswordMap.put("PQR", "789");

    }

    public static boolean authenticate(SecurityContext ctx, String password){
        if(userPasswordMap.containsKey(ctx.user) && userPasswordMap.get(ctx.user).equals(password)){
            return true;
        }

        return false;
    }
}
