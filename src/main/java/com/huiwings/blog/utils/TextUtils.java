package com.huiwings.blog.utils;

/**
 * huiwings@163.com
 * Create By 2017/9/7 17:15
 */
public class TextUtils {
    public static boolean isEmpty(String str) {
        if (str != null && str.length() > 0) {
            return false;
        }
        return true;
    }
}
