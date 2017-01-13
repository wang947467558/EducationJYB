package com.example.ccjust.testfragment.base;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.BaseExpandableListAdapter;

import com.example.ccjust.testfragment.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangjian on 2016/12/26.
 */

public class MyBaseAdapter extends BaseAdapter {
    private List<String> list=new ArrayList<>();
    private Context context;
    private BaseHolder holder;
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        return convertView;
    }

    class BaseHolder {
    }

}
