package com.myproject.util;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateUtils {

    public static Date getDayBeginning(Date date) {
        Calendar calStart = new GregorianCalendar();
        calStart.setTime(date);
        calStart.set(Calendar.HOUR_OF_DAY, 0);
        calStart.set(Calendar.MINUTE, 0);
        calStart.set(Calendar.SECOND, 0);
        calStart.set(Calendar.MILLISECOND, 0);
        return calStart.getTime();
    }

    public static Date getDayEnding(Date date) {
        Calendar calStart = new GregorianCalendar();
        calStart.setTime(date);
        calStart.set(Calendar.HOUR_OF_DAY, 23);
        calStart.set(Calendar.MINUTE, 59);
        calStart.set(Calendar.SECOND, 59);
        calStart.set(Calendar.MILLISECOND, 59);
        return calStart.getTime();
    }

}
