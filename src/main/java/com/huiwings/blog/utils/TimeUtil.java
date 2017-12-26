package com.huiwings.blog.utils;

import java.text.SimpleDateFormat;

/**
 * huiwings@163.com
 * Create By 2017/12/25 17:29
 */
public class TimeUtil {

    public static String getDateTime(String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(System.currentTimeMillis());
    }

    /**
     * pattern yyyy/MM/dd hh:mm
     *
     * @return
     */
    public static String getDateMillis() {
        return getDateTime("yyyy/MM/dd hh:mm");
    }
}
