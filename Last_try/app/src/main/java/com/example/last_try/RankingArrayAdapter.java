package com.example.last_try;

import android.content.Context;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class RankingArrayAdapter extends ArrayAdapter<Pair<String, Integer>> {
    private Context mContext;
    int mResource;

    public RankingArrayAdapter(Context context, int resource, ArrayList<Pair<String, Integer>> objs){
        super(context, resource, objs);
        mContext = context;
        mResource = resource;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        String rank = Integer.toString(position+1);
        String name = getItem(position).first;
        String percentage = Integer.toString(getItem(position).second) + "%";

        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource, parent, false);

        TextView tvRank = (TextView) convertView.findViewById(R.id.ranking_rank);
        TextView tvName = (TextView) convertView.findViewById(R.id.ranking_name);
        TextView tvPercentage = (TextView) convertView.findViewById(R.id.ranking_percent);

        tvRank.setText(rank);
        tvName.setText(name);
        tvPercentage.setText(percentage);

        return convertView;
    }
}
