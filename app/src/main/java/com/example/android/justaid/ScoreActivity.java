package com.example.android.justaid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.justaid.info.BookInfo;
import com.example.android.justaid.info.Score;

import org.litepal.crud.DataSupport;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class ScoreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        Intent intent=getIntent();
        String stu_id=intent.getStringExtra("studentid");

        ArrayList<Score> scoreArrayList= (ArrayList<Score>) DataSupport.where("student_id=?",stu_id).find(Score.class);

        /*Score sc1=new Score("2017-05-01","程序设计","75","2.9");
        Score sc2=new Score("2017-05-01","程序设计","75","2.9");
        Score sc3=new Score("2017-05-01","程序设计","75","2.9");
        Score sc4=new Score("2017-05-01","程序设计","75","2.9");
        Score sc5=new Score("2017-05-01","程序设计","75","2.9");
        Score sc6=new Score("2017-05-01","程序设计","75","2.9");
        Score sc7=new Score("2017-05-01","程序设计","75","2.9");
        scoreArrayList.add(sc1);
        scoreArrayList.add(sc2);
        scoreArrayList.add(sc3);
        scoreArrayList.add(sc4);
        scoreArrayList.add(sc5);
        scoreArrayList.add(sc6);
        scoreArrayList.add(sc7);*/
        ListView list = (ListView) findViewById(R.id.listView_Score);
        ScoreListAdapter sla = new ScoreListAdapter(this,scoreArrayList);
        list.setAdapter(sla);

        double xf=0;
        double jd=0;

        for(Score s:scoreArrayList){
            jd+=((Double.parseDouble(s.getMyscore())/10)-5)*Double.parseDouble(s.getXuefen());
            xf+=Double.parseDouble(s.getXuefen());

        }
        //Toast.makeText(this, "jd:"+jd, Toast.LENGTH_SHORT).show();

        DecimalFormat df=new DecimalFormat("#.00");
        double d=jd/xf;
        String st=df.format(d);
        TextView tv= (TextView) findViewById(R.id.tv_score_xxj);
        tv.setText(st);

    }
}
