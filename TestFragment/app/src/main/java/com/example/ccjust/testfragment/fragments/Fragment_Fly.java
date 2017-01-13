package com.example.ccjust.testfragment.fragments;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.ccjust.testfragment.MainActivity;
import com.example.ccjust.testfragment.R;
import com.example.ccjust.testfragment.adapter.Fragment_Fly_Adapter;
import com.example.ccjust.testfragment.flyactivity.IHaveASDreamActivity;
import com.example.ccjust.testfragment.utils.FloatUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.OnClick;

/**
 * Created by ccJust on 2016/12/16.
 */

public class Fragment_Fly extends Fragment implements View.OnClickListener {
//    @Nullable
//    @Override
//    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//
//        View view=inflater.inflate(R.layout.item_mianshi,container,false);
//        return view;
//    }

    private ListView listView;

    private Fragment_Fly_Adapter adapter;

    private List<String> list;

    //标题声明
    private ImageView title_bar_imageView_left;
    private TextView title_bar_textView_center;
    private TextView title_bar_textView_right;

    private LinearLayout ll_fly;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.i("TAG", "Fragment_Fly_onAttach");

        View view = inflater.inflate(R.layout.fragment_fly, container, false);

        initView(view);
        return view;
    }

    private void initFly() {
        title_bar_textView_right.setOnClickListener(this);
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            Window window = getActivity().getWindow();
//            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS | WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
//            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
//            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
//            window.setStatusBarColor(Color.TRANSPARENT);
//            return;
//        }
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
//            getActivity().getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//        }

    }

    private void initView(View view) {

        title_bar_imageView_left = (ImageView) view.findViewById(R.id.title_bar_imageView_left);
        title_bar_textView_center = (TextView) view.findViewById(R.id.title_bar_textView_center);
        title_bar_textView_right = (TextView) view.findViewById(R.id.title_bar_textView_right);



        listView = (ListView) view.findViewById(R.id.fragmentFly_listView);
        title_bar_textView_center.setVisibility(View.VISIBLE);
        title_bar_textView_right.setVisibility(View.VISIBLE);
        list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add("name");
        }
        adapter = new Fragment_Fly_Adapter(list, getActivity());
        listView.setAdapter(adapter);
        initFly();
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(getActivity(), IHaveASDreamActivity.class);
        startActivity(intent);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.i("TAG", "Fragment_Fly_onAttach");
//        FloatUtil.getInstance().gone();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.i("TAG", "Fragment_Fly_onDestroyView");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.i("TAG", "Fragment_Fly_onDetach");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i("TAG", "Fragment_Fly_onResume");

    }

    @Override
    public void onPause() {
        super.onPause();
        Log.i("TAG", "Fragment_Fly_onPause");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("TAG", "Fragment_Fly_onCreate");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.i("TAG", "Fragment_Fly_onActivityCreated");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i("TAG", "Fragment_Fly_onDestroy");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.i("TAG", "Fragment_Fly_onStart");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.i("TAG", "Fragment_Fly_onStop");
    }
}
