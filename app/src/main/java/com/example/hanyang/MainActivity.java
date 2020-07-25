package com.example.hanyang;

import assignment.AssignmentActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import lecture_1.CalculatorActivity;
import lecture_1.LinearTestActivity_1;
import lecture_1.LinearTestActivity_2;
import lecture_1.LinearTestActivity_3;
import lecture_2.CountActivity;
import lecture_2.FrameTestActivity_1;
import lecture_2.FrameTestActivity_2;
import lecture_2.ListviewActivity_1;
import lecture_2.HandlerTestActivity;
import lecture_1.RelativeTestLayout_1;
import lecture_3.CustomListActivity;
import lecture_3.LifeCycleActivity;
import lecture_4.OpenTestActivity;
import lecture_4.PhonebookActivity;
import lecture_5.VollyActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TableLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity implements View.OnClickListener, View.OnLongClickListener {



    @BindView(R.id.btn1) Button btn1;
    @BindView(R.id.btn2) Button btn2;
    @BindView(R.id.btn3) Button btn3;
    @BindView(R.id.btn4) Button btn4;
    @BindView(R.id.btn5) Button btn5;
    @BindView(R.id.btn6) Button btn6;
    @BindView(R.id.btn7) Button btn7;
    @BindView(R.id.btn8) Button btn8;
    @BindView(R.id.btn9) Button btn9;
    @BindView(R.id.btn10) Button btn10;
    @BindView(R.id.btn11) Button btn11;
    @BindView(R.id.btn12) Button btn12;
    @BindView(R.id.btn13) Button btn13;
    @BindView(R.id.btn14) Button btn14;
    @BindView(R.id.btn15) Button btn15;

    @BindView(R.id.mainTableLayout) TableLayout mainTableLayout;
    Context mContext = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        connectOnClickListener();
        btn1.setOnLongClickListener(this); //과제 이동하기
    }

    /*
       테이블 레이아웃에서 버튼 가져오기
       return List<View>
     */
    public List<View> getAllButtons(ViewGroup layout){
        List<View> viewList = new ArrayList<>();
        for(int i =0; i< layout.getChildCount(); i++){
            View v =layout.getChildAt(i); //해당 테이블로우 전부 가져오기
            viewList.addAll(v.getTouchables()); //해당 테이블로우의 버튼 id 전부 가져오기
        }
        return viewList;
    }
    /*
        view 리스너 연결
     */
    private void connectOnClickListener () {
        Log.d("test","========================= connectOnClickListener =======================");
        List<View> btnList = getAllButtons(mainTableLayout);
        for (View btn:btnList) {
            btn.setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn1:
                toastShow("test");
                newStartActivity(LinearTestActivity_1.class);
                break;
            case R.id.btn2:
                newStartActivity(LinearTestActivity_2.class);
                break;
            case R.id.btn3:
                newStartActivity(LinearTestActivity_3.class);
                break;
            case R.id.btn4:
                newStartActivity(RelativeTestLayout_1.class);
                break;
            case R.id.btn5:
                newStartActivity(CalculatorActivity.class);
                break;
            case R.id.btn6:
                newStartActivity(ListviewActivity_1.class);
                break;
            case R.id.btn7:
                newStartActivity(FrameTestActivity_1.class);
                break;
            case R.id.btn8:
                newStartActivity(FrameTestActivity_2.class);
                break;
            case R.id.btn9:
                newStartActivity(CountActivity.class);
                break;
            case R.id.btn10:
                newStartActivity(HandlerTestActivity.class);
                break;
            case R.id.btn11:
                newStartActivity(LifeCycleActivity.class);
                break;
            case R.id.btn12:
                newStartActivity(OpenTestActivity.class);
                break;
            case R.id.btn13:
                newStartActivity(CustomListActivity.class);
                break;
            case R.id.btn14:
                newStartActivity(PhonebookActivity.class);
                break;
            case R.id.btn15:
                newStartActivity(VollyActivity.class);
                break;
            default:
                break;
        }
    }




    @Override
    public void onBackPressed() {
        super.onBackPressed();
        toastShow("우리는 안드로이드 주니어다.");
        return;
    }

    @Override
    public boolean onLongClick(View v) {
        switch (v.getId()) {
            case R.id.btn1:
                toastShow("과제 페이지 이동");
                newStartActivity(AssignmentActivity.class);
                break;
        }
        return true;
    }
}