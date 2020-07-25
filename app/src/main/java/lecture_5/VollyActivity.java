package lecture_5;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.example.hanyang.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class VollyActivity extends AppCompatActivity implements View.OnClickListener{

    RequestQueue requestQueue;
    String TAG = this.getClass().getSimpleName();

    @BindView(R.id.btnVolly) Button btnVolly;
    @BindView(R.id.ivView) ImageView ivView;

    private Context context = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volly);
        context = this;
        requestQueue = Volley.newRequestQueue(getApplicationContext());
        ButterKnife.bind(this);
        btnVolly.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnVolly:
                sendRequest();
                break;
            default:
                break;
        }
    }
    public void sendRequest(){
        String url = "http://10.0.2.2:1337/hamburgers/1";

        JsonObjectRequest request = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
//                        String data = response.toString();
                        Log.d(TAG, "응답 => " + response.toString());
                        Hamburger hamburger = new Hamburger();
                        try {

                            hamburger.setImage((String) response.get("image"));

                            Glide.with(context).load(hamburger.getImage()).into(ivView);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        btnVolly.setText("");
//                        Log.d(TAG,response.get("name").toString());
                    }
                },
                new Response.ErrorListener(){
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d(TAG,"에러 => "+ error.getMessage());
                    }
                }
        ){

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                return params;
            }
        };

        request.setShouldCache(false);
        requestQueue.add(request);
        Log.d(TAG, "요청 보냄!!");
    }
}