package com.example.ccjust.testfragment.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.ccjust.testfragment.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangjian on 2016/12/26.
 */

public class XiaoXiAdapter extends BaseAdapter {

    private List<String> list = new ArrayList<>();
    private Context context;
    private XiaoXiHolder holder;

    public XiaoXiAdapter(List<String> list, Context context) {
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
            holder = new XiaoXiHolder();
            convertView = View.inflate(context, R.layout.item_xiaoxi, null);
            convertView.setTag(holder);
        } else {
            holder = (XiaoXiHolder) convertView.getTag();
        }
        return convertView;
    }

    static class XiaoXiHolder {
    }

    private TextView textView;
}
