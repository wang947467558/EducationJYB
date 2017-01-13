package com.example.ccjust.testfragment.hunteractivity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ccjust.testfragment.R;
import com.example.ccjust.testfragment.adapter.QuanZhiAdapter;
import com.example.ccjust.testfragment.fragments.Fragment_Select;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class QuanZhiActivity extends AppCompatActivity implements View.OnClickListener, DrawerLayout.DrawerListener {

    private List<String> list;
    private QuanZhiAdapter adapter;
    private ListView listView;
    private android.widget.SearchView searchView;
    private LinearLayout shaixuan_ll;
    ArrayAdapter arrayAdapter;
    private TextView tv_select;
    private DrawerLayout drawerLayout;
    private TextView tv_search;

    private TextView sxSex_tv_unlimited;
    private TextView sxSex_tv_woman;
    private TextView sxSex_tv_man;
    private String newsText;

    private TextView title_tv_cancel;
    private TextView title_tv_comfirm;


    @OnClick(R.id.iv_back)
    void back() {
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quan_zhi);
        ButterKnife.bind(this);
        initView();

    }

    private void initView() {
        listView = (ListView) findViewById(R.id.quanZhi_listView);

//        searchView = (android.widget.SearchView) findViewById(R.id.search);

        drawerLayout = (DrawerLayout) findViewById(R.id.activity_quan_zhi);


        tv_select = (TextView) findViewById(R.id.tv_select);

        shaixuan_ll = (LinearLayout) findViewById(R.id.shaixun_ll);

        tv_search = (TextView) findViewById(R.id.tv_search);

        sxSex_tv_unlimited = (TextView) findViewById(R.id.sxSex_tv_unlimited);
        sxSex_tv_woman = (TextView) findViewById(R.id.sxSex_tv_woman);
        sxSex_tv_man = (TextView) findViewById(R.id.sxSex_tv_man);

        title_tv_cancel = (TextView) findViewById(R.id.tv_cancel);
        title_tv_comfirm = (TextView) findViewById(R.id.comfire);

        sxSex_tv_unlimited.setOnClickListener(this);
        sxSex_tv_woman.setOnClickListener(this);
        sxSex_tv_man.setOnClickListener(this);

        title_tv_comfirm.setOnClickListener(this);
        title_tv_cancel.setOnClickListener(this);
        tv_search.setOnClickListener(this);
        drawerLayout.setDrawerListener(this);


        list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add("name");
            list.add("age");
        }
        adapter = new QuanZhiAdapter(list, this);
        listView.setAdapter(adapter);
//        searchView.setOnSearchClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(QuanZhiActivity.this, "onSearchClickListtener", Toast.LENGTH_SHORT).show();
//            }
//        });
//        searchView.setOnQueryTextListener(new android.widget.SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(final String query) {
//                return true;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String newText) {
//                if (newText.length() != 0) {
//                    setFilterText(newText);
//                } else {
//                    clearTextFilter();
//                }
//                return false;
//            }
//
//        });

        tv_select.setOnClickListener(this);

    }

//    private void clearTextFilter() {
//        adapter = new QuanZhiAdapter(list, this);
//        listView.setAdapter(adapter);
//    }
//
//    private void setFilterText(String newText) {
//        List<String> list1 = new ArrayList<String>();
//        for (int i = 0; i < list.size(); i++) {
//            if (list.get(i).contains(newText)) {
//                list1.add(list.get(i));
//            }
//        }
//        if (list1.size() > 0) {
//
//            arrayAdapter = new ArrayAdapter(QuanZhiActivity.this, android.R.layout.simple_expandable_list_item_1, list1);
//
//            listView.setAdapter(arrayAdapter);
//        }
//    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.tv_select:

                if (!drawerLayout.isDrawerOpen(shaixuan_ll)) {
                    drawerLayout.openDrawer(shaixuan_ll);
                }
                break;

            case R.id.sxSex_tv_unlimited:

                break;
            case R.id.sxSex_tv_man:
                break;
            case R.id.sxSex_tv_woman:
                break;

            case R.id.tv_cancel:
                Toast.makeText(this, "取消了", Toast.LENGTH_SHORT).show();
                drawerLayout.closeDrawer(shaixuan_ll);
                break;
            case R.id.comfire:
                Toast.makeText(this, "确认了", Toast.LENGTH_SHORT).show();
                drawerLayout.closeDrawer(shaixuan_ll);
                break;

            case R.id.tv_search:
                Toast.makeText(this, "还未完善，敬请期待", Toast.LENGTH_SHORT).show();
                break;

        }

    }


    @Override
    public void onDrawerSlide(View drawerView, float slideOffset) {

    }

    @Override
    public void onDrawerOpened(View drawerView) {
        drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);

    }

    @Override
    public void onDrawerClosed(View drawerView) {

    }

    @Override
    public void onDrawerStateChanged(int newState) {

    }
}


