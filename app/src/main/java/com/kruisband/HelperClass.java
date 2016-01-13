package com.kruisband;

public class HelperClass {
    public static String makeHTMLstring(String text) {
        String HTMLstring =
                "<html><body>"
                        + "<p align=\"justify\">"
                        + text
                        + "</p> "
                        + "</body></html>";
        return HTMLstring;
    }
}
