package com.atguigu.fragment;

import android.app.Fragment;
import android.graphics.Color;
import android.graphics.pdf.PdfDocument;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.atguigu.base.BaseFragment;
import com.atguigu.base.BasePager;
import com.atguigu.beijingnews.R;
import com.atguigu.pager.GovaffairPager;
import com.atguigu.pager.HomePager;
import com.atguigu.pager.NewsCenterPager;
import com.atguigu.pager.SettingPager;
import com.atguigu.pager.SmartServerPager;
import com.atguigu.utils.LogUtil;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;

/**
 * Created by guoguo on 2017/8/5.
 */
public class ContentFragment extends BaseFragment {
    @ViewInject( R.id.viewpager )
    private ViewPager viewpager;
    @ViewInject( R.id.rg_main )
    private RadioGroup rg_main;

    private ArrayList<BasePager> basePagers;    //装5个页面的集合

    @Override
    public View initView() {
        LogUtil.e("正文Fragment视图被初始化了");
        View view = View.inflate( context, R.layout.content_fragment , null );
//        viewpager = (ViewPager)view.findViewById( R.id.viewpager );
//        rg_main = (RadioGroup)view.findViewById( R.id.rg_main );
        //1.把视图注入到框架中,让ContentFragment.this和View关联起来
        x.view().inject( ContentFragment.this,view );
//        textView = new TextView( context );
//        textView.setTextSize( 23 );
//        textView.setGravity( Gravity.CENTER );
//        textView.setTextColor( Color.RED );
        return view;
    }

    @Override
    public void initData() {
        super.initData();
        LogUtil.e("正文Fragment数据被初始化了");
        //textView.setText( "正文Fragment菜单页面" );
        //初始化5个页面,并且放入集合中
        basePagers = new ArrayList<>(  );
        basePagers.add( new HomePager( context ) );//主页面
        basePagers.add( new NewsCenterPager( context ) );//新闻中心页面
        basePagers.add( new SmartServerPager( context ) );//智慧服务页面
        basePagers.add( new GovaffairPager( context ) );//政要指南页面
        basePagers.add( new SettingPager( context ) );//设置中心页面
        //设置默认选中首页
        rg_main.check( R.id.rb_home );
        //设置ViewPager的适配器
        viewpager.setAdapter(new ContentFragmentAdapter() );
    }
    class ContentFragmentAdapter extends PagerAdapter{

        @Override
        public int getCount() {
            return basePagers.size();
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            BasePager basePager = basePagers.get( position );     //各个页面的实例
            View rootView = basePager.rootView;                     //各个子页面
            container.addView( rootView );
            return rootView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView( (View) object );
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }
    }
/*    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return super.onCreateView( inflater, container, savedInstanceState );
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated( savedInstanceState );
    }
    */
}
