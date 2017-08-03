package com.atguigu.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.atguigu.beijingnews.splashActivity;

/**
 * Created by guoguo on 2017/8/2.
 */
public class CacheUtils {
    public static boolean getBoolean(Context context, String key) {
        SharedPreferences sp = context.getSharedPreferences( "atguigu",Context.MODE_PRIVATE );
        return sp.getBoolean( key,false );
    }
}
