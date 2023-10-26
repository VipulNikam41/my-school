package com.myscool.utils;

import lombok.experimental.UtilityClass;
import org.apache.commons.lang3.StringUtils;

@UtilityClass
public class Utility {
    public String formatName(String name) {
        if(StringUtils.isEmpty(name)) {
            return name;
        }
        name = Character.toTitleCase(name.charAt(0)) + name.substring(1);
        return name;
    }
}
