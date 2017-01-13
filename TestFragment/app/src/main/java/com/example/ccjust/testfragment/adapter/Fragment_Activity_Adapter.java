package com.example.ccjust.testfragment.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.example.ccjust.testfragment.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangjian on 2016/12/20.
 */

public class Fragment_Activity_Adapter extends BaseAdapter {
    private List<String> list = new ArrayList<>();
    private Context context;

    public Fragment_Activity_Adapter(List<String> list, Context context) {
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

        Myholder myholder = null;
        if (view == null) {
            myholder = new Myholder();
            view = View.inflate(context, R.layout.item_activity, null);
            myholder.item_activity_imageview1 = (ImageView) view.findViewById(R.id.item_activity_imageview1);
            myholder.item_activity_imageview2 = (ImageView) view.findViewById(R.id.item_activity_imageview2);

            view.setTag(myholder);
        } else {
            myholder = (Myholder) view.getTag();
        }
        return view;
    }

    static class Myholder {
        private ImageView item_activity_imageview1;
        private ImageView item_activity_imageview2;
    }

}
