package com.example.ccjust.testfragment.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ccjust.testfragment.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class FanHuiActivity extends AppCompatActivity {
    private TextView title_bar_textView_left;
    private TextView title_bar_textView_center;


    @OnClick(R.id.title_bar_textView_left)
    void back() {
        finish();
    }

    @OnClick(R.id.tv_submit)
    void tiJiao() {
        Toast.makeText(this, "提交成功", Toast.LENGTH_SHORT).show();
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fan_hui);

        initTitleView();
        ButterKnife.bind(this);
    }

    private void initTitleView() {
        title_bar_textView_center = (TextView) findViewById(R.id.title_bar_textView_center);
        title_bar_textView_left = (TextView) findViewById(R.id.title_bar_textView_left);

        title_bar_textView_left.setVisibility(View.VISIBLE);
        title_bar_textView_center.setVisibility(View.VISIBLE);


        title_bar_textView_left.setText("返回");
        title_bar_textView_center.setText("用户反馈");
    }
}
