/*
 *         Copyright (C) 2016-2017 宙斯
 *         All rights reserved
 *
 *        filename :Class4
 *        description :
 *
 *         created by jackzhous at  11/07/2016 12:12:12
 *         http://blog.csdn.net/jackzhouyu
 */

package com.example.ccjust.testfragment.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.DiscretePathEffect;
import android.graphics.PixelFormat;
import android.hardware.display.DisplayManager;
import android.os.Build;
import android.os.Handler;
import android.print.PrintAttributes;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ccjust.testfragment.R;
import com.example.ccjust.testfragment.activity.MyJianLiActivity;
import com.lidroid.xutils.view.annotation.event.OnTouch;

import java.io.PipedReader;


/***********
 * author: jackzhous
 * file: FloatUtil.java
 * create date: 2016/8/12 9:47
 * desc:
 * 浮点工具类，创建  显示  生成
 ************/
public class Float_BianJiUtil {

    private static final String TAG = "jackzhous";
    private static Float_BianJiUtil instance;
    private WindowManager mMansger;
    //    private LinearLayout mParams;
    private LayoutParams mParams;
    private Context mContext;

    private FrameLayout.LayoutParams rParams;


    private RelativeLayout rel_bianji;
    private LinearLayout mFloatLayout;
    private int float_x = 0;
    private int float_y = 0;
    private int screen_widht;
    private int screen_height;

    private int px = R.dimen.x89;
    private ImageView faBu_iv;


    public Float_BianJiUtil() {
//        floatImage.setVisibility(View.GONE);
    }

    public static Float_BianJiUtil getInstance() {
        if (null == instance) {
            instance = new Float_BianJiUtil();
        }

        return instance;
    }

    public void createFloatView(final Context context, int width, int height) {
        mContext = context;
        mMansger = (WindowManager) context.getApplicationContext().getSystemService(Activity.WINDOW_SERVICE);
        screen_widht = mMansger.getDefaultDisplay().getWidth();
        screen_height = mMansger.getDefaultDisplay().getHeight();

//        rParams=new FrameLayout.LayoutParams(50,50);


        mParams = new LayoutParams(50, 50);
        mParams.type = LayoutParams.TYPE_PHONE;
        mParams.flags = LayoutParams.FLAG_NOT_FOCUSABLE;
        mParams.gravity = Gravity.TOP / 2;
        if (width == 720 && height == 1280) {
            mParams.x = 250;
            mParams.y = 400;
        } else if (width == 1080 && (height == 1920 || height == 1812)) {
            mParams.x = 400;
            mParams.y = 600;
        } else if (height == 2560 && width == 1440) {
            mParams.x=550;
            mParams.y=800;

        } else if (width == 480 && height == 800) {
            mParams.x = 150;
            mParams.y = 250;

        } else if (width == 900 && height == 1440) {
            mParams.x = 350;
            mParams.y = 400;

        } else {

        }
        mParams.width = LayoutParams.WRAP_CONTENT;
        mParams.height = LayoutParams.WRAP_CONTENT;
//        mParams.x=400;
//        mParams.y=600;
//        mParams.x=250;
//        mParams.y=400;
//        mParams.width = 100;
//        mParams.height = 100;
//        mParams.x = float_x;
//        mParams.y = float_y;
//        mParams.width = 150;
//        mParams.height = 150;
        mParams.alpha = 0.3f;
        mFloatLayout = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.float_fabu, null);

        mMansger.addView(mFloatLayout, mParams);

        faBu_iv = (ImageView) mFloatLayout.findViewById(R.id.fabu_iv);

        faBu_iv.setTop(100);

        /**
         * 触摸监听，主要完成浮标的位置移动
         */

        /**
         * 点击监听
         */
        faBu_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(context, MyJianLiActivity.class));


            }
        });


    }

    public void gone() {
        mFloatLayout.setVisibility(View.GONE);
    }

    public void visibility() {
        mFloatLayout.setVisibility(View.VISIBLE);
    }
}
