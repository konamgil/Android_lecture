package lecture_2;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.example.hanyang.BaseActivity;
import com.example.hanyang.R;

import java.util.ArrayList;

public class ListviewActivity_1 extends BaseActivity {

    @BindView(R.id.namelist) ListView namelist;
    ArrayList<String> strArrayList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);
        ButterKnife.bind(this);

        for (int i = 0; i<20; i++){
            strArrayList.add(i + "번째");
        }

        Adapter adapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1, strArrayList);
        namelist.setAdapter((ListAdapter) adapter);


        namelist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                toastShow(position + "");
            }
        });
    }

}