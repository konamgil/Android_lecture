package lecture_3;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;

import android.os.Bundle;
import android.widget.ListView;

import com.example.hanyang.R;

import java.util.ArrayList;

public class CustomListActivity extends AppCompatActivity {

    private ListView itemsListView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_list);
        itemsListView = findViewById(R.id.listview1);
        CustomListAdapter adapter = new CustomListAdapter(this, generateItemsList());
        itemsListView.setAdapter(adapter);
    }

    /**
     * Util function to generate list of items
     *
     * @return ArrayList
     */
    private ArrayList<Item> generateItemsList() {
        String itemNames[] = getResources().getStringArray(R.array.items_name);
        String itemDescriptions[] = getResources().getStringArray(R.array.item_description);

        ArrayList<Item> list = new ArrayList<>();

        for (int i = 0; i < itemNames.length; i++) {
            list.add(new Item(itemNames[i], itemDescriptions[i]));
        }

        return list;
    }
}