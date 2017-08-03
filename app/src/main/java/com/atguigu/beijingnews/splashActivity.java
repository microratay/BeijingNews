package com.atguigu.beijingnews;

import android.app.Activity;
import android.content.Intent;
import android.icu.text.AlphabeticIndex;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.atguigu.activity.GuideActivity;
import com.atguigu.activity.MainActivity;
import com.atguigu.utils.CacheUtils;

public class splashActivity extends Activity {
    public static final String START_MAIN = "start_main";
    private RelativeLayout rl_splahs_root;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        rl_splahs_root = (RelativeLayout)findViewById(R.id.rl_splashs_root);

        //渐变动画,缩放动画,旋转动画
        AlphaAnimation aa = new AlphaAnimation(0,1);
        aa.setDuration(1500);
        aa.setFillAfter(true);

        ScaleAnimation sa = new ScaleAnimation(0,1,0,1,ScaleAnimation.RELATIVE_TO_SELF,0.5f,ScaleAnimation.RELATIVE_TO_SELF,0.5f);
        sa.setDuration(1500);
        sa.setFillAfter(true);

        RotateAnimation ra = new RotateAnimation(0,360, RotateAnimation.RELATIVE_TO_SELF,0.5f,RotateAnimation.RELATIVE_TO_SELF,0.5f);
        ra.setDuration(1500);
        ra.setFillAfter(true);

        AnimationSet set = new AnimationSet(false);
        //添加三个动画没有先后顺序
        set.addAnimation(ra);
        set.addAnimation(aa);
        set.addAnimation(sa);

        rl_splahs_root.startAnimation(set);
        set.setAnimationListener(new MyAnimationListener());
    }
    class MyAnimationListener implements Animation.AnimationListener{

        //当动画开始播放的时候回调这个方法
        @Override
        public void onAnimationStart(Animation animation) {

        }

        //当动画播放结束的时候回调这个方法
        @Override
        public void onAnimationEnd(Animation animation) {
            boolean isStartMain = CacheUtils.getBoolean( splashActivity.this, START_MAIN );
            Intent intent;
            if(isStartMain){
                //如果进入过主页面,直接进入主页面
                intent = new Intent( splashActivity.this,MainActivity.class );
            }else{
                //如果没有进入过主页面,进入欢迎页面
                intent = new Intent( splashActivity.this,GuideActivity.class );
            }
            startActivity( intent );
            //关闭splash界面
            finish();
            //Toast.makeText(splashActivity.this,"动画播放完成了",Toast.LENGTH_SHORT).show();

        }

        //当动画重复播放的时候回调这个方法
        @Override
        public void onAnimationRepeat(Animation animation) {

        }
    }
}
