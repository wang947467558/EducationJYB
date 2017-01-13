package com.example.ccjust.testfragment.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.ccjust.testfragment.R;
import com.example.ccjust.testfragment.fragments.Fragment_Mine;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class YQYouLiActivity extends AppCompatActivity {


    private TextView title_bar_textView_left;
    private TextView title_bar_textView_center;




    @OnClick(R.id.title_bar_textView_left)
    void back() {
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yqyou_li);
        initTitle();
        ButterKnife.bind(this);
    }

    private void initTitle() {
        title_bar_textView_center = (TextView) findViewById(R.id.title_bar_textView_center);
        title_bar_textView_left = (TextView) findViewById(R.id.title_bar_textView_left);

        title_bar_textView_left.setVisibility(View.VISIBLE);
        title_bar_textView_center.setVisibility(View.VISIBLE);

        title_bar_textView_center.setText("邀请有礼");
        title_bar_textView_left.setText("返回");
    }
}
