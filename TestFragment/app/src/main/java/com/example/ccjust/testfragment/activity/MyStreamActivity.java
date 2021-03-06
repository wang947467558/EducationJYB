package com.example.ccjust.testfragment.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.ccjust.testfragment.R;
import com.example.ccjust.testfragment.adapter.StreamAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.example.ccjust.testfragment.R.id.title_bar_textView_left;

public class MyStreamActivity extends AppCompatActivity {

    private ListView listView;
    private StreamAdapter adapter;
    private List<String> list;

    private TextView title_bar_textView_center;
    private ImageView title_bar_imageView_left;

    @OnClick(R.id.title_bar_imageView_left)
    void back() {
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_stream);
        ButterKnife.bind(this);
        initView();
        initTitleView();
    }

    private void initView() {
        listView = (ListView) findViewById(R.id.streamListView);
        list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add("name");
        }
        adapter = new StreamAdapter(list, this);
        listView.setAdapter(adapter);
    }


    private void initTitleView() {
        title_bar_textView_center = (TextView) findViewById(R.id.title_bar_textView_center);
        title_bar_imageView_left = (ImageView) findViewById(R.id.title_bar_imageView_left);
        title_bar_textView_center.setVisibility(View.VISIBLE);
        title_bar_imageView_left.setVisibility(View.VISIBLE);

        title_bar_imageView_left.setImageResource(R.drawable.left);
        title_bar_textView_center.setText("我的梦想");
    }
}
