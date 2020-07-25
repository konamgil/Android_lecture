package lecture_4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.hanyang.R;

import java.util.ArrayList;

public class PhoneBookAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Item_phone> items;

    public PhoneBookAdapter(Context context, ArrayList<Item_phone> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {// convertview : 껍데기?
            convertView = LayoutInflater.from(context).inflate(R.layout.phonebook_item, parent, false);

        }
        Item_phone currentItem = (Item_phone) getItem(position);

        TextView textViewItemName = (TextView) convertView.findViewById(R.id.name);
        TextView textViewItemNumber = (TextView) convertView.findViewById(R.id.number);

        textViewItemName.setText(currentItem.getItemName());
        textViewItemNumber.setText(currentItem.getItemNumber());

        return convertView;
    }
}