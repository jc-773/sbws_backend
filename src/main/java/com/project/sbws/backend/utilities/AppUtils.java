package com.project.sbws.backend.utilities;

import org.springframework.stereotype.Service;

@Service
public class AppUtils {
    

    public AppUtils() {

    }

    public static boolean isNullOrEmpty(String a) {
        return a == null || a.isEmpty() || a.isBlank();
    }

    public static int parseStringToInt(String a) {
        int parsedInt = Integer.parseInt(a);
        return parsedInt;
    }
}
