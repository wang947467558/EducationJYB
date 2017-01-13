package com.example.ccjust.testfragment.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.example.ccjust.testfragment.R;
import com.example.ccjust.testfragment.adapter.XiaoXiAdapter;
import com.example.ccjust.testfragment.fragments.Fragment_Mine;

import java.security.PrivateKey;
import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class XiaoXiActivity extends AppCompatActivity {

    private ListView listView;

    private List<String> list;
    private XiaoXiAdapter adapter;


    //标题声明
    private TextView title_bar_textView_left;
    private TextView title_bar_textView_center;

    @OnClick(R.id.title_bar_textView_left)
    void back() {
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xiao_xi);
        ButterKnife.bind(this);
        initTitle();
        initView();
    }

    private void initTitle() {
        title_bar_textView_center = (TextView) findViewById(R.id.title_bar_textView_center);
        title_bar_textView_left = (TextView) findViewById(R.id.title_bar_textView_left);
        title_bar_textView_left.setVisibility(View.VISIBLE);
        title_bar_textView_center.setVisibility(View.VISIBLE);
        title_bar_textView_center.setText("消息通知");
        title_bar_textView_left.setText("返回");

    }

    private void initView() {
        listView = (ListView) findViewById(R.id.xiaoXiListView);
        list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add("name");
        }
        adapter = new XiaoXiAdapter(list, this);
        listView.setAdapter(adapter);
    }
}
