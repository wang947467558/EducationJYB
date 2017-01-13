package com.example.ccjust.testfragment.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ccjust.testfragment.R;

/**
 * Created by ccJust on 2016/12/16.
 */

public class Fragment_Hunter extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.item_mianshi,container,false);

        return view;

    }
}
