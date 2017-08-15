package com.atguigu.pager;

import android.content.Context;
import android.view.Gravity;
import android.widget.TextView;

import com.atguigu.base.BasePager;

/**
 * Created by guoguo on 2017/8/15.
 */
public class SettingPager extends BasePager{
    public SettingPager(Context context) {
        super(context);
    }

    public void initData( ) {
        super.initData();
        tv_title.setText( "设置中心" );                  //1.设置标题栏
        TextView textView =new TextView( context );     //2.联网请求,得到数据,创建视图
        textView.setGravity( Gravity.CENTER );
        textView.setTextSize( 25 );
        fl_content.addView( textView );                 //3.把子视图添加到BasePager的FragemLayout中
        textView.setText( "设置中心内容" );                //4.绑定数据
    }
}
