package com.atguigu.base;

import android.app.Fragment;
import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;

import com.atguigu.beijingnews.R;

import org.w3c.dom.Text;

/**
 * 公共类,HomePager,NewsCenterPager,SmartServicePager,
 * Created by guoguo on 2017/8/13.
 */
public class BasePager {
    public final Context context;
    public View rootView;      //
    public TextView tv_title;
    public ImageButton ib_menu;
    public FrameLayout fl_content;

    public BasePager(Context context) {
        this.context = context;
        rootView = initView();
    }


    /**
     * 用于初始化公共部分视图,并且初始化加载子视图的FrameLayout
     * * @param context
     */
    private View initView(){
        View view = View.inflate(context, R.layout.base_pager,null);
        tv_title = (TextView) view.findViewById( R.id.tv_title );
        ib_menu = (ImageButton)view.findViewById( R.id.ib_menu );
        fl_content = (FrameLayout) view.findViewById( R.id.fl_content );
        return null;
    }

    /**
     * 初始化数据,当孩子需要初始化数据或者绑定数据,联网请求数据并且绑定的时候,重写该方法
     * @param
     */
    public void initData(){
    }
}
