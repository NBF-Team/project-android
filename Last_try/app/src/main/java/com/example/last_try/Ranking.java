package com.example.last_try;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Pair;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class Ranking extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);

        ListView listView = (ListView) findViewById(R.id.ranking_list_view);

        // get the list of all things to print
        // ArrayList<Pair<String,Integer>> rankingList = Utils.get_ranking();
        ArrayList<Pair<String,Integer>> rankingList = new ArrayList<>();
        rankingList.add(new Pair<>("Putin",70));
        rankingList.add(new Pair<>("Voronin",35));
        rankingList.add(new Pair<>("Trump",20));
        rankingList.add(new Pair<>("Putin",70));
        rankingList.add(new Pair<>("Voronin",35));
        rankingList.add(new Pair<>("Trump",20));
        rankingList.add(new Pair<>("Putin",70));
        rankingList.add(new Pair<>("Voronin",35));
        rankingList.add(new Pair<>("Trump",20));
        rankingList.add(new Pair<>("Putin",70));
        rankingList.add(new Pair<>("Voronin",35));
        rankingList.add(new Pair<>("Trump",20));
        rankingList.add(new Pair<>("Putin",70));
        rankingList.add(new Pair<>("Voronin",35));
        rankingList.add(new Pair<>("Trump",20));
        rankingList.add(new Pair<>("Putin",70));
        rankingList.add(new Pair<>("Voronin",35));
        rankingList.add(new Pair<>("Trump",20));
        rankingList.add(new Pair<>("Putin",70));
        rankingList.add(new Pair<>("Voronin",35));
        rankingList.add(new Pair<>("Trump",20));
        rankingList.add(new Pair<>("Putin",70));
        rankingList.add(new Pair<>("Voronin",35));
        rankingList.add(new Pair<>("Trump",20));
        rankingList.add(new Pair<>("Putin",70));
        rankingList.add(new Pair<>("Voronin",35));
        rankingList.add(new Pair<>("Trump",20));
        rankingList.add(new Pair<>("Putin",70));
        rankingList.add(new Pair<>("Voronin",35));
        rankingList.add(new Pair<>("Trump",20));
        rankingList.add(new Pair<>("Putin",70));
        rankingList.add(new Pair<>("Voronin",35));
        rankingList.add(new Pair<>("Trump",20));
        rankingList.add(new Pair<>("Putin",70));
        rankingList.add(new Pair<>("Voronin",35));
        rankingList.add(new Pair<>("Trump",20));
        rankingList.add(new Pair<>("Putin",70));
        rankingList.add(new Pair<>("Voronin",35));
        rankingList.add(new Pair<>("Trump",20));rankingList.add(new Pair<>("Putin",70));
        rankingList.add(new Pair<>("Voronin",35));
        rankingList.add(new Pair<>("Trump",20));rankingList.add(new Pair<>("Putin",70));
        rankingList.add(new Pair<>("Voronin",35));
        rankingList.add(new Pair<>("Trump",20));
        rankingList.add(new Pair<>("Putin",70));
        rankingList.add(new Pair<>("Voronin",35));
        rankingList.add(new Pair<>("Trump",20));
        rankingList.add(new Pair<>("Putin",70));
        rankingList.add(new Pair<>("Voronin",35));
        rankingList.add(new Pair<>("Trump",20));




        RankingArrayAdapter adapter = new RankingArrayAdapter(this, R.layout.adapter_view_layout, rankingList);
        listView.setAdapter(adapter);

    }

}
