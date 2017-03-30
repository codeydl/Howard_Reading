package com.itydl.howard_reading.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * @author ydl
 * @version $Rev$
 * @time 2017/2/15 ${time}
 * @des ${TODO}
 * @updateAuthor $Author$
 * @updateDate $Date$
 * @updateDes ${TODO}
 */

public class SpTools {
    /**
     * 得到缓存值
     */
    public static boolean getBoolean(Context context, String key) {
        SharedPreferences sp = context.getSharedPreferences(Constants.SPFILE, Context.MODE_PRIVATE);
        return sp.getBoolean(key, false);
    }

    /**
     * 保存软件参数
     */
    public static void putBoolean(Context context, String key, boolean value) {
        SharedPreferences sp = context.getSharedPreferences(Constants.SPFILE, Context.MODE_PRIVATE);
        sp.edit().putBoolean(key, value).commit();
    }

    public static void putString(Context context, String key, String value) {
        SharedPreferences sp = context.getSharedPreferences(Constants.SPFILE, Context.MODE_PRIVATE);
        sp.edit().putString(key, value).commit();
    }

    public static String getString(Context context, String key,String defValue) {
        SharedPreferences sp = context.getSharedPreferences(Constants.SPFILE, Context.MODE_PRIVATE);
        return sp.getString(key,defValue);
    }

}
