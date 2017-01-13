package com.example.ccjust.testfragment.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ccjust.testfragment.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangjian on 2016/12/22.
 */

public class JianZhiAdapter extends BaseAdapter {
    private List<String> list = new ArrayList<>();
    private Context context;

    private JianZhiHolder holder;

    public JianZhiAdapter(List<String> list, Context context) {
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
            holder = new JianZhiHolder();
            view = View.inflate(context, R.layout.item_jianzhi, null);
            holder.item_JianZhi_ImageView_Title = (ImageView) view.findViewById(R.id.item_JianZhi_ImageView_Title);
            holder.item_JianZhi_TextView_TitleName = (TextView) view.findViewById(R.id.item_JianZhi_TextView_TitleName);
            holder.item_JianZhi_TextView_rwNum = (TextView) view.findViewById(R.id.item_JianZhi_TextView_rwNum);
            holder.item_JianZhi_TextView_Time = (TextView) view.findViewById(R.id.item_JianZhi_TextView_Time);
            holder.item_JianZhi_TextView_Money = (TextView) view.findViewById(R.id.item_JianZhi_TextView_Money);
            view.setTag(holder);
        } else {
            holder = (JianZhiHolder) view.getTag();
        }
        return view;
    }

    static class JianZhiHolder {
        private ImageView item_JianZhi_ImageView_Title;
        private TextView item_JianZhi_TextView_TitleName;
        private TextView item_JianZhi_TextView_rwNum;
        private TextView item_JianZhi_TextView_Time;
        private TextView item_JianZhi_TextView_Money;
    }

}
