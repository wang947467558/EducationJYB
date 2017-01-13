package com.example.ccjust.testfragment.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by ccJust on 2016/12/16.
 */

public class MyViewPagerAdapter extends FragmentPagerAdapter {
    private List<Fragment>list;
    public MyViewPagerAdapter(FragmentManager fm,List<Fragment>list) {
        super(fm);
        this.list=list;
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }
}
