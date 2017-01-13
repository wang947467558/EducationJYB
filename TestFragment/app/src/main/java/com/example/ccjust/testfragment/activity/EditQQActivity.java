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

public class EditQQActivity extends AppCompatActivity {
    private TextView title_bar_textView_center;
    private ImageView title_bar_imageView_left;

    @OnClick(R.id.title_bar_imageView_left)
    void back() {
        finish();
    }


    private EditText edit_QQ_name;
    private Button btn_QQ_confirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_qq);
        ButterKnife.bind(this);
        initTitleView();
        initView();
    }

    private void initView() {
        edit_QQ_name = (EditText) findViewById(R.id.edit_QQ_name);
        btn_QQ_confirm = (Button) findViewById(R.id.btn_QQ_confirm);

        btn_QQ_confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edit_QQ_name.getText().toString().equals(""))
                    Toast.makeText(EditQQActivity.this, "不能为空", Toast.LENGTH_SHORT).show();
                else {
                    String qqName = edit_QQ_name.getText().toString().trim();
                    Intent intent = new Intent();
                    intent.putExtra("qqName", qqName);
                    setResult(500, intent);
                    finish();
                }

            }

        });
    }

    private void initTitleView() {
        title_bar_textView_center = (TextView) findViewById(R.id.title_bar_textView_center);
        title_bar_imageView_left = (ImageView) findViewById(R.id.title_bar_imageView_left);

        title_bar_imageView_left.setVisibility(View.VISIBLE);
        title_bar_textView_center.setVisibility(View.VISIBLE);


        title_bar_textView_center.setText("QQ");
        title_bar_imageView_left.setImageResource(R.drawable.left);

    }
}
