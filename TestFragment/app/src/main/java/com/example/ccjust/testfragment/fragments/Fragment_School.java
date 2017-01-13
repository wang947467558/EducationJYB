package com.example.ccjust.testfragment.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.ccjust.testfragment.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ccJust on 2016/12/16.
 */

public class Fragment_School extends Fragment {
    private List<String> list;
    private ListView mListView;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_school, container, false);
        init(view);
        return view;
    }


    private void init(View view) {
        mListView = (ListView) view.findViewById(R.id.listview);
        list = new ArrayList();
//        for(int i=0;i<20;i++){
//            String str="我是第"+i+"个条目";
//            list.add(str);
//        }
        for (int i = 0; i < 20; i++) {
            String name = "王修月";
            list.add(name);
        }
        MyListViewAdapter adapter = new MyListViewAdapter(list, getActivity());
        mListView.setAdapter(adapter);
        mListView.deferNotifyDataSetChanged();
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.i("TAG","onItemClick");
//                Toast.makeText(getActivity(),i+"",Toast.LENGTH_SHORT).show();
//                Toast.makeText(getActivity(), "被点了", Toast.LENGTH_SHORT).show();
//                switch (i) {
//                    case R.id.item_job_imageview_title:
//                        Toast.makeText(getActivity(), "这是个人用户头像", Toast.LENGTH_SHORT).show();
//                        break;
//                    case R.id.item_shcool_textview_username:
//                        break;
//                    case R.id.item_school_teztview_shcoolname:
//                        break;
//                    case R.id.item_shcool_imageview_content1:
//                        break;
//                    case R.id.item_shcool_imageview_content2:
//                        break;
//                    case R.id.item_shcool_imageview_content3:
//                        break;
//                    case R.id.item_shcool_textview_dianzan:
//                        break;
//                    case R.id.item_shcool_textview_pinglun:
//                        break;
//                    case R.id.item_textview_dashang:
//                        break;
//                    case R.id.item_shcool_edittext_pinglun:
//                        break;
//                }
            }

        });
    }

    private void onClick(int i) {


    }


}
