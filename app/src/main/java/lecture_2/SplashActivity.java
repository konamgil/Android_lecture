package lecture_2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;

import com.example.hanyang.BaseActivity;
import com.example.hanyang.MainActivity;
import com.example.hanyang.R;

public class SplashActivity extends BaseActivity {
    private final int SPLASH_DISPLAY_LENGTH = 2000;


    private Handler mHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);
//1
        mHandler = new Handler() {
            @Override
            public void handleMessage(@NonNull Message msg) {
                super.handleMessage(msg);
                if(msg.what == 0) {
                    newStartActivity(MainActivity.class);
                    finish();
                }
            }
        };


        Thread t = new Thread(){
            @Override
            public void run() {
                super.run();
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                mHandler.sendEmptyMessage(0);
            }
        };

        t.start();

//2
//        new Handler().postDelayed(new Runnable(){
//            @Override
//            public void run() {
//                    Log.d("스플래시 화면", "스플래시 종료");
//                    newStartActivity(MainActivity.class);
//                    finish();
//            }
//        }, SPLASH_DISPLAY_LENGTH);

//        SubThread st = new SubThread();
//        st.start();
    }

//    class SubThread extends Thread {
//        public SubThread() {
//            super();
//        }
//
//        @Override
//        public void run() {
//            try {
//                Thread.sleep(SPLASH_DISPLAY_LENGTH);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            Log.d("스플래시 화면", "스플래시 종료");
//            newStartActivity(MainActivity.class);
//            finish();
//        }
//    }
}