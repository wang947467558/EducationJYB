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

import static com.example.ccjust.testfragment.R.id.title_bar_imageView_left;
import static com.example.ccjust.testfragment.R.id.title_bar_textView_left;

public class EditNameActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView title_bar_textView_center;
    private ImageView title_bar_imageView_left;


    private EditText edit_name;
    private Button btn_comfirm;

    @OnClick(R.id.title_bar_imageView_left)
    void back() {
        finish();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_name);
        ButterKnife.bind(this);
        initTitleView();
        initView();
    }

    private void initView() {
        edit_name = (EditText) findViewById(R.id.edit_name);
        btn_comfirm = (Button) findViewById(R.id.btn_comfirm);

        btn_comfirm.setOnClickListener(this);
    }

    private void initTitleView() {
        title_bar_textView_center = (TextView) findViewById(R.id.title_bar_textView_center);
        title_bar_imageView_left = (ImageView) findViewById(R.id.title_bar_imageView_left);

        title_bar_imageView_left.setVisibility(View.VISIBLE);
        title_bar_textView_center.setVisibility(View.VISIBLE);


        title_bar_imageView_left.setImageResource(R.drawable.left);
        title_bar_textView_center.setText("请填写真实姓名");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_comfirm:
                if (!edit_name.getText().toString().trim().equals("")) {
                    Toast.makeText(this, "成功 ", Toast.LENGTH_SHORT).show();
                    String name = edit_name.getText().toString().trim();
                    Intent intent = new Intent();
                    intent.putExtra("name", name);
                    setResult(200, intent);
                    finish();
                } else {
                    Toast.makeText(this, "不能为空", Toast.LENGTH_SHORT).show();
                }

                break;
        }
    }
}
