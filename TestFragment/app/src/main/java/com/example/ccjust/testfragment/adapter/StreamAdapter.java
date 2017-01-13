package com.example.ccjust.testfragment.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.ccjust.testfragment.R;

import java.security.PrivateKey;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangjian on 2016/12/26.
 */

public class StreamAdapter extends BaseAdapter {
    private List<String> list = new ArrayList<>();
    private Context context;
    private StreamHolder holder;

    public StreamAdapter(List<String> list, Context context) {
        this.list = list;
        this.context = context;
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
            holder = new StreamHolder();
            convertView = View.inflate(context, R.layout.item_stream, null);
            convertView.setTag(holder);
        } else {
            holder = (StreamHolder) convertView.getTag();
        }
        return convertView;
    }

    static class StreamHolder {
    }

}
