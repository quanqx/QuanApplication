package com.example.quand.quanapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.daimajia.swipe.util.Attributes;

import java.text.AttributedCharacterIterator;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView(){
        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linear = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        DividerItemDecoration divider = new DividerItemDecoration(this, linear.getOrientation());
        recyclerView.addItemDecoration(divider);
        recyclerView.setLayoutManager(linear);
        ArrayList<Item> items = new ArrayList<>();
        items.add(new Item(R.drawable.apple, "Apple"));
        items.add(new Item(R.drawable.htc, "HTC"));
        items.add(new Item(R.drawable.huewei, "Huewei"));
        items.add(new Item(R.drawable.oppo, "Oppo"));
        items.add(new Item(R.drawable.samsung, "Samsung"));
        ItemAdapter adapter = new ItemAdapter(this, items);
        adapter.setMode(Attributes.Mode.Multiple);
        recyclerView.setAdapter(adapter);
    }
}
