package lecture_4;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.TypedValue;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hanyang.BaseActivity;
import com.example.hanyang.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

import java.util.ArrayList;

public class PhonebookActivity extends BaseActivity {

//    @BindView(R.id.btntest)
    Button btntest;
//    @BindView(R.id.total)
//    TextView totalText;
//    @BindView(R.id.filter)
//    EditText filterEdit;
    int listSize = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phonebook);
        ButterKnife.bind(this);
//        PhoneBookAdapter adapter = new PhoneBookAdapter(this, generateItemList());


//        btntest.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                toastShow("test");
//            }
//        });
        LinearLayout llBottomSheet = (LinearLayout) findViewById(R.id.bottom_sheet);
        BottomSheetBehavior behavior = BottomSheetBehavior.from(llBottomSheet);
        behavior.setPeekHeight((int) TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP, 72.f, getResources().getDisplayMetrics()));

//        itemListView.setAdapter(adapter);
//        itemListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
//            @Override
//            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
//
//
//                behavior.setHideable(false);
//                toastShow("롱클릭 테스트");
//                return true;
//            }
//        });
//        listSize = adapter.getCount();
//        totalText.setText("총 "+listSize+"개의 연락처");
//        filterEdit.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//
//            }
//
//            @Override
//            public void afterTextChanged(Editable s) {
//                // 비어있을 때 원래 list를 보여줌
//                if((s.toString()).isEmpty()) {
//                    itemListView.setAdapter(adapter);
//                    return ;
//                }
//
//                // 검색기능을 위한 새로운 ArrayList 생성
//                ArrayList<Item_phone> filter_list = new ArrayList<>();
//                String itemNames[] = getResources().getStringArray(R.array.phone_name);
//                String itemNumber[] = getResources().getStringArray(R.array.phone_number);
//
//                // EditText에 입력된 값이 포함되어 있다면 filter_list에 값 추가
//                for(int i=0;i<itemNames.length;i++){
//                    if(itemNames[i].indexOf(s.toString()) != -1){
//                        filter_list.add(new Item_phone(itemNames[i],itemNumber[i]));
//                    }
//                    else if (itemNumber[i].indexOf(s.toString()) != -1){
//                        filter_list.add(new Item_phone(itemNames[i],itemNumber[i]));
//                    }
//                }
//
//                // filter_list를 위한 새로운 adapter 생성 및 연결
//                PhoneBookAdapter filter_adapter = new PhoneBookAdapter(getApplicationContext(), filter_list);
//                itemListView.setAdapter(filter_adapter);
//
//
//
//            }
//        });

    }

    private ArrayList<Item_phone> generateItemList() {
        String itemNames[] = getResources().getStringArray(R.array.phone_name);
        String itemNumber[] = getResources().getStringArray(R.array.phone_number);
        ArrayList<Item_phone> list = new ArrayList<>();
        for(int i=0;i<itemNames.length;i++){
            list.add(new Item_phone(itemNames[i],itemNumber[i]));
        }
        return list;
    }

    private ArrayList<Item_phone> filterItemList(){
        ArrayList<Item_phone> list = new ArrayList<>();

        return list;
    }
}