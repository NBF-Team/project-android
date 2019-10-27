package com.example.base_prjt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Pair;
import android.widget.ListView;

import java.util.ArrayList;

public class Search extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        ListView listView = (ListView) findViewById(R.id.search_list_view);

        // get the list of all things to print
        // ArrayList<Pair<String,Integer>> searchingList = Utils.get_result();
        ArrayList<Pair<String,Integer>> searchingList = new ArrayList<>();
        searchingList.add(Pair.create("Putin", 23000));
        searchingList.add(Pair.create("Trump", 550000));
        searchingList.add(Pair.create("Reagan", 200));
        searchingList.add(Pair.create("Putic", 23));
        searchingList.add(Pair.create("Putin", 23000));
        searchingList.add(Pair.create("Trump", 550000));
        searchingList.add(Pair.create("Reagan", 200));
        searchingList.add(Pair.create("Putic", 23));searchingList.add(Pair.create("Putin", 23000));
        searchingList.add(Pair.create("Trump", 550000));
        searchingList.add(Pair.create("Reagan", 200));
        searchingList.add(Pair.create("Putic", 23));
        searchingList.add(Pair.create("Putin", 23000));
        searchingList.add(Pair.create("Trump", 550000));
        searchingList.add(Pair.create("Reagan", 200));
        searchingList.add(Pair.create("Putic", 23));
        searchingList.add(Pair.create("Putin", 23000));
        searchingList.add(Pair.create("Trump", 550000));
        searchingList.add(Pair.create("Reagan", 200));
        searchingList.add(Pair.create("Putic", 23));
        searchingList.add(Pair.create("Putin", 23000));
        searchingList.add(Pair.create("Trump", 550000));
        searchingList.add(Pair.create("Reagan", 200));
        searchingList.add(Pair.create("Putic", 23));
        searchingList.add(Pair.create("Putin", 23000));
        searchingList.add(Pair.create("Trump", 550000));
        searchingList.add(Pair.create("Reagan", 200));
        searchingList.add(Pair.create("Putic", 23));
        searchingList.add(Pair.create("Putin", 23000));
        searchingList.add(Pair.create("Trump", 550000));
        searchingList.add(Pair.create("Reagan", 200));
        searchingList.add(Pair.create("Putic", 23));
        searchingList.add(Pair.create("Putin", 23000));
        searchingList.add(Pair.create("Trump", 550000));
        searchingList.add(Pair.create("Reagan", 200));
        searchingList.add(Pair.create("Putic", 23));searchingList.add(Pair.create("Putin", 23000));
        searchingList.add(Pair.create("Trump", 550000));
        searchingList.add(Pair.create("Reagan", 200));
        searchingList.add(Pair.create("Putic", 23));searchingList.add(Pair.create("Putin", 23000));
        searchingList.add(Pair.create("Trump", 550000));
        searchingList.add(Pair.create("Reagan", 200));
        searchingList.add(Pair.create("Putic", 23));
        searchingList.add(Pair.create("Putin", 23000));
        searchingList.add(Pair.create("Trump", 550000));
        searchingList.add(Pair.create("Reagan", 200));
        searchingList.add(Pair.create("Putic", 23));


        SearchArrayAdapter adapter = new SearchArrayAdapter(this,
                R.layout.adapter_search_layout, searchingList);
        listView.setAdapter(adapter);
    }
}
