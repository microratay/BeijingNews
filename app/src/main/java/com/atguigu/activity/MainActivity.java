package com.atguigu.activity;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.style.LineHeightSpan;

import com.atguigu.beijingnews.R;
import com.atguigu.fragment.ContentFragment;
import com.atguigu.fragment.LeftmenuFragment;
import com.atguigu.utils.DensityUtil;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;

public class MainActivity extends SlidingFragmentActivity {

    public static final String MAIN_CONTENT_TAG = "main_content_tag";
    public static final String LEFTMENT_TAG = "leftment_tag";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        //1设置主页面
        setContentView( R.layout.activity_main );
        //2设置左侧菜单
        setBehindContentView(R.layout.activity_leftmenu);
        //3设置右侧菜单
        SlidingMenu slidingMenu = getSlidingMenu();
        slidingMenu.setSecondaryMenu(R.layout.activity_rightmenu  );
        //4设置显示模式:左侧菜单+主页,左侧菜单+主页+右侧菜单,主页+右侧菜单
        slidingMenu.setMode( slidingMenu.LEFT_RIGHT );
        //5设置滑动的模式:滑动边缘,全屏滑动,不可滑动
        slidingMenu.setTouchModeAbove( slidingMenu.TOUCHMODE_MARGIN );
        //6设置主页占据的宽度
        slidingMenu.setBehindOffset( DensityUtil.dip2px( MainActivity.this,200 ) );

        //初始化Fragment
        initFragment();

    }

    private void initFragment() {
        //1.得到FragmentManger
        FragmentManager fm = getFragmentManager();
        //2.开启事务
        FragmentTransaction ft = fm.beginTransaction();
        //3.替换
        ft.replace( R.id.fl_main_content,new ContentFragment(), MAIN_CONTENT_TAG );
        ft.replace( R.id.fl_leftment,new LeftmenuFragment(), LEFTMENT_TAG );
        //4.提交
        ft.commit();
    }


}
