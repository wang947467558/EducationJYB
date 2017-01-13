package com.example.ccjust.testfragment.flyactivity;

import android.app.Dialog;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ccjust.testfragment.R;
import com.example.ccjust.testfragment.view.MyDialog;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by zhangjian on 2016/12/21.
 */

public class IHaveASDreamActivity extends AppCompatActivity  {

    private ImageView title_bar_imageView_left;
    private TextView title_bar_textView_conter;
    private TextView title_bar_textViewSizeBig_right;

        private AlertDialog dialog;
    private Button fly_music;
    private TextView fly_tv_comfirm;

    @OnClick(R.id.title_bar_imageView_left)
    void back() {
        finish();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ihavaadream);
        ButterKnife.bind(this);
        initTitleView();

        initView();

    }

    private void initView() {
        fly_music = (Button) findViewById(R.id.fly_music);

        fly_music.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(IHaveASDreamActivity.this).inflate(R.layout.dialog_layout, null);
                dialog = new MyDialog.Builder(IHaveASDreamActivity.this, R.style.MyDialog).create();
                dialog.setCanceledOnTouchOutside(true);
                dialog.show();
                dialog.getWindow().setContentView(linearLayout);
                fly_tv_comfirm= (TextView) linearLayout.findViewById(R.id.fly_tv_comfirm);

                fly_tv_comfirm.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(IHaveASDreamActivity.this, "dfdsfd", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });


    }

    private void initTitleView() {
        title_bar_imageView_left = (ImageView) findViewById(R.id.title_bar_imageView_left);
        title_bar_textView_conter = (TextView) findViewById(R.id.title_bar_textView_center);
        title_bar_textViewSizeBig_right = (TextView) findViewById(R.id.title_bar_textViewSizeBig_right);
        title_bar_imageView_left.setVisibility(View.VISIBLE);
        title_bar_imageView_left.setImageResource(R.drawable.left);
        title_bar_textView_conter.setVisibility(View.VISIBLE);
        title_bar_textViewSizeBig_right.setVisibility(View.VISIBLE);
        title_bar_textView_conter.setText("我有一个梦想");
        title_bar_textViewSizeBig_right.setText("发布");


    }
//
//    @Override
//    public void onClick(View v) {
//
//        switch (v.getId()) {
//            case R.id.fly_music:
////                LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this).inflate(R.layout.dialog_layout, null);
////                dialog = new MyDialog.Builder(IHaveASDreamActivity.this, R.style.MyDialog).create();
////                dialog.setCanceledOnTouchOutside(false);
////                dialog.show();
////                dialog.getWindow().setContentView(linearLayout);
//
//
//                break;
////            case R.id.fly_tv_comfirm:
//
////                break;
//        }
//
//    }
}
