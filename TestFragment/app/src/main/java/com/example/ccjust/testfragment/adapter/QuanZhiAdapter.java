package com.example.ccjust.testfragment.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ccjust.testfragment.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangjian on 2016/12/22.
 */

public class QuanZhiAdapter extends BaseAdapter {

    private QuanZhiHolder holder;

    private List<String> list = new ArrayList<>();
    private Context context;

    public QuanZhiAdapter(List<String> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            holder = new QuanZhiHolder();
            view = View.inflate(context, R.layout.item_quanzhi, null);
            holder.item_quanzhi_iv_titleName1 = (ImageView) view.findViewById(R.id.item_quanzhi_iv_titleName1);
            holder.item_quanzhi_tv_titleName1 = (TextView) view.findViewById(R.id.item_quanzhi_tv_titleName1);
            holder.item_quanzhi_tv_titleName2 = (TextView) view.findViewById(R.id.item_quanzhi_tv_titleName2);
            holder.item_quanzhi_iv_titleName2 = (ImageView) view.findViewById(R.id.item_quanzhi_iv_titleName2);

            view.setTag(holder);
        } else {
            holder = (QuanZhiHolder) view.getTag();
        }
        return view;
    }

    static class QuanZhiHolder {

        private ImageView item_quanzhi_iv_titleName1;
        private ImageView item_quanzhi_iv_titleName2;
        private TextView item_quanzhi_tv_titleName1;
        private TextView item_quanzhi_tv_titleName2;
    }

}
