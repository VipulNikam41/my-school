package com.myschool.utils;

import lombok.experimental.UtilityClass;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

@UtilityClass
public class DateUtils {
    private static final TimeZone defaultTimeZone = TimeZone.getTimeZone("Asia/Kolkata");

    public static Date getDate(int year, int month, int date, int hourOfDay, int minute, int second) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeZone(defaultTimeZone);
        calendar.set(year, month, date, hourOfDay, minute, second);
        return calendar.getTime();
    }
}
