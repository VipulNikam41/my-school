package com.myscool.utils;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UtilityTest {
    @Test
    public void beautify() {
        String sample = "   This       is saMple     String ";
        assertEquals("This Is Sample String", Utility.beautify(sample));
    }

    @Test
    public void removeExtraSpaces() {
        String sample = "   This       is saMple     String ";
        assertEquals("This is saMple String", Utility.removeExtraSpaces(sample));
    }
}