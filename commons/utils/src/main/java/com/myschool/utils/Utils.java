package com.myschool.utils;

import lombok.experimental.UtilityClass;

@UtilityClass
public class Utils {
    public java.lang.String beautify(java.lang.String str) {
        if (StringTool.isEmpty(str)) {
            return str;
        }
        java.lang.String[] words = removeExtraSpaces(str).split("\\s+");

        StringBuilder result = new StringBuilder();

        for (java.lang.String word : words) {
            if (!result.isEmpty()) {
                result.append(" ");
            }
            result.append(capitalize(word));
        }

        return result.toString();
    }

    public java.lang.String removeExtraSpaces(java.lang.String str) {
        if (StringTool.isEmpty(str)) {
            return str;
        }
        return str.replaceAll("\\s+", " ").trim();
    }

    public java.lang.String capitalize(java.lang.String str) {
        if (StringTool.isEmpty(str)) {
            return str;
        }
        if (str.length() == 1) {
            return str.toUpperCase();
        }

        java.lang.String firstLetterCapital = str.substring(0, 1).toUpperCase();
        java.lang.String restOfWordSmall = str.substring(1).toLowerCase();

        return firstLetterCapital + restOfWordSmall;
    }
}
