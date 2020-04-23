package org.example.util;

import java.util.UUID;

public class IdUtils {

    public static String getID(){
        return UUID.randomUUID().toString().replace("-","");
    }

}
