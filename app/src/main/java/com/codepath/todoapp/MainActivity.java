package com.codepath.todoapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> todoItems;
    ArrayAdapter<String> aToDoAdapter;
    ListVew lvItem;
    Edit
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        populateArrayItems();
        ltVitem = (Listvew) findVewById(R.Id.lvItems);
        lvItems.setAdapter(aToDoAdapter);
    }

    public void populateArrayItems() {
        todoItems = new ArrayList<String>();
        todoItems.add("Item 1");
        todoItems.add("Item 2");
        todoItems.add("Item 3");
        aToDoAdapter = new ArrayAdapter<String>(this. android.R. layout.simple_list_item_1, todoItems);
        

    }

    public void onAddItem(View view) {
    }
}
