package com.example.ccjust.testfragment.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.os.Parcelable;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Selection;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ccjust.testfragment.R;
import com.example.ccjust.testfragment.city.ChangeAddressPopwindow;
import com.example.ccjust.testfragment.touxiangview.CircleImageView;
import com.example.ccjust.testfragment.utils.CacheUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import actionsheetdialog.ActionSheetDialog;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.example.ccjust.testfragment.R.id.touXiang_iv;

public class ZhiWeiFaBuActivity extends AppCompatActivity implements View.OnClickListener {
    //职位类别Spinner声明
    private Spinner spinner_category;
    private List<String> category_list;
    private ArrayAdapter adapter;

    // 标题声明
    private ImageView title_bar_imageView_left;
    private TextView title_bar_textView_center;
    private TextView title_bar_textViewSizeBig_right;

    //标签声明
    private ViewGroup rel_layout;
    private TextView textView[] = new TextView[3];
    private TextView textView1[] = new TextView[3];
    private TextView tv_subAdd;
    private EditText edit_label;
    private int i = 0;

    //薪资Spinner声明
    private Spinner spinner_pay;
    private List<String> pay_list;
    //工作地区声明
    private TextView tv_address;

    //工作年限
    private Spinner spinner_year;
    private List<String> yearList;

    //学历
    private Spinner spinner_education;
    private List<String> educationList;

    //工作性质
    private Spinner spinner_nature;
    private List<String> natureList;

    //首页背景
    private ImageView iv_push;
    private String dateTime;
    private static final String fileName = "temp.jpg";
    private File tempFile;
    private Bitmap bitmap;
    private String imgPath;


    @OnClick(R.id.title_bar_textViewSizeBig_right)
    void faBu() {
        Toast.makeText(this, "发布成功", Toast.LENGTH_SHORT).show();
        finish();
    }

    @OnClick(R.id.title_bar_imageView_left)
    void back() {
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhi_wei_fa_bu);
        initTitleView();
        initView();
        ButterKnife.bind(this);
    }

    private void initTitleView() {
        title_bar_imageView_left = (ImageView) findViewById(R.id.title_bar_imageView_left);
        title_bar_textView_center = (TextView) findViewById(R.id.title_bar_textView_center);
        title_bar_textViewSizeBig_right = (TextView) findViewById(R.id.title_bar_textViewSizeBig_right);

        title_bar_textView_center.setVisibility(View.VISIBLE);
        title_bar_textViewSizeBig_right.setVisibility(View.VISIBLE);
        title_bar_imageView_left.setVisibility(View.VISIBLE);

        title_bar_imageView_left.setImageResource(R.drawable.left);
        title_bar_textViewSizeBig_right.setText("发布");
        title_bar_textView_center.setText("发布职位");


    }

    private void initView() {
        //标签
        rel_layout = (ViewGroup) findViewById(R.id.rel_layout);
        tv_subAdd = (TextView) findViewById(R.id.tv_subAdd);
        edit_label = (EditText) findViewById(R.id.edit_label);
        //工作区域
        tv_address = (TextView) findViewById(R.id.tv_address);

        //首页背景
        iv_push = (ImageView) findViewById(R.id.iv_push);

        //Spinner
        //职位类别
        initCategorySpinner();
        //薪资
        initPaySpinner();
        //工作年限
        initYearSpinner();
        //学历
        initEducationSpinner();
        //工作性质
        initNatureSpinner();

        //添加标签监听
        tv_subAdd.setOnClickListener(this);
        //工作区域按钮监听
        tv_address.setOnClickListener(this);
        //首页背景监听
        iv_push.setOnClickListener(this);
    }

    private void initNatureSpinner() {
        spinner_nature = (Spinner) findViewById(R.id.spinner_nature);
        natureList = new ArrayList<>();
        natureList.add("全职");
        natureList.add("兼职");
        adapter = new ArrayAdapter(this, R.layout.spinner_down, natureList);
        adapter.setDropDownViewResource(R.layout.spinner_down);
        spinner_nature.setAdapter(adapter);
        spinner_nature.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String s = parent.getItemAtPosition(position).toString();
                Toast.makeText(ZhiWeiFaBuActivity.this, s, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void initEducationSpinner() {
        spinner_education = (Spinner) findViewById(R.id.spinner_education);
        educationList = new ArrayList<>();
        educationList.add("初中");
        educationList.add("高中");
        educationList.add("专科");
        educationList.add("本科");
        educationList.add("硕士");
        educationList.add("博士");
        adapter = new ArrayAdapter(this, R.layout.spinner_down, educationList);
        adapter.setDropDownViewResource(R.layout.spinner_down);
        spinner_education.setAdapter(adapter);

        spinner_education.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String s = parent.getItemAtPosition(position).toString();
                Toast.makeText(ZhiWeiFaBuActivity.this, s, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void initYearSpinner() {
        spinner_year = (Spinner) findViewById(R.id.spinner_year);
        yearList = new ArrayList<>();
        yearList.add("应界生");
        yearList.add("1年以下");
        yearList.add("1-3年");
        yearList.add("3-5年");
        yearList.add("5-10年");
        yearList.add("10年以上");
        adapter = new ArrayAdapter(this, R.layout.spinner_down, yearList);
        adapter.setDropDownViewResource(R.layout.spinner_down);
        spinner_year.setAdapter(adapter);
        spinner_year.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String s = parent.getItemAtPosition(position).toString();
                Toast.makeText(ZhiWeiFaBuActivity.this, s, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void initPaySpinner() {
        spinner_pay = (Spinner) findViewById(R.id.spinner_pay);
        pay_list = new ArrayList<>();
        pay_list.add("3K以下");
        pay_list.add("3K-5K");
        pay_list.add("5-10K");
        pay_list.add("10K-20K");
        pay_list.add("20K以上");
        adapter = new ArrayAdapter(this, R.layout.spinner_down, pay_list);
        adapter.setDropDownViewResource(R.layout.spinner_down);
        spinner_pay.setAdapter(adapter);
        spinner_pay.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String s = parent.getItemAtPosition(position).toString();
                Toast.makeText(ZhiWeiFaBuActivity.this, s, Toast.LENGTH_SHORT).show();
            }


            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void initCategorySpinner() {
        spinner_category = (Spinner) findViewById(R.id.spinner_category);
        category_list = new ArrayList<>();
        category_list.add("UI设计");
        category_list.add("IOS开发");
        category_list.add("安卓开发");
        category_list.add("电话销售");
        adapter = new ArrayAdapter(this, R.layout.spinner_down, category_list);
        adapter.setDropDownViewResource(R.layout.spinner_down);
        spinner_category.setAdapter(adapter);
        spinner_category.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String s = parent.getItemAtPosition(position).toString();
                Toast.makeText(ZhiWeiFaBuActivity.this, s, Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.tv_subAdd:
                if (edit_label.getText().toString().equals("")) {
                    Toast.makeText(this, "不能为空", Toast.LENGTH_SHORT).show();
                } else if (i < 3) {
                    textView[i] = new TextView(ZhiWeiFaBuActivity.this);
                    textView1[i] = new TextView(ZhiWeiFaBuActivity.this);
                    String str = edit_label.getText().toString();
                    textView[i].setText(str);
                    textView[i].setBackgroundResource(R.drawable.mengxiang_round_kuang_bg);
                    rel_layout.addView(textView[i]);
                    textView1[i].setText("  ");
                    rel_layout.addView(textView1[i]);
                    i++;
                } else {
                    Toast.makeText(ZhiWeiFaBuActivity.this, "已经添加五个了，不能再加了", Toast.LENGTH_SHORT).show();
                }

                break;
            case R.id.tv_address:
                ChangeAddressPopwindow mChangeAddressPopwindow = new ChangeAddressPopwindow(this);
//                mChangeAddressPopwindow.setAddress();
                mChangeAddressPopwindow.showAtLocation(tv_address, Gravity.BOTTOM, 0, 0);
                mChangeAddressPopwindow.setAddresskListener(new ChangeAddressPopwindow.OnAddressCListener() {
                    @Override
                    public void onClick(String province, String city, String area) {
                        tv_address.setText(province + city + area);
                    }
                });
                break;

            case R.id.iv_push:
                pushImageView();
                break;
        }
    }

    private void pushImageView() {
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
                                startActivityForResult(intent, 2);
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
                            iv_push.setImageBitmap(bitmap);
                            updateIcon(imgPath);
                        }
                    }
                    break;
            }
        }
    }

    private void updateIcon(String imgPath) {
        Toast.makeText(this, "保存成功", Toast.LENGTH_SHORT).show();
    }

    private String saveToSdCard(Bitmap bitmap) {
        String files = CacheUtils
                .getCacheDirectory(this, true, "icon")
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
