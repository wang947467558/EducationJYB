package com.example.ccjust.testfragment.fragments;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import com.example.ccjust.testfragment.MainActivity;
import com.example.ccjust.testfragment.adapter.MyViewPagerAdapter;
import com.example.ccjust.testfragment.R;
import com.example.ccjust.testfragment.adapter.AutoScrollViewPager;
import com.example.ccjust.testfragment.utils.FloatUtil;
import com.example.ccjust.testfragment.utils.Float_BianJiUtil;
import com.example.ccjust.testfragment.utils.Fonts;
import com.example.ccjust.testfragment.viewpager.CirclePageIndicator;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Administrator on 2016/1/.
 */
public class Fragment_Home extends Fragment implements View.OnClickListener {


    private TextView btn1, btn2, btn3;
    private List<Fragment> list;
    private ViewPager viewPager_content;

    //    private int[] imgs = {R.drawable.a1, R.drawable.a2, R.drawable.a3, R.drawable.a4, R.drawable.a5};
    private String[] imgs = {"http://114.55.249.252/education/images/top/banner002.jpg",
            "http://114.55.249.252/education/images/top/jiaoshizigezheng.jpg"};

    private DisplayImageOptions options = new DisplayImageOptions.Builder().cacheInMemory(true)
            .cacheOnDisk(true).imageScaleType(ImageScaleType.IN_SAMPLE_INT).build();

    private Toast toast;
    private int mine_hui;

    public Fragment_Home() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("TAG", "Fragment_home_onCreate");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.i("TAG", "Fragment_home_onCreateView");
        DisplayMetrics metrics = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(metrics);
        int width = metrics.widthPixels;
        int height = metrics.heightPixels;
        Log.i("TAG", width + "");
        Log.i("TAG", height + "");
        FloatUtil.getInstance().createFloatView(getActivity());
        Float_BianJiUtil.getInstance().createFloatView(getActivity(), width, height);
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        init(view);
        return view;
    }


    private void init(final View view) {

        btn1 = (TextView) view.findViewById(R.id.btn1);
        btn2 = (TextView) view.findViewById(R.id.btn2);
        btn3 = (TextView) view.findViewById(R.id.btn3);
        viewPager_content = (ViewPager) view.findViewById(R.id.myViewPager_content);
        list = new ArrayList<>();
        list.add(new Fragment_School());
        list.add(new Fragment_Job());
        list.add(new Fragment_Activity());
        FragmentManager manager = getChildFragmentManager();
        MyViewPagerAdapter adapter = new MyViewPagerAdapter(manager, list);
        viewPager_content.setAdapter(adapter);

        viewPager_content.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                if (position == 0) {
                    Float_BianJiUtil.getInstance().visibility();
                    btn1.setTextColor(getResources().getColor(R.color.themeColor));
                    btn2.setTextColor(getResources().getColor(R.color.text_sed));
                    btn3.setTextColor(getResources().getColor(R.color.text_sed));
                } else if (position == 1) {
                    Float_BianJiUtil.getInstance().gone();
                    btn2.setTextColor(getResources().getColor(R.color.themeColor));
                    btn1.setTextColor(getResources().getColor(R.color.text_sed));
                    btn3.setTextColor(getResources().getColor(R.color.text_sed));
                } else if (position == 2) {
                    Float_BianJiUtil.getInstance().gone();
                    btn3.setTextColor(getResources().getColor(R.color.themeColor));
                    btn2.setTextColor(getResources().getColor(R.color.text_sed));
                    btn1.setTextColor(getResources().getColor(R.color.text_sed));
                } else {
                    Float_BianJiUtil.getInstance().gone();
                    btn2.setTextColor(getResources().getColor(R.color.text_sed));
                    btn1.setTextColor(getResources().getColor(R.color.text_sed));
                    btn3.setTextColor(getResources().getColor(R.color.text_sed));
                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        viewPager_content.setCurrentItem(0);
        view.findViewById(R.id.btn1).setOnClickListener(this);
        view.findViewById(R.id.btn2).setOnClickListener(this);
        view.findViewById(R.id.btn3).setOnClickListener(this);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        AutoScrollViewPager pager = (AutoScrollViewPager) getView().findViewById(R.id.scroll_pager);
        CirclePageIndicator indicator = (CirclePageIndicator) getView().findViewById(R.id.indicator);

        indicator.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {

            @Override
            public void onPageSelected(int i) {
            }
        });

        pager.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                return imgs.length;
            }

            @Override
            public boolean isViewFromObject(View view, Object o) {
                return view == o;
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                ImageView view = new ImageView(container.getContext());
                view.setScaleType(ImageView.ScaleType.CENTER_CROP);
                ImageLoader.getInstance().displayImage(imgs[position], view, options);
//                ImageView view = new ImageView(container.getContext());
//                view.setBackgroundResource(imgs[position]);
                container.addView(view);

                return view;
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView((View) object);
            }
        });

        indicator.setViewPager(pager);
        indicator.setSnap(true);

        pager.setScrollFactgor(5);
        pager.setOffscreenPageLimit(mine_hui);
        pager.startAutoScroll(2000);
        pager.setOnPageClickListener(new AutoScrollViewPager.OnPageClickListener() {
            @Override
            public void onPageClick(AutoScrollViewPager autoScrollPager, int position) {
                if (toast != null) {
                    toast.cancel();
                }
                toast = Toast.makeText(getActivity(), "You clicked page: " + (position + 1),
                        Toast.LENGTH_SHORT);
                toast.show();
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn1:
                viewPager_content.setCurrentItem(0);
                Float_BianJiUtil.getInstance().visibility();
                btn1.setTextColor(getResources().getColor(R.color.themeColor));
                btn2.setTextColor(getResources().getColor(R.color.text_sed));
                btn3.setTextColor(getResources().getColor(R.color.text_sed));
                break;
            case R.id.btn2:
                viewPager_content.setCurrentItem(1);
                Float_BianJiUtil.getInstance().gone();
                btn2.setTextColor(getResources().getColor(R.color.themeColor));
                btn1.setTextColor(getResources().getColor(R.color.text_sed));
                btn3.setTextColor(getResources().getColor(R.color.text_sed));
                break;
            case R.id.btn3:
                viewPager_content.setCurrentItem(2);
                Float_BianJiUtil.getInstance().gone();
                btn3.setTextColor(getResources().getColor(R.color.themeColor));
                btn2.setTextColor(getResources().getColor(R.color.text_sed));
                btn1.setTextColor(getResources().getColor(R.color.text_sed));
                break;
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.i("TAG", "Fragment_home_onPause");
        FloatUtil.getInstance().gone();
        Float_BianJiUtil.getInstance().gone();
    }

    @Override
    public void onResume() {
        super.onResume();
        viewPager_content.setCurrentItem(0);
        Log.i("TAG", "Fragment_home_onResume");
        FloatUtil.getInstance().visibility();
        Float_BianJiUtil.getInstance().visibility();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i("TAG", "Fragment_home_onDestroy");
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.i("TAG", "Fragment_home_onAttach");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.i("TAG", "Fragment_home_onActivityCreated");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.i("TAG", "Fragment_home_onDetach");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.i("TAG", "Fragment_home_onDestroyView");
        FloatUtil.getInstance().gone();
        Float_BianJiUtil.getInstance().gone();

    }

    @Override
    public void onStart() {
        super.onStart();
        Log.i("TAG", "Fragment_home_onStart");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.i("TAG", "Fragment_home_onStop");
    }
}
