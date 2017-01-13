package com.example.ccjust.testfragment.view;

import android.content.Context;
import android.support.v7.app.AlertDialog;

import com.example.ccjust.testfragment.R;

/**
 * Created by zhangjian on 2017/1/13.
 */

public class HunterDialog extends AlertDialog {
    private Context context;
    protected HunterDialog(Context context) {
        super(context);
        this.context=context;
        setContentView(R.layout.dialog_hunter);


    }

    protected HunterDialog(Context context, int theme) {
        super(context, theme);
        this.context=context;
        setContentView(R.layout.dialog_hunter);
    }

    protected HunterDialog(Context context, boolean cancelable, OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
        this.context=context;
        setContentView(R.layout.dialog_hunter);
    }
}
