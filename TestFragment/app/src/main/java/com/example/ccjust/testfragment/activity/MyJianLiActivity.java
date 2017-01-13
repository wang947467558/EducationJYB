package com.example.ccjust.testfragment.activity;

import android.app.ActionBar;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import android.widget.PopupWindow;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ccjust.testfragment.R;
import com.example.ccjust.testfragment.rili.wheelview.DateUtils;
import com.example.ccjust.testfragment.rili.wheelview.JudgeDate;
import com.example.ccjust.testfragment.rili.wheelview.ScreenInfo;
import com.example.ccjust.testfragment.rili.wheelview.WheelMain;
import com.example.ccjust.testfragment.view.SexDialog;
import com.example.ccjust.testfragment.view.StudentDialog;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MyJianLiActivity extends AppCompatActivity implements View.OnClickListener {
    //声明标题
    private ImageView title_bar_imageView_left;
    private TextView title_bar_textView_center;
    private TextView title_bar_textViewSizeBig_right;

    //声明TextView
    private TextView tv_userName;
    private TextView tv_userSex;
    private TextView tv_userIsStudent;
    private TextView tv_userEducation;
    private TextView tv_userShcool;
    private TextView tv_userDepartment;
    private TextView tv_userYear;
    private TextView tv_userQQ;
    private TextView tv_userWX;
    private TextView tv_userMail;

    //声明LinearLayout
    private LinearLayout ll_userName;
    private LinearLayout ll_userSex;
    private LinearLayout ll_userIsStudent;
    private LinearLayout ll_userEducation;
    private LinearLayout ll_userSchool;
    private LinearLayout ll_userDepartment;
    private LinearLayout ll_userYear;
    private LinearLayout ll_userQQ;
    private LinearLayout ll_userWx;
    private LinearLayout ll_userMail;

    //声明dialog_sex
    private RelativeLayout rel_sex_women;
    private RelativeLayout rel_sex_man;
    private RelativeLayout rel_sex_back;

    private TextView tv_sex_women;
    private TextView tv_sex_man;
    private Dialog dialog_sex;

    //声明dialog_student
    private RelativeLayout rel_student_yes;
    private RelativeLayout rel_student_no;
    private RelativeLayout rel_student_back;
    private TextView tv_student_yes;
    private TextView tv_student_no;
    private Dialog dialog_student;

    //声明ProgressBar
    private ProgressBar pb_data;
    private TextView tv_pb;
    int number;
    String s;
    String name;


    private WheelMain wheelMainDate;
    private String beginTime;
    private java.text.DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    @OnClick(R.id.title_bar_imageView_left)
    void back() {
        finish();
    }

    @OnClick(R.id.title_bar_textViewSizeBig_right)
    void save() {
        Toast.makeText(this, "保存成功", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_jian_li);
        ButterKnife.bind(this);
        initTitleView();
        initProgressBar();
        initView();
    }

    private void initProgressBar() {
        pb_data = (ProgressBar) findViewById(R.id.pb_data);
        tv_pb = (TextView) findViewById(R.id.tv_pb);

    }

    private void initView() {

        //初始化
        tv_userName = (TextView) findViewById(R.id.tv_userName);
        tv_userSex = (TextView) findViewById(R.id.tv_UserSex);
        tv_userIsStudent = (TextView) findViewById(R.id.tv_userIsStudent);
        tv_userEducation = (TextView) findViewById(R.id.tv_userEducation);
        tv_userShcool = (TextView) findViewById(R.id.tv_shcool);
        tv_userDepartment = (TextView) findViewById(R.id.tv_department);
        tv_userYear = (TextView) findViewById(R.id.tv_year);
        tv_userQQ = (TextView) findViewById(R.id.tv_QQ);
        tv_userWX = (TextView) findViewById(R.id.tv_WX);
        tv_userMail = (TextView) findViewById(R.id.tv_mail);

        //初始化
        ll_userName = (LinearLayout) findViewById(R.id.ll_name);
        ll_userSex = (LinearLayout) findViewById(R.id.ll_sex);
        ll_userIsStudent = (LinearLayout) findViewById(R.id.ll_isStudent);
        ll_userEducation = (LinearLayout) findViewById(R.id.ll_education);
        ll_userSchool = (LinearLayout) findViewById(R.id.ll_shcool);
        ll_userDepartment = (LinearLayout) findViewById(R.id.ll_department);
        ll_userYear = (LinearLayout) findViewById(R.id.ll_year);
        ll_userQQ = (LinearLayout) findViewById(R.id.ll_QQ);
        ll_userWx = (LinearLayout) findViewById(R.id.ll_WX);
        ll_userMail = (LinearLayout) findViewById(R.id.ll_mail);


        //给布局设置监听
        ll_userName.setOnClickListener(this);
        ll_userSex.setOnClickListener(this);
        ll_userIsStudent.setOnClickListener(this);
        ll_userEducation.setOnClickListener(this);
        ll_userSchool.setOnClickListener(this);
        ll_userDepartment.setOnClickListener(this);
        ll_userYear.setOnClickListener(this);
        ll_userQQ.setOnClickListener(this);
        ll_userWx.setOnClickListener(this);
        ll_userMail.setOnClickListener(this);


    }

    private void initTitleView() {
        title_bar_imageView_left = (ImageView) findViewById(R.id.title_bar_imageView_left);
        title_bar_textView_center = (TextView) findViewById(R.id.title_bar_textView_center);
        title_bar_textViewSizeBig_right = (TextView) findViewById(R.id.title_bar_textViewSizeBig_right);

        title_bar_textView_center.setVisibility(View.VISIBLE);
        title_bar_imageView_left.setVisibility(View.VISIBLE);
        title_bar_textViewSizeBig_right.setVisibility(View.VISIBLE);

        title_bar_textViewSizeBig_right.setText("保存");
        title_bar_imageView_left.setImageResource(R.drawable.left);
        title_bar_textView_center.setText("个人简历");

    }


    //监听方法
    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.ll_name:
                startActivityForResult(new Intent(MyJianLiActivity.this, EditNameActivity.class), 200);
                break;
            case R.id.ll_sex:
                dialogSexView();
                break;
            case R.id.ll_isStudent:
                dialogStudentView();
                break;
            case R.id.ll_education:
                startActivityForResult(new Intent(MyJianLiActivity.this, EditEducationActivity.class), 100);
                break;
            case R.id.ll_shcool:
                startActivityForResult(new Intent(MyJianLiActivity.this, EditShcoolActivity.class), 300);
                break;
            case R.id.ll_department:
                startActivityForResult(new Intent(MyJianLiActivity.this, EditDepartmentActivity.class), 400);
                break;
            case R.id.ll_year:
                showBottoPopupWindow();

                break;
            case R.id.ll_QQ:
                startActivityForResult(new Intent(MyJianLiActivity.this, EditQQActivity.class), 500);

                break;
            case R.id.ll_WX:
                startActivityForResult(new Intent(MyJianLiActivity.this, EditWXActivity.class), 600);
                break;
            case R.id.ll_mail:
                startActivityForResult(new Intent(MyJianLiActivity.this, EditMailActivity.class), 700);
                break;

            case R.id.rel_sex_man:
                initTvSexMan();
                break;
            case R.id.rel_sex_women:
                initTvSexWomen();
                break;
            case R.id.rel_sex_back:
                dialog_sex.dismiss();
                break;

            case R.id.rel_student_yes:
                dialogStudentYes();
                break;
            case R.id.rel_student_no:
                dialogStudentNo();
                break;
            case R.id.rel_student_back:
                dialog_student.dismiss();
                break;
        }

    }

    private void showBottoPopupWindow() {
        WindowManager manager = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
        Display defaultDisplay = manager.getDefaultDisplay();
        DisplayMetrics outMetrics = new DisplayMetrics();
        defaultDisplay.getMetrics(outMetrics);
        int width = outMetrics.widthPixels;
        View menuView = LayoutInflater.from(this).inflate(R.layout.show_popup_window, null);
        final PopupWindow mPopupWindow = new PopupWindow(menuView, (int) (width * 0.8),
                ActionBar.LayoutParams.WRAP_CONTENT);
        ScreenInfo screenInfoDate = new ScreenInfo(this);
        wheelMainDate = new WheelMain(menuView, true);
        wheelMainDate.screenheight = screenInfoDate.getHeight();
        String time = DateUtils.currentMonth().toString();
        Calendar calendar = Calendar.getInstance();
        if (JudgeDate.isDate(time, "yyyy-MM-DD")) {
            try {
                calendar.setTime(new Date(time));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int hours = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        wheelMainDate.initDateTimePicker(year, month, day, hours, minute);
        final String currentTime = wheelMainDate.getTime().toString();
        mPopupWindow.setAnimationStyle(R.style.AnimationPreview);
        mPopupWindow.setTouchable(true);
        mPopupWindow.setFocusable(true);
        mPopupWindow.setBackgroundDrawable(new BitmapDrawable());
        mPopupWindow.showAtLocation(tv_userShcool, Gravity.CENTER, 0, 0);
        mPopupWindow.setOnDismissListener(new poponDismissListener());
        backgroundAlpha(0.6f);
        TextView tv_cancle = (TextView) menuView.findViewById(R.id.tv_cancle);
        TextView tv_ensure = (TextView) menuView.findViewById(R.id.tv_ensure);
        TextView tv_pop_title = (TextView) menuView.findViewById(R.id.tv_pop_title);
        tv_pop_title.setText("选择起始时间");
        tv_cancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                mPopupWindow.dismiss();
                backgroundAlpha(1f);
            }
        });
        tv_ensure.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                beginTime = wheelMainDate.getTime().toString();
                String userYear = tv_userYear.getText().toString().trim();
                if (userYear.equals("")) {
                    pb_data.incrementProgressBy(10);
                    number = number + 10;
                    s = number + "";
                }
                try {
                    Date begin = dateFormat.parse(currentTime);
                    Date end = dateFormat.parse(beginTime);
                    tv_userYear.setText(DateUtils.currentTimeDeatil(end));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                mPopupWindow.dismiss();
                backgroundAlpha(1f);
                tv_pb.setText(s);

            }
        });
    }

    private void backgroundAlpha(float v) {
        WindowManager.LayoutParams lp = getWindow().getAttributes();
        lp.alpha = v;
        getWindow().setAttributes(lp);
    }

    private void dialogStudentNo() {
        String student_no = tv_student_no.getText().toString();
        String userIsStudent = tv_userIsStudent.getText().toString();
        if (userIsStudent.equals("")) {
            pb_data.incrementProgressBy(10);
            number = number + 10;
            s = number + "";
        }
        tv_userIsStudent.setText(student_no);
        tv_pb.setText(s);
        dialog_student.dismiss();
    }

    private void dialogStudentYes() {
        String userIsStudent = tv_userIsStudent.getText().toString();
        String student_yes = tv_student_yes.getText().toString();
        if (userIsStudent.equals("")) {
            pb_data.incrementProgressBy(10);
            number = number + 10;
            this.s = number + "";
        }
        tv_pb.setText(this.s);
        tv_userIsStudent.setText(student_yes);
        dialog_student.dismiss();


    }

    private void dialogStudentView() {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(MyJianLiActivity.this).inflate(R.layout.dialog_isstudent, null);
        dialog_student = new StudentDialog.Builder(MyJianLiActivity.this, R.style.MyDialog).create();
        dialog_student.setCanceledOnTouchOutside(true);
        dialog_student.show();
        dialog_student.getWindow().setContentView(linearLayout);


        rel_student_yes = (RelativeLayout) linearLayout.findViewById(R.id.rel_student_yes);
        rel_student_no = (RelativeLayout) linearLayout.findViewById(R.id.rel_student_no);
        rel_student_back = (RelativeLayout) linearLayout.findViewById(R.id.rel_student_back);

        tv_student_yes = (TextView) linearLayout.findViewById(R.id.tv_student_yes);
        tv_student_no = (TextView) linearLayout.findViewById(R.id.tv_student_no);

        rel_student_back.setOnClickListener(this);
        rel_student_no.setOnClickListener(this);
        rel_student_back.setOnClickListener(this);


    }

    private void initTvSexWomen() {
        Toast.makeText(this, "tv_sex_women", Toast.LENGTH_SHORT).show();
        String userSex = tv_userSex.getText().toString();
        String sex_women = tv_sex_women.getText().toString();
        if (userSex.equals("")) {
            pb_data.incrementProgressBy(10);
            number = number + 10;
            s = number + "";
        }
        tv_pb.setText(s);
        tv_userSex.setText(sex_women);
        dialog_sex.dismiss();

    }

    private void initTvSexMan() {
        Toast.makeText(this, "tv_sex_man", Toast.LENGTH_SHORT).show();
        String sex_man = tv_sex_man.getText().toString();
        String userSex = tv_userSex.getText().toString();
        if (userSex.equals("")) {
            pb_data.incrementProgressBy(10);
            number = number + 10;
            s = number + "";
        }
        tv_pb.setText(s);
        tv_userSex.setText(sex_man);

        dialog_sex.dismiss();
    }

    private void dialogSexView() {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(MyJianLiActivity.this).inflate(R.layout.dialog_sex, null);
        dialog_sex = new SexDialog.Builder(MyJianLiActivity.this, R.style.MyDialog).create();
        dialog_sex.setCanceledOnTouchOutside(true);
        dialog_sex.show();
        dialog_sex.getWindow().setContentView(linearLayout);

        rel_sex_women= (RelativeLayout) linearLayout.findViewById(R.id.rel_sex_women);
        rel_sex_man= (RelativeLayout) linearLayout.findViewById(R.id.rel_sex_man);

        tv_sex_man = (TextView) linearLayout.findViewById(R.id.tv_sex_man);
        tv_sex_women = (TextView) linearLayout.findViewById(R.id.tv_sex_women);
        rel_sex_back = (RelativeLayout) linearLayout.findViewById(R.id.rel_sex_back);

        rel_sex_back.setOnClickListener(this);
        rel_sex_man.setOnClickListener(this);
        rel_sex_women.setOnClickListener(this);

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 200 && resultCode == 200) {
            String tv_name = tv_userName.getText().toString();
            Log.i("TAG", tv_name);
            name = data.getStringExtra("name");
            Log.i("TAG", name);
            boolean equals = tv_name.equals(name);
            String e = equals + "";
            Log.i("TAG", e);
            if (tv_name.equals("")) {
                pb_data.incrementProgressBy(10);
                number = number + 10;
                s = number + "";
            }
            tv_pb.setText(s);
            tv_userName.setText(name);
        } else if (requestCode == 100 && resultCode == 100) {
            String education = data.getStringExtra("education");
            String userEducation = tv_userEducation.getText().toString();
            if (userEducation.equals("")) {
                pb_data.incrementProgressBy(10);
                number = number + 10;
                s = number + "";
            }
            tv_userEducation.setText(education);
            tv_pb.setText(s);
        } else if (requestCode == 300 && resultCode == 300) {

            String shcoolName = data.getStringExtra("shcoolName");
            if (tv_userShcool.getText().toString().equals("")) {
                pb_data.incrementProgressBy(10);
                number = number + 10;
                s = number + "";
            }
            tv_pb.setText(s);
            tv_userShcool.setText(shcoolName);

        } else if (requestCode == 400 && resultCode == 400) {
            String departmentName = data.getStringExtra("department_name");
            if (tv_userDepartment.getText().toString().equals("")) {
                pb_data.incrementProgressBy(10);
                number = number + 10;
                s = number + "";
            }
            tv_userDepartment.setText(departmentName);
            tv_pb.setText(s);
        } else if (requestCode == 500 && resultCode == 500) {
            String qqName = data.getStringExtra("qqName");
            if (tv_userQQ.getText().toString().equals("")) {
                pb_data.incrementProgressBy(10);
                number = number + 10;
                s = number + "";
            }
            tv_userQQ.setText(qqName);
            tv_pb.setText(s);

        } else if (requestCode == 600 && resultCode == 600) {
            String wxName = data.getStringExtra("wxName");
            if (tv_userWX.getText().toString().equals("")) {
                pb_data.incrementProgressBy(10);
                number = number + 10;
                s = number + "";

            }
            tv_userWX.setText(wxName);
            tv_pb.setText(s);
        } else if (requestCode == 700 && resultCode == 700) {
            String mailName = data.getStringExtra("mailName");
            if (tv_userMail.getText().toString().equals("")) {
                pb_data.incrementProgressBy(10);
                number = number + 10;
                s = number + "";
            }
            tv_userMail.setText(mailName);
            tv_pb.setText(s);
        }


    }

    {
    }

    private class poponDismissListener implements PopupWindow.OnDismissListener {
        @Override
        public void onDismiss() {
            backgroundAlpha(1f);
        }
    }
}

