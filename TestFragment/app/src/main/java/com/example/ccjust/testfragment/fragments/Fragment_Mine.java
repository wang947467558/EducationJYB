package com.example.ccjust.testfragment.fragments;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ccjust.testfragment.R;
import com.example.ccjust.testfragment.activity.LoginActivity;
import com.example.ccjust.testfragment.activity.MyJianLiActivity;
import com.example.ccjust.testfragment.activity.MyQiYeActivity;
import com.example.ccjust.testfragment.activity.MyShouCangActivity;
import com.example.ccjust.testfragment.activity.MyStreamActivity;
import com.example.ccjust.testfragment.activity.MyWordActivity;
import com.example.ccjust.testfragment.activity.MyZhaoPingActivity;
import com.example.ccjust.testfragment.activity.MyZiChanActivity;
import com.example.ccjust.testfragment.activity.SettingActivity;
import com.example.ccjust.testfragment.activity.TouDiActivity;
import com.example.ccjust.testfragment.activity.XiaoXiActivity;
import com.example.ccjust.testfragment.activity.YQYouLiActivity;
import com.example.ccjust.testfragment.touxiangview.CircleImageView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import actionsheetdialog.ActionSheetDialog;

import com.example.ccjust.testfragment.utils.CacheUtils;

/**
 * Created by ccJust on 2016/12/16.
 */

public class Fragment_Mine extends Fragment implements View.OnClickListener {

    private ImageView fragmentMine_title_xiaoXi;

    private TextView fragmentMine_MyStream;
    private TextView fragmentMine_MyWork;
    private TextView fragmentMine_MyShouCang;
    private TextView fragmentMine_MyJianLi;
    private TextView fragmentMine_touDi;
    private TextView fragmentMine_MyZiChan;
    private TextView fragmentMine_yaoQing;
    private TextView fragmentMine_MyQiYe;
    private TextView fragmentMine_MyZhaoPing;
    private TextView fragmentMine_setting;

    private CircleImageView touXiang_iv;
    private String imgPath, dateTime;
    private static final String fileName = "temp.jpg";
    private File tempFile;


    private Dialog dialog;


    private boolean isLogin = false;


    Bitmap bitmap;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mine, container, false);
        initView(view);
        return view;
    }


    private void initView(View view) {
        fragmentMine_title_xiaoXi = (ImageView) view.findViewById(R.id.fragmentMine_title_xiaoXi);
        fragmentMine_MyStream = (TextView) view.findViewById(R.id.fragmentMine_MyStream);
        fragmentMine_MyWork = (TextView) view.findViewById(R.id.fragmentMine_MyWork);
        fragmentMine_MyShouCang = (TextView) view.findViewById(R.id.fragmentMine_MyShouCang);
        fragmentMine_MyJianLi = (TextView) view.findViewById(R.id.FragmentMine_MyJianLi);
        fragmentMine_touDi = (TextView) view.findViewById(R.id.fragmentMine_touDi);
        fragmentMine_MyZiChan = (TextView) view.findViewById(R.id.fragmentMine_MyZiChan);
        fragmentMine_yaoQing = (TextView) view.findViewById(R.id.fragmentMine_yaoQing);
        fragmentMine_MyQiYe = (TextView) view.findViewById(R.id.fragmentMine_MyQiYe);
        fragmentMine_MyZhaoPing = (TextView) view.findViewById(R.id.fragmentMine_MyZhaoPing);
        fragmentMine_setting = (TextView) view.findViewById(R.id.fragmentMine_setting);
        //头像初始化
        touXiang_iv = (CircleImageView) view.findViewById(R.id.touXiang_iv);


        //设置点击头像监听
        touXiang_iv.setOnClickListener(this);
        fragmentMine_title_xiaoXi.setOnClickListener(this);
        fragmentMine_MyStream.setOnClickListener(this);
        fragmentMine_MyWork.setOnClickListener(this);
        fragmentMine_MyShouCang.setOnClickListener(this);
        fragmentMine_MyJianLi.setOnClickListener(this);
        fragmentMine_touDi.setOnClickListener(this);
        fragmentMine_MyZiChan.setOnClickListener(this);
        fragmentMine_yaoQing.setOnClickListener(this);
        fragmentMine_MyQiYe.setOnClickListener(this);
        fragmentMine_MyZhaoPing.setOnClickListener(this);
        fragmentMine_setting.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fragmentMine_title_xiaoXi:
                startActivity(new Intent(getActivity(), XiaoXiActivity.class));
                break;
            case R.id.fragmentMine_MyStream:
                startActivity(new Intent(getActivity(), MyStreamActivity.class));
                break;
            case R.id.fragmentMine_MyWork:
                startActivity(new Intent(getActivity(), MyWordActivity.class));
                break;
            case R.id.fragmentMine_MyShouCang:
                startActivity(new Intent(getActivity(), MyShouCangActivity.class));
                break;
            case R.id.FragmentMine_MyJianLi:
                startActivity(new Intent(getActivity(), MyJianLiActivity.class));
                break;
            case R.id.fragmentMine_touDi:
                startActivity(new Intent(getActivity(), TouDiActivity.class));
                break;
            case R.id.fragmentMine_MyZiChan:
                startActivity(new Intent(getActivity(), MyZiChanActivity.class));
                break;
            case R.id.fragmentMine_yaoQing:
                startActivity(new Intent(getActivity(), YQYouLiActivity.class));
                break;
            case R.id.fragmentMine_MyQiYe:
                startActivity(new Intent(getActivity(), MyQiYeActivity.class));
                break;
            case R.id.fragmentMine_MyZhaoPing:
                startActivity(new Intent(getActivity(), MyZhaoPingActivity.class));
                break;
            case R.id.fragmentMine_setting:
                startActivity(new Intent(getActivity(), SettingActivity.class));
                break;
            //头像
            case R.id.touXiang_iv:
                if (!isLogin) {
                    dialog = new AlertDialog.Builder(getActivity())
                            .setTitle("提示")
                            .setMessage("您还未登录，是否登录")
                            .setPositiveButton("是", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    Intent intent = new Intent(getActivity(), LoginActivity.class);
                                    startActivity(intent);
                                }
                            })
                            .setNegativeButton("否", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
//                                    dialog.dismiss();
                                    changeTouXiang();
                                }
                            }).create();
                    dialog.show();
                } else {
//                    changeTouXiang();
                }
                break;
        }

    }

    private void changeTouXiang() {
        new ActionSheetDialog(getActivity())
                .builder()
                .setCancelable(true)
                .setCanceledOnTouchOutside(true)
                .addSheetItem("拍照选择", ActionSheetDialog.SheetItemColor.Blue,
                        new ActionSheetDialog.OnSheetItemClickListener() {
                            @Override
                            public void onClick(int which) {
                                Date date1 = new Date(System
                                        .currentTimeMillis());
                                dateTime = date1.getTime() + "";
                                getAvataFromCamera();
                            }
                        })
                .addSheetItem("从手机相册选择", ActionSheetDialog.SheetItemColor.Blue,
                        new ActionSheetDialog.OnSheetItemClickListener() {
                            @Override
                            public void onClick(int which) {
                                Date date1 = new Date(System
                                        .currentTimeMillis());
                                dateTime = date1.getTime() + "";
                                Intent intent = new Intent();
                                intent.setAction(Intent.ACTION_PICK);
                                intent.setType("image/*");
                                intent.setData(android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                                startActivityForResult(intent, 2);
                            }
                        }).show();
    }

    //拍照
    protected void getAvataFromCamera() {
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        if (isExistSd()) {
            intent.putExtra(MediaStore.EXTRA_OUTPUT,
                    Uri.fromFile(new File(Environment.getExternalStorageDirectory(), fileName)));
        }
        startActivityForResult(intent, 1);
    }

    /**
     * 定义方法判断SD卡的存在性
     */
    private boolean isExistSd() {
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            return true;
        } else
            return false;
    }

    //根据返回码，判断是拍照还是相册里的图片来进行裁剪
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == -1) {
            switch (requestCode) {
                case 1:
                    tempFile = new File(Environment.getExternalStorageDirectory(), fileName);
                    startPhotoZoom(Uri.fromFile(tempFile));
                    break;
                case 2:
                    if (data == null) {
                        return;
                    }
                    startPhotoZoom(data.getData());
                    break;
                case 3:
                    if (data != null) {
                        Bundle extras = data.getExtras();
                        if (extras != null) {
                            bitmap = extras.getParcelable("data");
                            imgPath = saveToSdCard(bitmap);
                            Log.i("lamp", "iconUrl---" + imgPath);
                            touXiang_iv.setImageBitmap(bitmap);
                            updateIcon(imgPath);
                        }
                    }
                    break;
            }
        }
    }


    //更新头像
    private void updateIcon(String avataPath) {
        Toast.makeText(getActivity(), "保存成功", Toast.LENGTH_SHORT).show();


    }


    //保存到SD卡
    public String saveToSdCard(Bitmap bitmap) {
        String files = CacheUtils
                .getCacheDirectory(getActivity(), true, "icon")
                + dateTime
                + "_11.jpg";
        File file = new File(files);
        try {
            FileOutputStream fos = new FileOutputStream(file);
            if (bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fos)) {
                fos.flush();
                fos.close();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file.getAbsolutePath();
    }

    //裁剪头像
    public void startPhotoZoom(Uri uri) {
        Intent intent = new Intent("com.android.camera.action.CROP");
        intent.setDataAndType(uri, "image/*");
        // aspectX aspectY 是宽高的比例
        intent.putExtra("aspectX", 1);
        intent.putExtra("aspectY", 1);
        // outputX outputY 是裁剪图片宽高
        intent.putExtra("outputX", 280);
        intent.putExtra("outputY", 280);
        intent.putExtra("crop", "true");
        intent.putExtra("scale", true);// 黑边
        intent.putExtra("scaleUpIfNeeded", true);// 黑边
        intent.putExtra("return-data", true);// 选择返回数据
        startActivityForResult(intent, 3);
    }

}

