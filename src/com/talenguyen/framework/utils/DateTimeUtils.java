package com.talenguyen.framework.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author: GIANG
 * @date: 1/1/14
 * @time: 10:39 PM
 */
public class DateTimeUtils {
    public static final String DATE_FORMAT = "yyyy-MM-dd";
    public static final String TIME_FORMAT = "HH:mm";
    public static final String TIME_DISPLAY_FORMAT = "HH:mm:ss";

    public static String formatDate(long timeInMillis) {
        return format(DATE_FORMAT, timeInMillis);
    }

    public static String formatTime(long timeInMillis) {
        return format(TIME_FORMAT, timeInMillis);
    }

    public static long parseDate(String date) {
        return parse(DATE_FORMAT, date);
    }

    public static long parseTime(String time) {
        return parse(TIME_FORMAT, time);
    }

    private static String format(String pattern, long timeInMillis) {
        final SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(new Date(timeInMillis));
    }

    public static long parse(String pattern, String date) {
        final SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        try {
            return sdf.parse(date).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * Format second to display format like 3:20:30
     * @param second
     * @return
     */
    public static String formatDisplay(int second) {
        return format(TIME_DISPLAY_FORMAT, second * 1000);
    }

//    public static void setTime(long millis) {
//        if (ShellInterface.isSuAvailable()) {
//            ShellInterface.runCommand("chmod 666 /dev/alarm");
//            SystemClock.setCurrentTimeMillis(millis);
//            ShellInterface.runCommand("chmod 664 /dev/alarm");
//        }
//    }
}
