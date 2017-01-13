package com.example.ccjust.testfragment.activity;

import android.app.VoiceInteractor;
import android.app.WallpaperManager;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.ccjust.testfragment.R;


import java.io.File;
import java.util.Date;

import actionsheetdialog.ActionSheetDialog;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MyQiYeActivity extends AppCompatActivity {
    private ImageView iv_background;
    private String dateTime;
    private static final String fileName = "temp.jpg";
    private File tempFile;
    private ImageView bussiness;
    private Bitmap bitmap;

    @OnClick(R.id.qiye_title_ivLeft)
    void back() {
        finish();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_qi_ye);
        ButterKnife.bind(this);
        initView();

    }

    private void initView() {
        iv_background = (ImageView) findViewById(R.id.iv_background);
        bussiness = (ImageView) findViewById(R.id.business);

    }

    @OnClick(R.id.business)
    void ivBusiness() {
        businessImageView();


    }

    private void businessImageView() {
        new ActionSheetDialog(this)
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
                                startActivityForResult(intent, 4);
                            }
                        }).show();


    }

    private void getAvataFromCamera() {
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        if (isExistSd()) {
            intent.putExtra(MediaStore.EXTRA_OUTPUT,
                    Uri.fromFile(new File(Environment.getExternalStorageDirectory(), fileName)));
        }
        startActivityForResult(intent, 1);
    }

    private boolean isExistSd() {

        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            return true;
        } else
            return false;
    }

    @OnClick(R.id.qiye_title_ivRight)
    void ivBackground() {
        pushImageView();
    }

    private void pushImageView() {
        new ActionSheetDialog(this)
                .builder()
                .setCancelable(true)
                .setCanceledOnTouchOutside(true)
                .addSheetItem("从手机相册选择", ActionSheetDialog.SheetItemColor.Blue,
                        new ActionSheetDialog.OnSheetItemClickListener() {
                            @Override
                            public void onClick(int which) {
                                Intent intent = new Intent();
                                intent.setAction(Intent.ACTION_PICK);
                                intent.setType("image/*");
                                intent.setData(android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                                startActivityForResult(intent, 2);
                            }
                        }).show();
    }


    //根据返回码，判断是拍照还是相册里的图片来进行裁剪
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == -1) {
            switch (requestCode) {
                case 2:
                    if (data == null) {
                        return;
                    }
                    iv_background.setImageURI(data.getData());
                    break;
                case 1:
                    tempFile = new File(Environment.getExternalStorageDirectory(), fileName);
                    startPhotoZoom(Uri.fromFile(tempFile));
                    break;
                case 3:
                    if (data != null) {
                        Bundle extras = data.getExtras();
                        if (extras != null) {
                            bitmap = extras.getParcelable("data");
                            bussiness.setImageBitmap(bitmap);
                        }
                        break;
                    }
                case 4:
                    if (data == null) {
                        return;
                    }
                    bussiness.setImageURI(data.getData());
                    break;
            }
        }
    }

    private void startPhotoZoom(Uri uri) {
        Intent intent = new Intent("com.android.camera.action.CROP");
        intent.setDataAndType(uri, "image/*");
        // aspectX aspectY 是宽高的比例
//        intent.putExtra("aspectX", 3);
//        intent.putExtra("aspectY", 2);
        // outputX outputY 是裁剪图片宽高
        intent.putExtra("outputX", 300);
        intent.putExtra("outputY", 200);
        intent.putExtra("crop", "true");
        intent.putExtra("scale", true);// 黑边
        intent.putExtra("scaleUpIfNeeded", true);// 黑边
        intent.putExtra("return-data", true);// 选择返回数据
        startActivityForResult(intent, 3);
    }

}




