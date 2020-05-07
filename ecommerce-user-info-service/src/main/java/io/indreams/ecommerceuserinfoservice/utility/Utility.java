package io.indreams.ecommerceuserinfoservice.utility;

import java.util.Map;

public class Utility {
    public static String getUserName(Map<String, String> headers) {
        return headers.get("userName");
    }
}
