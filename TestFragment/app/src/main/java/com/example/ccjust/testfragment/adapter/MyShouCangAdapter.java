package com.example.ccjust.testfragment.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.ccjust.testfragment.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangjian on 2016/12/27.
 */

public class MyShouCangAdapter extends BaseAdapter {

    private Context context;
    private List<String> list = new ArrayList<>();
    private MyShouCangHolder holder;

    public MyShouCangAdapter(Context context, List<String> list) {
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
            holder = new MyShouCangHolder();
            convertView = View.inflate(context, R.layout.item_shoucang, null);
            convertView.setTag(holder);
        } else {
            holder = (MyShouCangHolder) convertView.getTag();
        }


        return convertView;
    }

    class MyShouCangHolder {
    }

}
