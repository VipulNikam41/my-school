package com.myschool.utils;

import lombok.experimental.UtilityClass;
import org.apache.commons.lang3.StringUtils;

@UtilityClass
public class Utils {
    public String beautify(String str) {
        if (StringUtils.isEmpty(str)) {
            return str;
        }
        String[] words = removeExtraSpaces(str).split("\\s+");

        StringBuilder result = new StringBuilder();

        for (String word : words) {
            if (!result.isEmpty()) {
                result.append(" ");
            }
            result.append(capitalize(word));
        }

        return result.toString();
    }

    public String removeExtraSpaces(String str) {
        if (StringUtils.isEmpty(str)) {
            return str;
        }
        return str.replaceAll("\\s+", " ").trim();
    }

    public String capitalize(String str) {
        if (StringUtils.isEmpty(str)) {
            return str;
        }
        if (str.length() == 1) {
            return str.toUpperCase();
        }

        String firstLetterCapital = str.substring(0, 1).toUpperCase();
        String restOfWordSmall = str.substring(1).toLowerCase();

        return firstLetterCapital + restOfWordSmall;
    }
}
