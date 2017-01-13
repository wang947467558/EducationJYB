package com.example.ccjust.testfragment.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ccjust.testfragment.R;

import java.security.PrivateKey;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangjian on 2016/12/21.
 */

public class Fragment_Fly_Adapter extends BaseAdapter {
    private List<String> list = new ArrayList<>();
    private Context context;
    FragmentFly_Myholder flyHolder;

    public Fragment_Fly_Adapter(List<String> list, Context context) {
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
            flyHolder = new FragmentFly_Myholder();
            view = View.inflate(context, R.layout.item_fly, null);
            flyHolder.item_fly_imageView_titlePhoto = (ImageView) view.findViewById(R.id.item_fly_imageView_titlePhoto);
            flyHolder.item_fly_textView_titleName = (TextView) view.findViewById(R.id.item_fly_textView_titleName);
            flyHolder.item_fly_textView_mxContent = (TextView) view.findViewById(R.id.iten_fly_textView_mxContent);
            flyHolder.item_fly_textView_xqContent = (TextView) view.findViewById(R.id.iten_fly_textView_xqContent);
            flyHolder.item_fly_imageView_speech = (ImageView) view.findViewById(R.id.item_fly_imageView_speech);
            flyHolder.item_fly_textView_place = (TextView) view.findViewById(R.id.item_fly_textView_place);
            flyHolder.item_fly_textView_audience = (TextView) view.findViewById(R.id.item_fly_textView_audience);
            flyHolder.item_fly_textView_capital = (TextView) view.findViewById(R.id.item_fly_textView_capital);
            flyHolder.item_fly_textView_sound = (TextView) view.findViewById(R.id.item_fly_textView_sound);
            view.setTag(flyHolder);
        } else {
            flyHolder = (FragmentFly_Myholder) view.getTag();
        }


        return view;
    }

    static class FragmentFly_Myholder {

        private ImageView item_fly_imageView_titlePhoto;
        private TextView item_fly_textView_titleName;
        private TextView item_fly_textView_mxContent;
        private TextView item_fly_textView_xqContent;
        private ImageView item_fly_imageView_speech;
        private TextView item_fly_textView_place;
        private TextView item_fly_textView_audience;
        private TextView item_fly_textView_capital;
        private TextView item_fly_textView_sound;

    }

}
