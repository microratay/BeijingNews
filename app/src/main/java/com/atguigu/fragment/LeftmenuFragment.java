package com.atguigu.fragment;

import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.atguigu.base.BaseFragment;
import com.atguigu.utils.LogUtil;

/**
 * Created by guoguo on 2017/8/4.
 */
public class LeftmenuFragment extends BaseFragment {
    private TextView textView;

    @Override
    public View initView() {
        LogUtil.e("左侧菜单视图被初始化了");
        textView = new TextView( context );
        textView.setTextSize( 23 );
        textView.setGravity( Gravity.CENTER );
        textView.setTextColor( Color.RED );
        return textView;
    }

    @Override
    public void initData() {
        super.initData();
        LogUtil.e("左侧菜单数据被初始化了");
        textView.setText( "左侧菜单页面" );
    }
    /*   /**
        * 当Fragmement被创建时回调
        * @param savedInstanceState
        * /
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
    }

    /**
     * 当视图被创建时回调
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     * /
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return super.onCreateView( inflater, container, savedInstanceState );
    }

    /**
     * 当Activity被创建之后时回调
     * @param savedInstanceState
     * /
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated( savedInstanceState );
    }
    */
}
