package com.company.utils;

/**
 * Created by nazymko.patronus@gmail.com
 */
public class IOutil {

    public static String convertStreamToString(java.io.InputStream is) {
        java.util.Scanner s = new java.util.Scanner(is).useDelimiter("\\A");
        return s.hasNext() ? s.next() : "";
    }
}
