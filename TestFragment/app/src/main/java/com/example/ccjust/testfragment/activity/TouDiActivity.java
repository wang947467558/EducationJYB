package com.example.ccjust.testfragment.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.example.ccjust.testfragment.R;
import com.example.ccjust.testfragment.adapter.MyViewPagerAdapter;
import com.example.ccjust.testfragment.fragments.Fragment_BeiChaKan;
import com.example.ccjust.testfragment.fragments.Fragment_MianShi;
import com.example.ccjust.testfragment.fragments.Fragment_QuanBu;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class TouDiActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView title_bar_textView_left;
    private TextView title_bar_textView_center;

    private TextView tv_quanBu;
    private TextView tv_bChaKan;
    private TextView tv_mianShi;
    private ViewPager viewPager;
    private List<Fragment> list;

    @OnClick(R.id.title_bar_textView_left)
    void back() {
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tou_di);
        initTitleView();
        initView();
        initFragment();
        ButterKnife.bind(this);
    }


    private void initFragment() {
        Fragment_QuanBu quanBu = new Fragment_QuanBu();
        Fragment_BeiChaKan beiChaKan = new Fragment_BeiChaKan();
        Fragment_MianShi mianShi = new Fragment_MianShi();
        list = new ArrayList<>();
        list.add(quanBu);
        list.add(beiChaKan);
        list.add(mianShi);


        FragmentManager manager = getSupportFragmentManager();
        MyViewPagerAdapter adapter = new MyViewPagerAdapter(manager, list);
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(0);
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                if (position == 0) {
                    tv_quanBu.setTextColor(getResources().getColor(R.color.themeColor));
                    tv_bChaKan.setTextColor(getResources().getColor(R.color.text_sed));
                    tv_mianShi.setTextColor(getResources().getColor(R.color.text_sed));
                } else if (position == 1) {
                    tv_quanBu.setTextColor(getResources().getColor(R.color.text_sed));
                    tv_bChaKan.setTextColor(getResources().getColor(R.color.themeColor));
                    tv_mianShi.setTextColor(getResources().getColor(R.color.text_sed));
                } else if (position == 2) {
                    tv_quanBu.setTextColor(getResources().getColor(R.color.text_sed));
                    tv_bChaKan.setTextColor(getResources().getColor(R.color.text_sed));
                    tv_mianShi.setTextColor(getResources().getColor(R.color.themeColor));
                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    private void initView() {

        tv_bChaKan = (TextView) findViewById(R.id.tv_bChaKan);
        tv_mianShi = (TextView) findViewById(R.id.tv_mianShi);
        tv_quanBu = (TextView) findViewById(R.id.tv_quanBu);
        viewPager = (ViewPager) findViewById(R.id.touDi_viewPager);


        tv_quanBu.setOnClickListener(this);
        tv_mianShi.setOnClickListener(this);
        tv_bChaKan.setOnClickListener(this);

    }

    private void initTitleView() {
        title_bar_textView_center = (TextView) findViewById(R.id.title_bar_textView_center);
        title_bar_textView_left = (TextView) findViewById(R.id.title_bar_textView_left);

        title_bar_textView_center.setVisibility(View.VISIBLE);
        title_bar_textView_left.setVisibility(View.VISIBLE);

        title_bar_textView_center.setText("投递情况");
        title_bar_textView_left.setText("返回");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_quanBu:
                viewPager.setCurrentItem(0);
                tv_quanBu.setTextColor(getResources().getColor(R.color.themeColor));
                tv_bChaKan.setTextColor(getResources().getColor(R.color.text_sed));
                tv_mianShi.setTextColor(getResources().getColor(R.color.text_sed));
                break;
            case R.id.tv_bChaKan:
                viewPager.setCurrentItem(1);
                tv_quanBu.setTextColor(getResources().getColor(R.color.text_sed));
                tv_bChaKan.setTextColor(getResources().getColor(R.color.themeColor));
                tv_mianShi.setTextColor(getResources().getColor(R.color.text_sed));
                break;
            case R.id.tv_mianShi:
                viewPager.setCurrentItem(2);
                tv_quanBu.setTextColor(getResources().getColor(R.color.text_sed));
                tv_bChaKan.setTextColor(getResources().getColor(R.color.text_sed));
                tv_mianShi.setTextColor(getResources().getColor(R.color.themeColor));
                break;
        }

    }
}
