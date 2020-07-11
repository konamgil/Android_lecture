package com.example.hanyang;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import lecture_1.LinearTestActivity_1;
import lecture_1.LinearTestActivity_2;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    @BindView(R.id.btn1) Button btn1;
    @BindView(R.id.btn2) Button btn2;
    @BindView(R.id.btn3) Button btn3;
    @BindView(R.id.btn4) Button btn4;


    Context mContext = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        connectOnClickListener();
    }


    /*
        view 리스너 연결
     */
    private void connectOnClickListener () {
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn1:
                toastSHow("test");
                newStartActivity(LinearTestActivity_1.class);
                break;
            case R.id.btn2:
                newStartActivity(LinearTestActivity_2.class);
                break;
            default:
                break;
        }
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        toastSHow("우리는 안드로이드를 잘할 수 있다.");
        return;
    }
}