package com.example.baseproject.utils.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.baseproject.MyApplication;

public class ShareUtils {

    private static final String NAME = "momofenxidashi";
    private static SharedPreferences sp = null;
    private static Context context = MyApplication.getContext();
    /**
     * key值
     */
    public static String USER_OPEN_APP_TIME = "user_open_app_time";// 用户当前打开app的时间戳
    public static String USER_USE_DURATION = "user_use_duration";// 用户使用app的时长，单位s
    public static String USER_HEAD_URI = "user_head_uri";// 用户头像
    public static String USER_NICKNAME = "user_nickname";// 用户昵称
    public static String ANA_ONE_RES = "any_one_res";// 星座
    public static String ANY_TWO_RES = "any_two_res";// 家乡
    public static String ANY_THREE_RES = "any_three_res";// 学校
    public static String GRADE_USER_INDEX = "grade_user_index";// 个性签名
    public static String GRADE_USER_INDEXX = "grade_user_indexx";// 日期


    /**
     * 存布尔值
     */
    public static void putBoolean(String key, boolean value) {
        if (sp == null) {
            sp = context.getSharedPreferences(NAME, Context.MODE_PRIVATE);
        }
        sp.edit().putBoolean(key, value).commit();
    }

    /**
     * 去布尔值
     */
    public static boolean getBoolean(String key,
                                     boolean defValue) {
        if (sp == null) {
            sp = context.getSharedPreferences(NAME, Context.MODE_PRIVATE);
        }
        return sp.getBoolean(key, defValue);
    }

    /**
     * 存Strings
     */
    public static void putString(String key, String value) {
        if (sp == null) {
            sp = context.getSharedPreferences(NAME, Context.MODE_PRIVATE);
        }
        sp.edit().putString(key, value).commit();
    }

    /**
     * 取String
     */
    public static String getString(String key, String defValue) {
        if (sp == null) {
            sp = context.getSharedPreferences(NAME, Context.MODE_PRIVATE);
        }
        return sp.getString(key, defValue);
    }

    /**
     * 存int
     */
    public static void putInt(String key, int value) {
        if (sp == null) {
            sp = context.getSharedPreferences(NAME, Context.MODE_PRIVATE);
        }
        sp.edit().putInt(key, value).commit();
    }

    /**
     * 取int
     */
    public static int getInt(String key, int defValue) {
        if (sp == null) {
            sp = context.getSharedPreferences(NAME, Context.MODE_PRIVATE);
        }
        return sp.getInt(key, defValue);
    }

    /**
     * 存Float
     */
    public static void putFloat(String key, Float value) {
        if (sp == null) {
            sp = context.getSharedPreferences(NAME, Context.MODE_PRIVATE);
        }
        sp.edit().putFloat(key, value).commit();
    }

    /**
     * 取Float
     */
    public static Float getFloat(String key, Float defValue) {
        if (sp == null) {
            sp = context.getSharedPreferences(NAME, Context.MODE_PRIVATE);
        }
        return sp.getFloat(key, defValue);
    }

    /**
     * 存Long
     */
    public static void putLong(String key, long value) {
        if (sp == null) {
            sp = context.getSharedPreferences(NAME, Context.MODE_PRIVATE);
        }
        sp.edit().putLong(key, value).commit();
    }

    /**
     * 取Long
     */
    public static long getLong(String key, long defValue) {
        if (sp == null) {
            sp = context.getSharedPreferences(NAME, Context.MODE_PRIVATE);
        }
        return sp.getLong(key, defValue);
    }
}
