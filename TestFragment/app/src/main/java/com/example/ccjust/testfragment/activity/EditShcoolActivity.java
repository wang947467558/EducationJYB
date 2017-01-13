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

public class EditShcoolActivity extends AppCompatActivity {
    private TextView title_bar_textView_center;
    private ImageView title_bar_imageView_left;

    private EditText edit_shcool_name;
    private Button btn_shcool_confirm;

    @OnClick(R.id.title_bar_imageView_left)
    void back() {
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_shcool);
        ButterKnife.bind(this);
        initTitleView();
        initView();
    }

    private void initView() {
        edit_shcool_name = (EditText) findViewById(R.id.edit_shcool_name);
        btn_shcool_confirm = (Button) findViewById(R.id.btn_shcool_confirm);

        btn_shcool_confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edit_shcool_name.getText().toString().equals("")) {
                    Toast.makeText(EditShcoolActivity.this, "不能为空", Toast.LENGTH_SHORT).show();
                } else {
                    String shcoolName = edit_shcool_name.getText().toString().trim();

                    Intent intent = new Intent();
                    intent.putExtra("shcoolName", shcoolName);
                    setResult(300, intent);
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


        title_bar_textView_center.setText("学校");
        title_bar_imageView_left.setImageResource(R.drawable.left);

    }
}
