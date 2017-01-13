package com.example.ccjust.testfragment.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ccjust.testfragment.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class EditEducationActivity extends AppCompatActivity {
    private ImageView title_bar_imageView_left;
    private TextView title_bar_textView_conter;


    private EditText edit_education;
    private Button btn_education_comfirm;


    @OnClick(R.id.title_bar_imageView_left)
    void back() {
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_education);
        ButterKnife.bind(this);
        initTitleView();
        initView();

    }

    private void initView() {
        edit_education = (EditText) findViewById(R.id.edit_education);
        btn_education_comfirm = (Button) findViewById(R.id.btn_education_comfirm);

        btn_education_comfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edit_education.getText().toString().equals("")) {
                    Toast.makeText(EditEducationActivity.this, "不能为空", Toast.LENGTH_SHORT).show();
                } else {

                    String education = edit_education.getText().toString().trim();

                    Intent intent = new Intent();
                    intent.putExtra("education", education);
                    setResult(100, intent);
                    finish();
                }
            }
        });

    }

    private void initTitleView() {
        title_bar_imageView_left = (ImageView) findViewById(R.id.title_bar_imageView_left);
        title_bar_textView_conter = (TextView) findViewById(R.id.title_bar_textView_center);
        title_bar_imageView_left.setVisibility(View.VISIBLE);
        title_bar_textView_conter.setVisibility(View.VISIBLE);
        title_bar_textView_conter.setText("学历");
        title_bar_imageView_left.setImageResource(R.drawable.left);
    }
}
