package lecture_2;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.hanyang.BaseActivity;
import com.example.hanyang.R;

public class FrameTestActivity_1 extends BaseActivity implements View.OnClickListener {

    @BindView(R.id.imgView)
    ImageView imgView;

    @BindView(R.id.imgView2)
    ImageView imgView2;

    @BindView(R.id.btn)
    Button btn;

    int imageIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame_test);
        ButterKnife.bind(this);
        btn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (imageIndex == 0) {
            imgView.setVisibility(View.VISIBLE);
            imgView2.setVisibility(View.INVISIBLE);
            imageIndex = 1;
        } else if (imageIndex == 1) {
            imgView.setVisibility(View.INVISIBLE);
            imgView2.setVisibility(View.VISIBLE);
            imageIndex = 0;
        }
    }
}