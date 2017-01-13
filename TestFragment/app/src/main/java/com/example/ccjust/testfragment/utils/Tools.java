package com.example.ccjust.testfragment.utils;

import android.os.Environment;

/**
 * Created by zhangjian on 2016/12/19.
 */

public class Tools {
    /**
     * 检查是否存在SDCard
     * @return
     */
    public static boolean hasSdcard(){
        String state = Environment.getExternalStorageState();
        if(state.equals(Environment.MEDIA_MOUNTED)){
            return true;
        }else{
            return false;
        }
    }
}
