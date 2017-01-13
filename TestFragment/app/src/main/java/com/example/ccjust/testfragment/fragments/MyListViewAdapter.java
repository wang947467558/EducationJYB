package com.example.ccjust.testfragment.fragments;

import android.content.ClipData;
import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ccjust.testfragment.R;
import com.example.ccjust.testfragment.utils.Float_BianJiUtil;

import java.lang.annotation.Annotation;
import java.util.List;

import butterknife.OnClick;

import static android.content.Context.INPUT_METHOD_SERVICE;

/**
 * Created by ccJust on 2016/12/16.
 */

public class MyListViewAdapter extends BaseAdapter implements View.OnClickListener {
    private List<String> list;
    private Context context;
    MyHolder holder;
    private LinearLayout linearLayout;


    public MyListViewAdapter(List<String> list, Context context) {
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
//        MyHolder holder = null;
        //view为空则赋值，否则直接加载
        if (view == null) {
            holder = new MyHolder();
            view = View.inflate(context, R.layout.item_school, null);
            //初始化控件
//            linearLayout = (LinearLayout) view.findViewById(R.id.ll_dibu);
            holder.item_shcool_imageview_title = (ImageView) view.findViewById(R.id.item_school_imageview_title);
            holder.item_shcool_textview_username = (TextView) view.findViewById(R.id.item_shcool_textview_username);
            holder.item_shcool_textview_shcoolname = (TextView) view.findViewById(R.id.item_school_textview_shcoolname);
            holder.item_shcool_imageview_content1 = (ImageView) view.findViewById(R.id.item_shcool_imageview_content1);
            holder.item_school_imageview_content2 = (ImageView) view.findViewById(R.id.item_shcool_imageview_content2);
            holder.item_shcool_imageview_content3 = (ImageView) view.findViewById(R.id.item_shcool_imageview_content3);
            holder.item_shcool_textview_dianzan = (TextView) view.findViewById(R.id.item_shcool_textview_dianzan);
            holder.item_shcool_textview_pinglun = (TextView) view.findViewById(R.id.item_shcool_textview_pinglun);
            holder.item_shcool_textview_dashang = (TextView) view.findViewById(R.id.item_textview_dashang);
            holder.item_shcool_edittext_pinglun = (EditText) view.findViewById(R.id.item_shcool_edittext_pinglun);
            holder.item_shcool_button_send = (TextView) view.findViewById(R.id.item_shcool_button_send);
            holder.item_shcool_textview_pingjiacontent = (TextView) view.findViewById(R.id.item_school_textview_pingjiacontent);
            holder.item_shcool_textview_pinglunname = (TextView) view.findViewById(R.id.item_shcool_textview_pinglunname);
            view.setTag(holder);
        } else {
            holder = (MyHolder) view.getTag();
        }

        //给控件设置监听
        holder.item_shcool_imageview_title.setOnClickListener(this);
        holder.item_shcool_textview_username.setOnClickListener(this);
        holder.item_shcool_textview_shcoolname.setOnClickListener(this);
        holder.item_shcool_imageview_content1.setOnClickListener(this);
        holder.item_school_imageview_content2.setOnClickListener(this);
        holder.item_shcool_imageview_content3.setOnClickListener(this);
        holder.item_shcool_textview_dianzan.setOnClickListener(this);
        holder.item_shcool_textview_pinglun.setOnClickListener(this);
        holder.item_shcool_textview_dashang.setOnClickListener(this);
        holder.item_shcool_button_send.setOnClickListener(this);
        //给控件设置焦点
        holder.item_shcool_imageview_title.setTag(i);
        holder.item_shcool_textview_username.setTag(i);
        holder.item_shcool_textview_shcoolname.setTag(i);
        holder.item_shcool_imageview_content1.setTag(i);
        holder.item_school_imageview_content2.setTag(i);
        holder.item_shcool_imageview_content3.setTag(i);
        holder.item_shcool_textview_dianzan.setTag(i);
        holder.item_shcool_textview_dashang.setTag(i);
        holder.item_shcool_button_send.setTag(i);
        holder.item_shcool_edittext_pinglun.setTag(i);
        holder.item_shcool_edittext_pinglun.requestFocus(i);

//        //点击键盘的回车键 等同于登录或发送
//        holder.item_shcool_edittext_pinglun.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//                Toast.makeText(context, "beforeTextChanged" + s, Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//                Toast.makeText(context, "onTextChanged" + s, Toast.LENGTH_SHORT).show();
//
//            }
//
//            @Override
//            public void afterTextChanged(Editable s) {
//                Toast.makeText(context, "afterTextChanged" + s, Toast.LENGTH_SHORT).show();
//                holder.item_shcool_textview_pingjiacontent.setText(s);
//            }
//        });

        return view;
    }


    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.item_school_imageview_title:
                Log.e("TAG", "item_job_imageview_title");

                Toast.makeText(context, "imageview_title", Toast.LENGTH_SHORT).show();
                break;
            case R.id.item_shcool_textview_username:
                Log.e("TAG", "item_job_textivew_username");
                Toast.makeText(context, "textview_username", Toast.LENGTH_SHORT).show();
                break;
            case R.id.item_school_textview_shcoolname:
                Log.e("TAG", "item_job_textview_shcoolname");
                Toast.makeText(context, "textivew_shcoolname", Toast.LENGTH_SHORT).show();
                break;
            case R.id.item_shcool_imageview_content1:
                Log.e("TAG", "item_job_imageview_content1");
                Toast.makeText(context, "imageview_content1", Toast.LENGTH_SHORT).show();
                break;
            case R.id.item_shcool_imageview_content2:
                Log.e("TAG", "item_job_imageview_content2");
                Toast.makeText(context, "imageview_content2", Toast.LENGTH_SHORT).show();
                break;
            case R.id.item_shcool_imageview_content3:
                Log.e("TAG", "item_job_imageview_content3");
                Toast.makeText(context, "imageview_content3", Toast.LENGTH_SHORT).show();
                break;
            case R.id.item_shcool_textview_dianzan:
                Log.e("TAG", "item_job_textivew_dianzan");
                Toast.makeText(context, "textview_dianzan", Toast.LENGTH_SHORT).show();
                break;
            case R.id.item_shcool_textview_pinglun:
                Log.e("TAG", "item_job_textview_pinglun");
                Toast.makeText(context, "textview_pinglun", Toast.LENGTH_SHORT).show();
                break;
            case R.id.item_textview_dashang:
                Log.e("TAG", "item_job_textview_dashang");
                Toast.makeText(context, "textview_dashang", Toast.LENGTH_SHORT).show();
                break;
            case R.id.item_shcool_button_send:
                Log.e("TAG", "item_shcool_button_send");
                Toast.makeText(context, "button_send", Toast.LENGTH_SHORT).show();
                sendComment();
                break;

        }

    }

    private void sendComment() {
        boolean equals = holder.item_shcool_edittext_pinglun.getText().toString().equals("");
        Log.i("TAG", equals + "");

        if (false) {
            Toast.makeText(context, "评论不能为空！", Toast.LENGTH_SHORT).show();
        } else {
            // 生成评论数据
//            Comment comment = new Comment();
//            comment.setName("评论者" + (data.size() + 1) + "：");
//            comment.setContent(comment_content.getText().toString());
//            adapterComment.addComment(comment);
            holder.item_shcool_textview_pingjiacontent.setText(holder.item_shcool_edittext_pinglun.getText().toString());
            holder.item_shcool_textview_pinglunname.setText(holder.item_shcool_textview_username.getText().toString());
//            notifyDataSetChanged();
            // 发送完，清空输入框
            holder.item_shcool_edittext_pinglun.setText("");


            Toast.makeText(context, "评论成功！", Toast.LENGTH_SHORT).show();
        }


    }


    static class MyHolder {
        //声明控件
        private ImageView item_shcool_imageview_title;
        private TextView item_shcool_textview_username;
        private TextView item_shcool_textview_shcoolname;
        private ImageView item_shcool_imageview_content1;
        private ImageView item_school_imageview_content2;
        private ImageView item_shcool_imageview_content3;
        private TextView item_shcool_textview_dianzan;
        private TextView item_shcool_textview_pinglun;
        private TextView item_shcool_textview_dashang;
        private EditText item_shcool_edittext_pinglun;
        private TextView item_shcool_button_send;
        private TextView item_shcool_textview_pingjiacontent;
        private TextView item_shcool_textview_pinglunname;

    }
}
