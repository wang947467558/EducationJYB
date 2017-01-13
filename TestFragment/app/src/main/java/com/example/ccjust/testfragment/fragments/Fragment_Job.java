package com.example.ccjust.testfragment.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.ccjust.testfragment.R;
import com.example.ccjust.testfragment.adapter.Fragment_Job_Adapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangjian on 2016/12/16.
 */

public class Fragment_Job extends Fragment {

    private List<String> list = new ArrayList<>();
    private Fragment_Job_Adapter adapter;
    private ListView listView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_job, container, false);
        initView(view);

        return view;
    }

    private void initView(View view) {
        listView = (ListView) view.findViewById(R.id.Fragmentjob_listView);

        for (int i = 0; i < 20; i++) {
            list.add("name");
        }

        adapter = new Fragment_Job_Adapter(list, getActivity());

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String s = parent.getItemAtPosition(position).toString();
                Toast.makeText(getContext(), s, Toast.LENGTH_SHORT).show();
            }
        });

    }
}
