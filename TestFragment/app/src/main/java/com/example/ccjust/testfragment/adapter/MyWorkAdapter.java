package com.example.ccjust.testfragment.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.ccjust.testfragment.R;
import com.example.ccjust.testfragment.base.MyBaseAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangjian on 2016/12/26.
 */

public class MyWorkAdapter extends BaseAdapter {
    private Context context;
    private List<String> list = new ArrayList<>();
    private MyWorkHolder holder;

    public MyWorkAdapter(Context context, List<String> list) {
        this.context = context;
        this.list = list;
    }

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
        if (convertView == null) {
            holder = new MyWorkHolder();
            convertView = View.inflate(context, R.layout.item_mywork, null);
            convertView.setTag(holder);
        } else {
            holder = (MyWorkHolder) convertView.getTag();
        }


        return convertView;
    }

    class MyWorkHolder {
    }


}
