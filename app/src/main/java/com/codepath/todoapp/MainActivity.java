package com.codepath.todoapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> todoItems;
    ArrayAdapter<String> aToDoAdapter;
    ListView lvItem;
    EditText etEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        populateArrayItems();
        lvItem = (ListView) findViewById(R.id.Items);
        lvItem.setAdapter(aToDoAdapter);
        etEditText = (EditText) findViewById(R.id.etEditText);
        lvItem.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position,
                                           long l) {
                todoItems.remove(position);
                aToDoAdapter.notifyDataSetChanged();
                return true;
            }
        });
    }

    public void populateArrayItems() {
        todoItems = new ArrayList<String>();
        todoItems.add("Item 1");
        todoItems.add("Item 2");
        todoItems.add("Item 3");
        aToDoAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, todoItems);

    }

    private void readItems() {
        File filesDir=getFilesDir();
        File file= new File(filesDir,"todo.txt");
        try {
            todoItems = new ArrayList<String>(FileUtils.readLines(file));
        }catch (IOException e) {

        }
    }

    public void onAddItem(View view) {
        aToDoAdapter.add(etEditText.getText().toString());
        etEditText.setText("");
    }
}
