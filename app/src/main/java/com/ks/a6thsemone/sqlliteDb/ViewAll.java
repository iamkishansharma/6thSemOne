package com.ks.a6thsemone.sqlliteDb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.ks.a6thsemone.MainActivity;
import com.ks.a6thsemone.R;

import java.util.ArrayList;

public class ViewAll extends AppCompatActivity {

    DatabaseHelper myDb;
    ListView mListView;
    ArrayList<String> namesList = new ArrayList<>();
    ArrayList<String> marksList = new ArrayList<>();
    ArrayList<String> phoneList = new ArrayList<>();
    ArrayList<Integer> idList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all);


        mListView  = findViewById(R.id.sqlList);

        myDb = new DatabaseHelper(this);
        Cursor res = myDb.getAllData();

        if(res.getCount() == 0){
            Toast.makeText(ViewAll.this, "Nothing to Show", Toast.LENGTH_LONG).show();
        }else{

            while(res.moveToNext()){
                idList.add(res.getInt(0));
                namesList.add(res.getString(1));
                marksList.add(res.getString(2));
                phoneList.add(res.getString(3));
            }
        }

        final SqliteListViewAdapter adapter = new SqliteListViewAdapter(this, namesList, marksList, phoneList, idList);
          mListView.setAdapter(adapter);
//        registerForContextMenu(mListView);
        adapter.notifyDataSetChanged();

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ViewAll.this, namesList.get(position).toUpperCase(),Toast.LENGTH_SHORT).show();
            }
        });
        mListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(final AdapterView<?> parent, final View view, final int position, long id) {
                PopupMenu popup =  new PopupMenu(ViewAll.this, view);
                popup.getMenuInflater().inflate(R.menu.ex_menu, popup.getMenu());

                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.it1:
                                boolean check =myDb.deleteData(namesList.get(position));
                                if(check){
                                    Toast.makeText(ViewAll.this, namesList.get(position)+" Deleted",Toast.LENGTH_LONG).show();
                                }else {
                                    Toast.makeText(ViewAll.this, "Can't Delete", Toast.LENGTH_LONG).show();
                                }
                                break;
                            case R.id.it2:
                                Toast.makeText(ViewAll.this, "Hello " + item.getTitle().toString(), Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.it4:
                                Toast.makeText(ViewAll.this, "Hey " + item.getTitle().toString(), Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.it5:
                                Toast.makeText(ViewAll.this, "Sorry for " + item.getTitle().toString(), Toast.LENGTH_SHORT).show();
                                break;
                            default:
                                return false;
                        }
                        return true;
                    }
                });
                popup.show();//Menu in every Items
                return true;
            }
        });
    }
//
//    @Override
//    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
//        super.onCreateContextMenu(menu, v, menuInfo);
//        getMenuInflater().inflate(R.menu.ex_menu, menu);
//    }
//
//    @Override
//    public boolean onContextItemSelected(MenuItem item) {
//        switch (item.getItemId()){
//            case R.id.it1:
//                myDb.deleteData(1);
//                break;
//            case R.id.it2:
//                Toast.makeText(this, "Hello "+item.getTitle().toString(), Toast.LENGTH_SHORT).show();
//                break;
//            case R.id.it4:
//                Toast.makeText(this, "Hey "+item.getTitle().toString(), Toast.LENGTH_SHORT).show();
//                break;
//            case  R.id.it5:
//                Toast.makeText(this, "Sorry for "+item.getTitle().toString(),Toast.LENGTH_SHORT).show();
//                break;
//        }
//        return super.onContextItemSelected(item);
//    }
}
