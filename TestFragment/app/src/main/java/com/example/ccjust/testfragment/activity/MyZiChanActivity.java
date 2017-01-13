
package com.example.ccjust.testfragment.activity;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.ccjust.testfragment.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MyZiChanActivity extends AppCompatActivity {

    private TextView title_bar_textView_center;
    private TextView title_bar_textView_left;

    private TextView tv_zichang_show;

    @OnClick(R.id.title_bar_textView_left)
    void back() {
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_zi_chan);
        ButterKnife.bind(this);
        initTitleView();
        initView();
    }

    private void initView() {
        tv_zichang_show = (TextView) findViewById(R.id.tv_zichang_show);

    }

    private void initTitleView() {
        title_bar_textView_center = (TextView) findViewById(R.id.title_bar_textView_center);
        title_bar_textView_left = (TextView) findViewById(R.id.title_bar_textView_left);

        title_bar_textView_center.setVisibility(View.VISIBLE);
        title_bar_textView_left.setVisibility(View.VISIBLE);

        title_bar_textView_left.setText("返回");
        title_bar_textView_center.setText("我的资产");
    }
}
