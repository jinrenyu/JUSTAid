package com.example.android.justaid;


import android.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Toast;


public class ClassRoomActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classroom);

        CardView cv1=(CardView) findViewById(R.id.buildingA);
        CardView cv2=(CardView) findViewById(R.id.buildingB);
        CardView cv3=(CardView) findViewById(R.id.buildingC);
        CardView cv4=(CardView) findViewById(R.id.buildingD);
        cv1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
               // Toast.makeText(ClassRoomActivity.this,"教学楼A区",Toast.LENGTH_SHORT).show();
                AlertDialog.Builder builder = new AlertDialog.Builder(ClassRoomActivity.this);
                builder.setTitle("空闲教室信息");
                builder.setMessage("A101,A102,A304,A202");
                builder.show();

            }
        });

        cv2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //Toast.makeText(ClassRoomActivity.this,"教学楼B区",Toast.LENGTH_SHORT).show();
                AlertDialog.Builder builder = new AlertDialog.Builder(ClassRoomActivity.this);
                builder.setTitle("空闲教室信息");
                builder.setMessage("B105,B203,B504");
                builder.show();
            }
        });

        cv3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //Toast.makeText(ClassRoomActivity.this,"教学楼C区",Toast.LENGTH_SHORT).show();
                AlertDialog.Builder builder = new AlertDialog.Builder(ClassRoomActivity.this);
                builder.setTitle("空闲教室信息");
                builder.setMessage("C105,C203,C504");
                builder.show();
            }
        });

        cv4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //Toast.makeText(ClassRoomActivity.this,"教学楼D区",Toast.LENGTH_SHORT).show();
                AlertDialog.Builder builder = new AlertDialog.Builder(ClassRoomActivity.this);
                builder.setTitle("空闲教室信息");
                builder.setMessage("D105,D203,D504");
                builder.show();
            }
        });
    }
}
