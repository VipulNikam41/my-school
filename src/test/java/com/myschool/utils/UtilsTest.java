package com.myschool.utils;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UtilsTest {
    @Test
    public void testBeautify() {
        assertEquals("", Utils.beautify(null));
        assertEquals("", Utils.beautify(""));
    }
}