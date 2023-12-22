package com.example.todoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<String> toDolist;
    ArrayAdapter <String> arrayAdapter;
    ListView listView;
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toDolist = new ArrayList<>();
        arrayAdapter = new ArrayAdapter<>(this,R.layout.list_view_layout,toDolist);
                listView = findViewById(R.id.list_view);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                TextView textView =(TextView) view;
                textView.setPaintFlags(textView.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
            }
        });
                editText = findViewById(R.id.edit_text);
    }

    public void AddTask(View view){
        toDolist.add(editText.getText().toString());
        arrayAdapter.notifyDataSetChanged();
        editText.setText("");
    }
}