package com.example.ccjust.testfragment.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.ccjust.testfragment.R;
import com.example.ccjust.testfragment.adapter.Fragment_BeiChaKan_Adapter;
import com.example.ccjust.testfragment.adapter.Fragment_MianShi_Adapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangjian on 2016/12/27.
 */

public class Fragment_MianShi extends Fragment {
    private List<String> list;
    private ListView listView;
    private Fragment_MianShi_Adapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_mianshi, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        listView = (ListView) view.findViewById(R.id.mianShi_listView);

        list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add("name");
        }
        adapter = new Fragment_MianShi_Adapter(list, getActivity());
        listView.setAdapter(adapter);
    }
}
