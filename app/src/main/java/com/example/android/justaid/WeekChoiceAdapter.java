package com.example.android.justaid;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 浩然 on 2017-4-16.
 */

public class WeekChoiceAdapter extends BaseAdapter {
    private Context context;
    List<String> weekList=new ArrayList<>();

    public WeekChoiceAdapter(Context context) {
        this.context = context;
        for(int i=1;i<=25;i++){
            String week="第"+String.valueOf(i)+"周";
            weekList.add(week);
        }

    }

    @Override
    public int getCount() {
        return weekList.size();
    }

    @Override
    public Object getItem(int position) {
        return weekList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return (long)position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater=LayoutInflater.from(context);
        LinearLayout linearLayout=(LinearLayout)inflater.inflate(R.layout.week_item,null);
        TextView textView=(TextView)linearLayout.getChildAt(0);
        textView.setText(weekList.get(position));
        return linearLayout;
    }

}