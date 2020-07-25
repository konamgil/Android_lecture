package lecture_2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;

import com.example.hanyang.R;



public class CountActivity extends AppCompatActivity {

    @BindView(R.id.tvNum)
    TextView tvNum;

    private int count = 0;
    private Handler mHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_count);
        ButterKnife.bind(this);
        mHandler = new Handler(){
            @Override
            public void handleMessage(@NonNull Message msg) {
                super.handleMessage(msg);
                if(msg.what == 0) {
                    tvNum.setText("" + msg.arg1);
                }
            }
        };


        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <= 100; i++) { // 현재 UI 스레드가 아니기 때문에 메시지 큐에 Runnable을 등록 함
                    count++;
//                    runOnUiThread(new Runnable() {
//                        public void run() { // 메시지 큐에 저장될 메시지의 내용
//                            tvNum.setText("" + count);
//                        }
//                    });

                    Message msg = mHandler.obtainMessage();
                    msg.arg1 = count;
                    mHandler.sendMessage(msg);

                    try {
                        Thread.sleep(1000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();


    }

}