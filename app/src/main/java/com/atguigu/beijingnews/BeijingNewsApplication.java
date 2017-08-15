package com.atguigu.beijingnews;

import android.app.Application;

import org.xutils.x;

/**
 * 代表整个软件
 * Created by guoguo on 2017/8/13.
 */
public class BeijingNewsApplication extends Application{
    /**
     * 所有软件创建前前运行
     */
    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.setDebug( true );
        x.Ext.init( this );
    }
}
