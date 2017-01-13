package com.example.ccjust.testfragment.view;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;

import com.example.ccjust.testfragment.R;

/**
 * Created by zhangjian on 2016/12/31.
 */

public class MyDialog extends AlertDialog {
    private Context context;
    public MyDialog(Context context) {
        super(context);
        this.context=context;
        this.setContentView(R.layout.dialog_layout);
    }

    public MyDialog(Context context, int themeResId) {
        super(context, themeResId);
        this.context=context;
        this.setContentView(R.layout.dialog_layout);
    }

    protected MyDialog(Context context, boolean cancelable, OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.dialog_layout);
    }
}
