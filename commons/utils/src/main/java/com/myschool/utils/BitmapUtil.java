package com.myschool.utils;

import lombok.experimental.UtilityClass;

import java.util.List;

@UtilityClass
public class BitmapUtil {
    public static int getBitsSet(List<Integer> bits) {
        int bitwiseNumber = 0;

        for (Integer bit : bits) {
            bitwiseNumber |= setBitOn(bit);
        }

        return bitwiseNumber;
    }

    public static int setBitOn(int bitPos) {
        return 1 << bitPos;
    }

    public static int setNthBitSet(Integer currNumber, int bitPos) {
        if(currNumber == null) {
            currNumber = 0;
        }

        if (bitPos >= 0 && bitPos < 31) {
            currNumber |= (1 << bitPos);
        }

        return currNumber;
    }

    public static boolean isNthBitSet(Integer number, int n) {
        if (number == null) {
            return false;
        }

        return (number & setBitOn(n)) == 1;
    }
}
