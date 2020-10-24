package com.practical.work;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class Booklist extends AppCompatActivity {
    private RecyclerView bRecyclerview;
    private BookAdapter bAdapter;
    ArrayList<BooklistItem> bBookList;
    private RecyclerView.LayoutManager bLayoutmanager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booklist);
    }
        private void buildRecyclerView () {
            bRecyclerview = findViewById(R.id.recyclerview);
            bRecyclerview.setHasFixedSize(true);
            bLayoutmanager = new LinearLayoutManager(this);
            bAdapter = new BookAdapter(bBookList);
            bRecyclerview.setLayoutManager(bLayoutmanager);
            bRecyclerview.setAdapter(bAdapter);

        }
    }
