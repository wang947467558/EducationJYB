package com.example.ccjust.testfragment.view;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;

import com.example.ccjust.testfragment.R;

/**
 * Created by zhangjian on 2016/12/31.
 */

public class SexDialog extends AlertDialog {
    private Context context;

    public SexDialog(Context context) {
        super(context);
        this.context = context;
        this.setContentView(R.layout.dialog_sex);
    }

    public SexDialog(Context context, int themeResId) {
        super(context, themeResId);
        this.context = context;
        this.setContentView(R.layout.dialog_sex);
    }

    protected SexDialog(Context context, boolean cancelable, OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.dialog_sex);
    }
}
