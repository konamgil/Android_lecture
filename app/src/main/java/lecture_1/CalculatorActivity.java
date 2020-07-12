package lecture_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.hanyang.R;

public class CalculatorActivity extends AppCompatActivity  implements View.OnClickListener{
    Button btn0,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9;
    Button plus,sub,result,mul,div,rem,clear;
    TextView tv;
    String pro="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        tv = findViewById(R.id.board_tv);
        tv.setText("0");
        plus = findViewById(R.id.plus);
        sub = findViewById(R.id.sub);
        result = findViewById(R.id.result);
        mul = findViewById(R.id.mul);
        div =findViewById(R.id.share);
        clear = findViewById(R.id.clear);
        rem = findViewById(R.id.rest);
        btn0.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btn0){
            pro += "0";
        }else if(v.getId() == R.id.btn1){
            pro += "1";
        }else if(v.getId() == R.id.btn2){
            pro += "2";
        }else if(v.getId() == R.id.btn3){
            pro += "3";
        }else if(v.getId() == R.id.btn4){
            pro += "4";
        }else if(v.getId() == R.id.btn5){
            pro += "5";
        }else if(v.getId() == R.id.btn6){
            pro += "6";
        }else if(v.getId() == R.id.btn7){
            pro += "7";
        }else if(v.getId() == R.id.btn8){
            pro += "8";
        }else if(v.getId() == R.id.btn9){
            pro += "9";
        }
        tv.setText(pro);
    }
}