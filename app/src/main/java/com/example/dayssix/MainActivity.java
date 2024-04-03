package com.example.dayssix;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.io.Serializable;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvitem;
    private AdapterList adapterList;
    private ArrayList<ListModel> listModels;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getData();

        rvitem = findViewById(R.id.rvItem);
        adapterList = new AdapterList(listModels);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        rvitem.setLayoutManager(layoutManager);
        rvitem.setAdapter(adapterList);


        adapterList.setOnItemClickListener(new AdapterList.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent intent = new Intent(MainActivity.this,DetailMain.class);
                ListModel clickItem = listModels.get(position);
                intent.putExtra(DetailMain.KEY_DATA, clickItem);
                startActivity(intent);
            }
        });
    }

    private void getData() {
        listModels = new ArrayList<>();
        listModels.add(new ListModel("Thibaut Courtois", R.drawable.courtois,"31","Belgium","$.1000"));
        listModels.add(new ListModel("Andriy lunin", R.drawable.andriy,"25","Ukraine","$ 200"));
        listModels.add(new ListModel("Kepa Arrizabalaga", R.drawable.kepa,"29","Spain","$ 500"));
        listModels.add(new ListModel("Eder Militao", R.drawable.militao,"26","Brazil","$ 120"));
        listModels.add(new ListModel("David Alaba", R.drawable.alba,"31","Austria","$ 300"));
        listModels.add(new ListModel("Nacho Fernandez", R.drawable.nacho,"34","Spain","$100"));
        listModels.add(new ListModel("Ferland Mendy", R.drawable.mendy,"28","France","122"));
        listModels.add(new ListModel("Daniel Carvajal", R.drawable.carvajal,"32","Spain","120"));
        listModels.add(new ListModel("Lucas Vazquez", R.drawable.lucas,"32","Spain","234"));
        listModels.add(new ListModel("Federico valverde", R.drawable.valvarde,"25","Uruguay","3123"));
        listModels.add(new ListModel("Eduardo Camavinga", R.drawable.camavinga,"21","France","321312"));
        listModels.add(new ListModel("Toni Kroos", R.drawable.toni,"34","German","32312"));
        listModels.add(new ListModel("Luka Modric", R.drawable.modric,"38","Croatia","32132"));
        listModels.add(new ListModel("Jude Bellingham", R.drawable.jude,"20","England","3123"));
        listModels.add(new ListModel("vinicius Junior", R.drawable.vini,"23","Brazil","32132"));
        listModels.add(new ListModel("Rodrygo", R.drawable.rodrygo,"23","Brazil","231"));

    }

}