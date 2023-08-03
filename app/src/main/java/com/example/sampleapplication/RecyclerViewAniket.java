package com.example.sampleapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAniket extends AppCompatActivity {
    RecyclerView rtecyclerview ;
    List<String> list=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_aniket);
       rtecyclerview=findViewById(R.id.rvmain);

       list.add("Aniket");
       list.add("Karpe");
        rtecyclerview.setLayoutManager(new LinearLayoutManager(this));
        rtecyclerview.setAdapter(new Adapter(list));
    }
}