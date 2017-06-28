package com.example.android.justaid;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.android.justaid.info.Score;

import java.util.ArrayList;

/**
 * Created by jry on 2017/4/25.
 */

public class ScoreListAdapter extends BaseAdapter {


    private Context context;
    private ArrayList<Score> scoreList;

    public ScoreListAdapter(Context context, ArrayList<Score> scoreList) {
        this.context = context;
        this.scoreList = scoreList;
    }

    @Override
    public int getCount() {
        return scoreList.size();
    }

    @Override
    public Object getItem(int position) {
        return scoreList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return (long) position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(context);
        LinearLayout linearLayout = (LinearLayout) inflater.inflate(R.layout.score_item, null);
        TextView textViewDate = (TextView) linearLayout.getChildAt(0);
        TextView textViewcoursename = (TextView) linearLayout.getChildAt(1);
        TextView textViewmyscore = (TextView) linearLayout.getChildAt(2);
        TextView textViewxuefen = (TextView) linearLayout.getChildAt(3);
        textViewDate.setText(this.scoreList.get(position).getDate());
        textViewcoursename.setText(this.scoreList.get(position).getCoursename());
        textViewmyscore.setText(this.scoreList.get(position).getMyscore());
        textViewxuefen.setText(this.scoreList.get(position).getXuefen());
        return linearLayout;
    }
}
