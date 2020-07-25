package lecture_2;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.hanyang.R;

public class FrameTestActivity_2 extends AppCompatActivity {

    @BindView(R.id.upside_iv)
    ImageView upside;
    @BindView(R.id.downside_iv)
    ImageView downside;
    @BindView(R.id.ch_btn)
    Button change;
    boolean turn = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame_test_2);
        ButterKnife.bind(this);
        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!turn){
                    upside.setImageDrawable(getDrawable(R.drawable.img2));
                    downside.setImageDrawable(getDrawable(R.drawable.img1));
                    turn = true;
                }else{
                    upside.setImageDrawable(getDrawable(R.drawable.img1));
                    downside.setImageDrawable(getDrawable(R.drawable.img2));
                    turn = false;
                }
            }
        });
    }
}