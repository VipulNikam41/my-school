package com.myschool.utils;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UtilsTest {
    @Test
    public void testBeautify() {
        String sample = "   This       is saMple     String ";
        assertEquals("This Is Sample String", Utils.beautify(sample));
    }

    @Test
    public void testRemoveExtraSpaces() {
        String sample = "   This       is saMple     String ";
        assertEquals("This is saMple String", Utils.removeExtraSpaces(sample));
    }
}