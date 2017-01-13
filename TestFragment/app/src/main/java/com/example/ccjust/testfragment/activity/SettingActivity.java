package com.example.ccjust.testfragment.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.ccjust.testfragment.R;
import com.example.ccjust.testfragment.fragments.Fragment_Mine;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class SettingActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView title_bar_textView_left;
    private TextView title_bar_textView_center;


    private LinearLayout setting_ll_xiuGaimm;
    private LinearLayout setting_ll_xinShouHelp;
    private LinearLayout setting_ll_aboutOur;
    private LinearLayout setting_ll_userFanHui;
    private LinearLayout setting_ll_exit;

    @OnClick(R.id.title_bar_textView_left)
    void back() {
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        initTitleView();
        initView();
        ButterKnife.bind(this);

    }

    private void initView() {
        setting_ll_xiuGaimm = (LinearLayout) findViewById(R.id.setting_ll_xiuGaimm);
        setting_ll_xinShouHelp = (LinearLayout) findViewById(R.id.settin_ll_xinShouHelp);
        setting_ll_aboutOur = (LinearLayout) findViewById(R.id.setting_ll_aboutOur);
        setting_ll_userFanHui = (LinearLayout) findViewById(R.id.setting_ll_userFanHui);
        setting_ll_exit = (LinearLayout) findViewById(R.id.setting_ll_exit);


        setting_ll_xiuGaimm.setOnClickListener(this);
        setting_ll_xinShouHelp.setOnClickListener(this);
        setting_ll_aboutOur.setOnClickListener(this);
        setting_ll_userFanHui.setOnClickListener(this);
        setting_ll_exit.setOnClickListener(this);
    }

    private void initTitleView() {
        title_bar_textView_center = (TextView) findViewById(R.id.title_bar_textView_center);
        title_bar_textView_left = (TextView) findViewById(R.id.title_bar_textView_left);

        title_bar_textView_center.setVisibility(View.VISIBLE);
        title_bar_textView_left.setVisibility(View.VISIBLE);

        title_bar_textView_center.setText("设置");
        title_bar_textView_left.setText("返回");


    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.setting_ll_xiuGaimm:
                startActivity(new Intent(this, GaiMiActivity.class));
                break;
            case R.id.settin_ll_xinShouHelp:
                startActivity(new Intent(this, HelpActivity.class));
                break;
            case R.id.setting_ll_aboutOur:
                startActivity(new Intent(this, AboutActivity.class));
                break;
            case R.id.setting_ll_userFanHui:
                startActivity(new Intent(this, FanHuiActivity.class));
                break;
            case R.id.setting_ll_exit:
                startActivity(new Intent(this, LoginActivity.class));
                finish();
                break;
        }

    }
}
