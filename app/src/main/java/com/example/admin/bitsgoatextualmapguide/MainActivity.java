package com.example.admin.bitsgoatextualmapguide;
import android.graphics.ColorSpace;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import java.util.ArrayList;

import static android.graphics.ColorSpace.*;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ListViewAdapter adapter;
    String[] title;
    String[] description;
    int[] icon = new int[]{R.drawable.battery, R.drawable.cpu, R.drawable.display, R.drawable.memory, R.drawable.sensor};
    ArrayList<Model> arrayList = new ArrayList<Model>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Items List");

        title = new String[]{"Battery", "Cpu", "Display", "Memory", "Sensor"};
        description = new String[]{"Battery detail...", "Cpu detail...", "Display detail...", "Memory detail...", "Sensor detail..."};

        listView = findViewById(R.id.listView);

        for (int i =0; i<title.length; i++){
            ColorSpace.Model model = new ColorSpace.Model(title[i], description[i], icon[i]);
            arrayList.add(model);
        }
        adapter = new ListViewAdapter(this, arrayList);
        listView.setAdapter(adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);

        MenuItem myActionMenuItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView)myActionMenuItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                if (TextUtils.isEmpty(s)){
                    adapter.filter("");
                    listView.clearTextFilter();
                }
                else {
                    adapter.filter(s);
                }
                return true;
            }
        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id==R.id.action_settings){

            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}


