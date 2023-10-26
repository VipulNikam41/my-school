package com.myscool.utils;

import lombok.experimental.UtilityClass;
import org.apache.commons.lang3.StringUtils;

@UtilityClass
public class Utils {
    public String beautify(String name) {
        if (name == null || name.equals("")) {
            return "";
        }
        return StringUtils.capitalize(name.trim());
    }
}
