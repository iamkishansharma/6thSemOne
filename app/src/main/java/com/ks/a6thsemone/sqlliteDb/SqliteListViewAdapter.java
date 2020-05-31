package com.ks.a6thsemone.sqlliteDb;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.ks.a6thsemone.R;

import java.util.ArrayList;

class SqliteListViewAdapter extends ArrayAdapter<String> {
    private final Activity context;
    private final ArrayList<String> name;
    private final ArrayList<String> marks;
    private final ArrayList<String> phone;
    private final ArrayList<Integer> id;

    public SqliteListViewAdapter(Activity context, ArrayList<String>name, ArrayList<String> marks, ArrayList<String> phone,ArrayList<Integer> id) {
        super(context, R.layout.database_lv, name);
        this.context = context;
        this.name = name;
        this.marks = marks;
        this.phone = phone;
        this.id = id;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View view = inflater.inflate(R.layout.database_lv, null, true);
        TextView textName = (TextView) view.findViewById(R.id.db_name);
        TextView textMarks = (TextView) view.findViewById(R.id.db_marks);
        TextView textPhone = (TextView) view.findViewById(R.id.db_phone);
        TextView textId = (TextView) view.findViewById(R.id.db_id);

        textId.setText(String.valueOf(id.get(position)));
        textName.setText(name.get(position));
        textMarks.setText(marks.get(position));
        textPhone.setText(phone.get(position));
        return view;
    }
}
