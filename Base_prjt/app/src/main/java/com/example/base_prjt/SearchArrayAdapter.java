package com.example.base_prjt;

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

class SearchArrayAdapter extends ArrayAdapter<Pair<String, Integer>> {
    private Context mContext;
    int mResource;

    public SearchArrayAdapter(Context context, int resource, ArrayList<Pair<String, Integer>> objs){
        super(context, resource, objs);
        mContext = context;
        mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        String rank = Integer.toString(position+1);
        String name = getItem(position).first;
        String income = Integer.toString(getItem(position).second) + " RUB";

        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource, parent, false);

        TextView tvRank = (TextView) convertView.findViewById(R.id.search_rank);
        TextView tvName = (TextView) convertView.findViewById(R.id.search_name);
        TextView tvIncome = (TextView) convertView.findViewById(R.id.search_income);

        tvRank.setText(rank);
        tvName.setText(name);
        tvIncome.setText(income);

        return convertView;
    }
}
