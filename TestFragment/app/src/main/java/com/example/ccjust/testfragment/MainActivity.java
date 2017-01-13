package com.example.ccjust.testfragment;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTabHost;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ccjust.testfragment.fragments.Fragment_Fly;
import com.example.ccjust.testfragment.fragments.Fragment_Home;
import com.example.ccjust.testfragment.fragments.Fragment_Hunter;
import com.example.ccjust.testfragment.fragments.Fragment_Mine;
import com.example.ccjust.testfragment.adapter.MyViewPagerAdapter;
import com.example.ccjust.testfragment.hunteractivity.JianZhiActivity;
import com.example.ccjust.testfragment.hunteractivity.QuanZhiActivity;
import com.example.ccjust.testfragment.utils.FloatUtil;
import com.example.ccjust.testfragment.utils.Float_BianJiUtil;
import com.example.ccjust.testfragment.utils.Fonts;
import com.example.ccjust.testfragment.view.HunterDialog;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    private ViewPager mViewPager;
    private List<Fragment> list;

    private ImageView[] imageViews = new ImageView[4];
    private TextView[] textViews = new TextView[4];
    private LinearLayout linearLayout[] = new LinearLayout[4];
    private long mExitTime;
    Dialog dialog;

    private boolean flg = true;
    private View view1, view2, view3, view4;

    //底部内容
    private String toArray[] = {"首页", "放飞梦想", "赏金猎人", "个人中心"};

    //布局
    private LayoutInflater inflater;

    //声明FragmentTabHost对象
    private FragmentTabHost fragmentTabHost;
    //Fragment布局数组
    private Class<?>[] fragments = {Fragment_Home.class, Fragment_Fly.class, Fragment_Hunter.class, Fragment_Mine.class};


    //初始化 底部图片
    private int diBu_Image[] = {R.drawable.tab_home_image_bg, R.drawable.tab_home_image_bg, R.drawable.tab_home_image_bg, R.drawable.tab_home_image_bg};
    //字体格式
    Typeface typeface;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("TAG", "MainActivity_onCreate()");
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        initView();
        setContentView(R.layout.activity_main1);
//        typeface = Typeface.createFromAsset(getAssets(), "yahei.ttf");

        ImageLoaderConfiguration configuration = new ImageLoaderConfiguration.Builder(this).build();
        ImageLoader.getInstance().init(configuration);
        initDiBuView();

//        init();
    }

    private void initView() {
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            Window window = getWindow();
//            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS | WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
//            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
//            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
//            window.setStatusBarColor(Color.TRANSPARENT);
//            return;
//        }
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
//            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            //透明状态栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//            //透明导航栏
////            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }

    }

    private void initDiBuView() {
        inflater = LayoutInflater.from(this);
        fragmentTabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
        fragmentTabHost.setup(this, getSupportFragmentManager(), R.id.realtabcontent);
        fragmentTabHost.getTabWidget().setDividerDrawable(null);
        view1 = inflater.inflate(R.layout.tab_shouye, null);
        view2 = inflater.inflate(R.layout.tab_fly, null);
        view3 = inflater.inflate(R.layout.tab_hunter, null);
        view4 = inflater.inflate(R.layout.tab_mine, null);
        TabHost.TabSpec tabSpec1 = fragmentTabHost.newTabSpec(toArray[0])
                .setIndicator(view1);
        TabHost.TabSpec tabSpec2 = fragmentTabHost.newTabSpec(toArray[1])
                .setIndicator(view2);
        TabHost.TabSpec tabSpec3 = fragmentTabHost.newTabSpec(toArray[2])
                .setIndicator(view3);
        TabHost.TabSpec tabSpec4 = fragmentTabHost.newTabSpec(toArray[3])
                .setIndicator(view4);
        fragmentTabHost.addTab(tabSpec1, fragments[0], null);
        fragmentTabHost.addTab(tabSpec2, fragments[1], null);
        fragmentTabHost.addTab(tabSpec3, fragments[2], null);
        fragmentTabHost.addTab(tabSpec4, fragments[3], null);

        view3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(MainActivity.this).inflate(R.layout.dialog_hunter, null);
                dialog = new HunterDialog.Builder(MainActivity.this, R.style.MyDialog).create();
                dialog.setCanceledOnTouchOutside(true);
                dialog.show();

                dialog.getWindow().setContentView(linearLayout);

                RelativeLayout tv_fullTime = (RelativeLayout) linearLayout.findViewById(R.id.tv_fullTime);
                RelativeLayout tv_partTime = (RelativeLayout) linearLayout.findViewById(R.id.tv_partTime);
                RelativeLayout tv_back = (RelativeLayout) linearLayout.findViewById(R.id.tv_back);


                tv_fullTime.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(MainActivity.this, QuanZhiActivity.class));
                    }
                });

                tv_partTime.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(MainActivity.this, JianZhiActivity.class));
                    }
                });
                tv_back.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });


            }
        });


    }

    private View getTabItemView(int i) {
        View view = inflater.inflate(R.layout.tab_item_view, null);

        ImageView imageView = (ImageView) view.findViewById(R.id.imageview);
        imageView.setImageResource(diBu_Image[i]);
        TextView textView = (TextView) view.findViewById(R.id.textview);
        textView.setText(toArray[i]);
        return view;
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if ((System.currentTimeMillis() - mExitTime) > 2000) {
                Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
                mExitTime = System.currentTimeMillis();

            } else {
                finish();

            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("TAG", "MainActivity_onResume()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("TAG", "MainActivity_onREstart()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("TAG", "MainActivity_onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("TAG", "MainActivity_onStop()");
        FloatUtil.getInstance().gone();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("TAG", "MainActivity_onDestroy()");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("TAG", "MainActivity_onStart()");
    }
}

