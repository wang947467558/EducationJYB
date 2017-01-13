package com.example.ccjust.testfragment.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ccjust.testfragment.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangjian on 2016/12/20.
 */

public class Fragment_Job_Adapter extends BaseAdapter implements View.OnClickListener {
    private List<String> list = new ArrayList<>();
    private Context context;

    private MyHolder myHolder;
private boolean flag=true;
    public Fragment_Job_Adapter(List<String> list, Context context) {
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
            myHolder = new MyHolder();
            view = View.inflate(context, R.layout.item_job, null);
            myHolder.item_job_imageview_title = (ImageView) view.findViewById(R.id.item_job_imageview_title);
            myHolder.item_job_imageview_zan = (ImageView) view.findViewById(R.id.item_job_imageview_zan);
            myHolder.item_job_textview_content = (TextView) view.findViewById(R.id.myViewPager_content);
            myHolder.item_job_textview_title = (TextView) view.findViewById(R.id.item_job_textview_title);
            myHolder.item_job_textview_hours = (TextView) view.findViewById(R.id.item_job_textview_hours);
            myHolder.item_job_textview_yudu = (TextView) view.findViewById(R.id.item_job_textview_yudu);
            myHolder.item_job_textview_zan = (TextView) view.findViewById(R.id.item_job_textview_zan);
            view.setTag(myHolder);
        } else {
            myHolder = (MyHolder) view.getTag();
        }
        myHolder.item_job_imageview_zan.setTag(i);
        myHolder.item_job_textview_zan.setTag(i);
        myHolder.item_job_imageview_zan.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.item_job_imageview_zan:
                if (flag) {
                    Toast.makeText(context, "fdf", Toast.LENGTH_SHORT).show();
                    myHolder.item_job_imageview_zan.setImageResource(R.drawable.zan_hou);
                    myHolder.item_job_textview_zan.setText("已赞");
                    myHolder.item_job_textview_zan.setTextColor(context.getResources().getColor(R.color.themeColor));
                    flag = false;
                } else {
                    myHolder.item_job_imageview_zan.setImageResource(R.drawable.zan_qj);
                    myHolder.item_job_textview_zan.setText("赞");
                    myHolder.item_job_textview_zan.setTextColor(context.getResources().getColor(R.color.text_sed));
                    flag=true;
                }
                break;
        }

    }

    static class MyHolder {
        private ImageView item_job_imageview_title;
        private ImageView item_job_imageview_zan;
        private TextView item_job_textview_title;
        private TextView item_job_textview_content;
        private TextView item_job_textview_hours;
        private TextView item_job_textview_yudu;
        private TextView item_job_textview_zan;


    }

}
