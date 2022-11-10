package com.improve10x.advanced;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<String> teamMembers = new ArrayList<>();
    Spinner namesSp;
    ArrayAdapter<String> listAdapter;
    ListView namesLv;
    TextInputEditText nameTxt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nameTxt = findViewById(R.id.name_txt);
        setupData();
        populateList();
        handleAdd();
        handleDelete();
    }

    private void handleAdd() {
        Button addBtn = findViewById(R.id.add_btn);
        addBtn.setOnClickListener(view -> {
            String member = nameTxt.getText().toString();
            listAdapter.add(member);
            listAdapter.notifyDataSetChanged();
        });
    }

    private void handleDelete() {
        Button deleteBtn = findViewById(R.id.delete_btn);
        deleteBtn.setOnClickListener(view -> {
            String member = nameTxt.getText().toString();
            listAdapter.remove(member);
            listAdapter.notifyDataSetChanged();
        });
    }

    private void populateList() {
        namesLv = findViewById(R.id.names_lv);
        listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, teamMembers);
        namesLv.setAdapter(listAdapter);
    }

    private void setupData() {
        teamMembers.add("Renuka");
        teamMembers.add("Vissu");
    }
}