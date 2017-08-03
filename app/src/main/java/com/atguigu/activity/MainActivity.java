package com.atguigu.activity;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.style.LineHeightSpan;

import com.atguigu.beijingnews.R;
import com.atguigu.utils.DensityUtil;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;

public class MainActivity extends SlidingFragmentActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        //设置主页面
        setContentView( R.layout.activity_main );
        //设置左侧菜单
        setBehindContentView(R.layout.activity_leftmenu);
        //设置右侧菜单
        SlidingMenu slidingMenu = getSlidingMenu();
        slidingMenu.setSecondaryMenu(R.layout.activity_rightmenu  );
        //设置显示模式:左侧菜单+主页,左侧菜单+主页+右侧菜单,主页+右侧菜单
        slidingMenu.setMode( slidingMenu.LEFT_RIGHT );
        //设置滑动的模式:滑动边缘,全屏滑动,不可滑动
        slidingMenu.setTouchModeAbove( slidingMenu.TOUCHMODE_MARGIN );
        //设置主页占据的宽度
        slidingMenu.setBehindOffset( DensityUtil.dip2px( MainActivity.this,200 ) );


    }


}
