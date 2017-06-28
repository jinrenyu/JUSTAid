package com.example.android.justaid;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.example.android.justaid.info.BookInfo;

import org.litepal.crud.DataSupport;

import java.util.ArrayList;

public class LibraryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);

        Intent intent=getIntent();
        String stu_id=intent.getStringExtra("studentid");

        ArrayList<BookInfo> bookInfoArrayList= (ArrayList<BookInfo>) DataSupport.where("student_id=?",stu_id).find(BookInfo.class);

        /*BookInfo b1=new BookInfo("程序设计基础","张三","2017年1月31日","2017-2-15","134234","3526223");
        BookInfo b2=new BookInfo("程序设计基础","张三","2017年1月31日","2017-2-15","134234","3526223");
        BookInfo b3=new BookInfo("程序设计基础","张三","2017年1月31日","2017-2-15","134234","3526223");
        BookInfo b4=new BookInfo("程序设计基础","张三","2017年1月31日","2017-2-15","134234","3526223");
        BookInfo b5=new BookInfo("程序设计基础","张三","2017年1月31日","2017-2-15","134234","3526223");
        bookInfoArrayList.add(b1);
        bookInfoArrayList.add(b2);
        bookInfoArrayList.add(b3);
        bookInfoArrayList.add(b4);
        bookInfoArrayList.add(b5);*/
        ListView list = (ListView) findViewById(R.id.listView_lib);
        LibListAdapter lla = new LibListAdapter(this,bookInfoArrayList, null);
        list.setAdapter(lla);
    }
}
