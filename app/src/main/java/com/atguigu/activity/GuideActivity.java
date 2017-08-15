package com.atguigu.activity;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.atguigu.beijingnews.R;
import com.atguigu.beijingnews.splashActivity;
import com.atguigu.utils.CacheUtils;

import java.util.ArrayList;

public class GuideActivity extends Activity {

    private ViewPager viewpager;
    private Button btn_start_main;
    private LinearLayout ll_point_group;
    private ArrayList<ImageView> imageViews;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_guide );
        viewpager = (ViewPager) findViewById( R.id.viewpager);
        btn_start_main = findViewById( R.id.btn_start_main );
        ll_point_group = findViewById( R.id.ll_point_group );
        int [] ids =new int[]{
                R.drawable.guide_1,
                R.drawable.guide_2,
                R.drawable.guide_3
        };
        imageViews = new ArrayList<>(  );
        for(int i=0;i<ids.length;i++){
            ImageView imageView = new ImageView( this );
            //设置背景
            imageView.setBackgroundResource( ids[i] );
            //添加到集合中
            imageViews.add(imageView);
        }

        //设置ViewPager 适配器
        viewpager.setAdapter( new MyPagerAdapter());

        viewpager.addOnPageChangeListener( new MyOnPageChangeListener() );
        btn_start_main.setOnClickListener( new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                //1.保存曾经进入过主页面
                CacheUtils.putBoolean(GuideActivity.this, splashActivity.START_MAIN,true);
                //2.跳转到主页面
                Intent intent = new Intent( GuideActivity.this,MainActivity.class );
                //3.关闭引导页面
                finish();
            }
        });
    }

    class MyOnPageChangeListener implements ViewPager.OnPageChangeListener{
        /**
         * 当页面回调了会回调这个方法
         * @param position 当前滑动页面的位置
         * @param positionOffset 页面滑动的百分比
         * @param positionOffsetPixels 滑动的像素
         */
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        /**
         * 当页面被选中的时候回调这个方法
         * @param position 被选中页面的位置
         */
        @Override
        public void onPageSelected(int position) {
            if(position == imageViews.size()-1){
                //最后一个页面
                btn_start_main.setVisibility( View.VISIBLE );
            }else{
                //其他页面
                btn_start_main.setVisibility( View.GONE );
            }
        }

        /**
         * 当ViewPager页面滑动状态发生变化的时候
         * @param state
         */
        @Override
        public void onPageScrollStateChanged(int state) {

        }
    }

    class MyPagerAdapter extends PagerAdapter{
        //返回数据总个数
        @Override
        public int getCount() {
            return imageViews.size();
        }

        /**
         * 判断
         * @param view 当前创建的视图
         * @param object 下面instantiateItem返回的数值
         * @return
         */
        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        /**
         * 作用,getView
         * @param container ViewPager
         * @param position 要创建页面的位置
         * @return 返回和创建当前有关系的值
         */
        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            ImageView imageView = imageViews.get( position );
            //添加到容器中
            container.addView( imageView );
            return imageView;
        }

        /**
         * 销毁页面
         * @param container ViewPager
         * @param position 要销毁的位置
         * @param object 要销毁的页面
         */
        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView( (View) object );
        }
    }
}
