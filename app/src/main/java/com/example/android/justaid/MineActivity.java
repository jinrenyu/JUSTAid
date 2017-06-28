package com.example.android.justaid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by jry on 2017/5/1.
 */

public class MineActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_mine);

       TextView txtviewName=(TextView) findViewById(R.id.textview_mine_name);

        Intent intent=getIntent();
        String myname=intent.getStringExtra("name");

        txtviewName.setText(myname);

         RelativeLayout rl1= (RelativeLayout) findViewById(R.id.layout_mine_personal);
        RelativeLayout rl2= (RelativeLayout) findViewById(R.id.layout_mine_card);
        RelativeLayout rl3= (RelativeLayout) findViewById(R.id.layout_mine_setting);
        rl1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent= new Intent(MineActivity.this,PersonalMessageActivity.class);
                startActivity(intent);
            }
        });

        rl2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent= new Intent(MineActivity.this,CardActivitty.class);
                startActivity(intent);
            }
        });

        rl3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent= new Intent(MineActivity.this,PersonalMessageActivity.class);
                startActivity(intent);
            }
        });


    }

}
