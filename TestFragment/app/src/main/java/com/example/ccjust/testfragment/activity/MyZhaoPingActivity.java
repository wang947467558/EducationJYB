package com.example.ccjust.testfragment.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.ccjust.testfragment.R;
import com.example.ccjust.testfragment.adapter.MyZhaoPingAdapter;
import com.example.ccjust.testfragment.fragments.Fragment_Mine;

import org.w3c.dom.ls.LSInput;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MyZhaoPingActivity extends AppCompatActivity {
    private ImageView title_bar_imageView_left;
    private TextView title_bar_textView_center;
    private TextView title_bar_textViewSizeBig_rigth;


    private List<String> list;
    private MyZhaoPingAdapter adapter;
    private ListView listView;


    @OnClick(R.id.title_bar_imageView_left)
    void back() {
        finish();
    }

    @OnClick(R.id.title_bar_textViewSizeBig_right)
    void faBuZhiWei() {
        startActivity(new Intent(this, ZhiWeiFaBuActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_zhao_ping);
        initTitleView();
        initView();

        ButterKnife.bind(this);
    }

    private void initTitleView() {
        title_bar_imageView_left = (ImageView) findViewById(R.id.title_bar_imageView_left);
        title_bar_textView_center = (TextView) findViewById(R.id.title_bar_textView_center);
        title_bar_textViewSizeBig_rigth = (TextView) findViewById(R.id.title_bar_textViewSizeBig_right);

        title_bar_textView_center.setVisibility(View.VISIBLE);
        title_bar_textViewSizeBig_rigth.setVisibility(View.VISIBLE);
        title_bar_imageView_left.setVisibility(View.VISIBLE);


        title_bar_imageView_left.setImageResource(R.drawable.left);
        title_bar_textView_center.setText("我的招聘");
        title_bar_textViewSizeBig_rigth.setText("发布职位");


    }

    private void initView() {
        listView = (ListView) findViewById(R.id.zhaoPing_ListView);

        list = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            list.add("name");
        }

        adapter = new MyZhaoPingAdapter(list, this);
        listView.setAdapter(adapter);
    }
}
