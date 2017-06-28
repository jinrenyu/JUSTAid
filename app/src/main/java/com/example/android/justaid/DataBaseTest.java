package com.example.android.justaid;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


import com.example.android.justaid.info.BookInfo;
import com.example.android.justaid.info.Score;
import com.example.android.justaid.info.Student;

import org.litepal.crud.DataSupport;
import org.litepal.tablemanager.Connector;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by jry on 2017/4/30.
 */

public class DataBaseTest extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_databasetest);

        Button createDatabase= (Button) findViewById(R.id.create_database);
        Button addData= (Button) findViewById(R.id.add_data);
        createDatabase.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Connector.getDatabase();
                Toast.makeText(DataBaseTest.this,"ok",Toast.LENGTH_SHORT).show();
            }
        });
        addData.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                DataSupport.deleteAll(Score.class);
                DataSupport.deleteAll(BookInfo.class);
                DataSupport.deleteAll(Student.class);

                Student s1=new Student();
                s1.setStudentId(1345747219);
                s1.setName("曹靖");
                s1.setPassword("1345747219");
                s1.save();

                Student s2=new Student();
                s2.setStudentId(1345747220);
                s2.setName("陈粤");
                s2.setPassword("1345747220");
                s2.save();

                Student s3=new Student();
                s3.setStudentId(1345747221);
                s3.setName("江浩然");
                s3.setPassword("1345747221");
                s3.save();

                Student s4=new Student();
                s4.setStudentId(1345747222);
                s4.setName("金仁雨");
                s4.setPassword("1345747222");
                List<Score> list4=new ArrayList<Score>();
                Score s4score=new Score();
                //s4score.setDate();
                s4.setScoreList(list4);
                s4.save();

                Student s5=new Student();
                s5.setStudentId(1345747223);
                s5.setName("李玉庆");
                s5.setPassword("1345747223");
                s5.save();

                Student s6=new Student();
                s6.setStudentId(1345747224);
                s6.setName("阮涛磊");
                s6.setPassword("1345747224");
                s6.save();


                //1345747219同学的成绩
                Score sc1=new Score();
                sc1.setDate("2016-6-25");
                sc1.setCoursename("高等数学1");
                sc1.setMyscore("89");
                sc1.setXuefen("4");
                sc1.setStudent_id(1345747219);
                sc1.save();

                Score sc2=new Score();
                sc2.setDate("2016-6-25");
                sc2.setCoursename("大学英语1");
                sc2.setMyscore("66");
                sc2.setXuefen("4.5");
                sc2.setStudent_id(1345747219);
                sc2.save();

                Score sc3=new Score();
                sc3.setDate("2016-6-26");
                sc3.setCoursename("计算机信息技术基础");
                sc3.setMyscore("73");
                sc3.setXuefen("2");
                sc3.setStudent_id(1345747219);
                sc3.save();

                Score sc4=new Score();
                sc4.setDate("2016-6-26");
                sc4.setCoursename("马克思主义基本原理");
                sc4.setMyscore("75");
                sc4.setXuefen("3");
                sc4.setStudent_id(1345747219);
                sc4.save();

                Score sc5=new Score();
                sc5.setDate("2016-6-27");
                sc5.setCoursename("中国近代史纲要");
                sc5.setMyscore("81");
                sc5.setXuefen("2");
                sc5.setStudent_id(1345747219);
                sc5.save();

                Score sc6=new Score();
                sc6.setDate("2016-6-27");
                sc6.setCoursename("计算机程序设计语言");
                sc6.setMyscore("65");
                sc6.setXuefen("4.5");
                sc6.setStudent_id(1345747219);
                sc6.save();

                Score sc7=new Score();
                sc7.setDate("2016-6-28");
                sc7.setCoursename("管理学");
                sc7.setMyscore("79");
                sc7.setXuefen("3");
                sc7.setStudent_id(1345747219);
                sc7.save();

                Score sc8=new Score();
                sc8.setDate("2016-6-28");
                sc8.setCoursename("微观经济学");
                sc8.setMyscore("81");
                sc8.setXuefen("3");
                sc8.setStudent_id(1345747219);
                sc8.save();

                Score sc9=new Score();
                sc9.setDate("2016-6-29");
                sc9.setCoursename("管理信息系统");
                sc9.setMyscore("84");
                sc9.setXuefen("3");
                sc9.setStudent_id(1345747219);
                sc9.save();

                Score sc10=new Score();
                sc10.setDate("2016-6-29");
                sc10.setCoursename("运筹学");
                sc10.setMyscore("61");
                sc10.setXuefen("4");
                sc10.setStudent_id(1345747219);
                sc10.save();


                //1345747220成绩
                Score chensc1=new Score();
                chensc1.setDate("2016-6-25");
                chensc1.setCoursename("高等数学1");
                chensc1.setMyscore("78");
                chensc1.setXuefen("4");
                chensc1.setStudent_id(1345747220);
                chensc1.save();

                Score chensc2=new Score();
                chensc2.setDate("2016-6-25");
                chensc2.setCoursename("大学英语1");
                chensc2.setMyscore("80");
                chensc2.setXuefen("4.5");
                chensc2.setStudent_id(1345747220);
                chensc2.save();

                Score chensc3=new Score();
                chensc3.setDate("2016-6-26");
                chensc3.setCoursename("计算机信息技术基础");
                chensc3.setMyscore("71");
                chensc3.setXuefen("2");
                chensc3.setStudent_id(1345747220);
                chensc3.save();

                Score chensc4=new Score();
                chensc4.setDate("2016-6-26");
                chensc4.setCoursename("马克思主义基本原理");
                chensc4.setMyscore("70");
                chensc4.setXuefen("3");
                chensc4.setStudent_id(1345747220);
                chensc4.save();

                Score chensc5=new Score();
                chensc5.setDate("2016-6-27");
                chensc5.setCoursename("中国近代史纲要");
                chensc5.setMyscore("77");
                chensc5.setXuefen("2");
                chensc5.setStudent_id(1345747220);
                chensc5.save();

                Score chensc6=new Score();
                chensc6.setDate("2016-6-27");
                chensc6.setCoursename("计算机程序设计语言");
                chensc6.setMyscore("69");
                chensc6.setXuefen("4.5");
                chensc6.setStudent_id(1345747220);
                chensc6.save();

                Score chensc7=new Score();
                chensc7.setDate("2016-6-28");
                chensc7.setCoursename("管理学");
                chensc7.setMyscore("76");
                chensc7.setXuefen("3");
                chensc7.setStudent_id(1345747220);
                chensc7.save();

                Score chensc8=new Score();
                chensc8.setDate("2016-6-28");
                chensc8.setCoursename("微观经济学");
                chensc8.setMyscore("80");
                chensc8.setXuefen("3");
                chensc8.setStudent_id(1345747220);
                chensc8.save();

                Score chensc9=new Score();
                chensc9.setDate("2016-6-29");
                chensc9.setCoursename("管理信息系统");
                chensc9.setMyscore("79");
                chensc9.setXuefen("3");
                chensc9.setStudent_id(1345747220);
                chensc9.save();

                Score chensc10=new Score();
                chensc10.setDate("2016-6-29");
                chensc10.setCoursename("运筹学");
                chensc10.setMyscore("69");
                chensc10.setXuefen("4");
                chensc10.setStudent_id(1345747220);
                chensc10.save();


                //1345747221成绩
                Score jigsc1=new Score();
                jigsc1.setDate("2016-6-25");
                jigsc1.setCoursename("高等数学1");
                jigsc1.setMyscore("66");
                jigsc1.setXuefen("4");
                jigsc1.setStudent_id(1345747221);
                jigsc1.save();

                Score jigsc2=new Score();
                jigsc2.setDate("2016-6-25");
                jigsc2.setCoursename("大学英语1");
                jigsc2.setMyscore("77");
                jigsc2.setXuefen("4.5");
                jigsc2.setStudent_id(1345747221);
                jigsc2.save();

                Score jigsc3=new Score();
                jigsc3.setDate("2016-6-26");
                jigsc3.setCoursename("计算机信息技术基础");
                jigsc3.setMyscore("70");
                jigsc3.setXuefen("2");
                jigsc3.setStudent_id(1345747221);
                jigsc3.save();

                Score jigsc4=new Score();
                jigsc4.setDate("2016-6-26");
                jigsc4.setCoursename("马克思主义基本原理");
                jigsc4.setMyscore("81");
                jigsc4.setXuefen("3");
                jigsc4.setStudent_id(1345747221);
                jigsc4.save();

                Score jigsc5=new Score();
                jigsc5.setDate("2016-6-27");
                jigsc5.setCoursename("中国近代史纲要");
                jigsc5.setMyscore("77");
                jigsc5.setXuefen("2");
                jigsc5.setStudent_id(1345747221);
                jigsc5.save();

                Score jigsc6=new Score();
                jigsc6.setDate("2016-6-27");
                jigsc6.setCoursename("计算机程序设计语言");
                jigsc6.setMyscore("73");
                jigsc6.setXuefen("4.5");
                jigsc6.setStudent_id(1345747221);
                jigsc6.save();

                Score jigsc7=new Score();
                jigsc7.setDate("2016-6-28");
                jigsc7.setCoursename("管理学");
                jigsc7.setMyscore("76");
                jigsc7.setXuefen("3");
                jigsc7.setStudent_id(1345747221);
                jigsc7.save();

                Score jigsc8=new Score();
                jigsc8.setDate("2016-6-28");
                jigsc8.setCoursename("微观经济学");
                jigsc8.setMyscore("73");
                jigsc8.setXuefen("3");
                jigsc8.setStudent_id(1345747221);
                jigsc8.save();

                Score jigsc9=new Score();
                jigsc9.setDate("2016-6-29");
                jigsc9.setCoursename("管理信息系统");
                jigsc9.setMyscore("82");
                jigsc9.setXuefen("3");
                jigsc9.setStudent_id(1345747221);
                jigsc9.save();

                Score jigsc10=new Score();
                jigsc10.setDate("2016-6-29");
                jigsc10.setCoursename("运筹学");
                jigsc10.setMyscore("65");
                jigsc10.setXuefen("4");
                jigsc10.setStudent_id(1345747221);
                jigsc10.save();


                //1345747222成绩
                Score jinsc1=new Score();
                jinsc1.setDate("2016-6-25");
                jinsc1.setCoursename("高等数学1");
                jinsc1.setMyscore("81");
                jinsc1.setXuefen("4");
                jinsc1.setStudent_id(1345747222);
                jinsc1.save();

                Score jinsc2=new Score();
                jinsc2.setDate("2016-6-25");
                jinsc2.setCoursename("大学英语1");
                jinsc2.setMyscore("76");
                jinsc2.setXuefen("4.5");
                jinsc2.setStudent_id(1345747222);
                jinsc2.save();

                Score jinsc3=new Score();
                jinsc3.setDate("2016-6-26");
                jinsc3.setCoursename("计算机信息技术基础");
                jinsc3.setMyscore("71");
                jinsc3.setXuefen("2");
                jinsc3.setStudent_id(1345747222);
                jinsc3.save();

                Score jinsc4=new Score();
                jinsc4.setDate("2016-6-26");
                jinsc4.setCoursename("马克思主义基本原理");
                jinsc4.setMyscore("77");
                jinsc4.setXuefen("3");
                jinsc4.setStudent_id(1345747222);
                jinsc4.save();

                Score jinsc5=new Score();
                jinsc5.setDate("2016-6-27");
                jinsc5.setCoursename("中国近代史纲要");
                jinsc5.setMyscore("74");
                jinsc5.setXuefen("2");
                jinsc5.setStudent_id(1345747222);
                jinsc5.save();

                Score jinsc6=new Score();
                jinsc6.setDate("2016-6-27");
                jinsc6.setCoursename("计算机程序设计语言");
                jinsc6.setMyscore("75");
                jinsc6.setXuefen("4.5");
                jinsc6.setStudent_id(1345747222);
                jinsc6.save();

                Score jinsc7=new Score();
                jinsc7.setDate("2016-6-28");
                jinsc7.setCoursename("管理学");
                jinsc7.setMyscore("78");
                jinsc7.setXuefen("3");
                jinsc7.setStudent_id(1345747222);
                jinsc7.save();

                Score jinsc8=new Score();
                jinsc8.setDate("2016-6-28");
                jinsc8.setCoursename("微观经济学");
                jinsc8.setMyscore("76");
                jinsc8.setXuefen("3");
                jinsc8.setStudent_id(1345747222);
                jinsc8.save();

                Score jinsc9=new Score();
                jinsc9.setDate("2016-6-29");
                jinsc9.setCoursename("管理信息系统");
                jinsc9.setMyscore("79");
                jinsc9.setXuefen("3");
                jinsc9.setStudent_id(1345747222);
                jinsc9.save();

                Score jinsc10=new Score();
                jinsc10.setDate("2016-6-29");
                jinsc10.setCoursename("运筹学");
                jinsc10.setMyscore("66");
                jinsc10.setXuefen("4");
                jinsc10.setStudent_id(1345747222);
                jinsc10.save();


                //1345747223成绩
                Score lisc1=new Score();
                lisc1.setDate("2016-6-25");
                lisc1.setCoursename("高等数学1");
                lisc1.setMyscore("80");
                lisc1.setXuefen("4");
                lisc1.setStudent_id(1345747223);
                lisc1.save();

                Score lisc2=new Score();
                lisc2.setDate("2016-6-25");
                lisc2.setCoursename("大学英语1");
                lisc2.setMyscore("71");
                lisc2.setXuefen("4.5");
                lisc2.setStudent_id(1345747223);
                lisc2.save();

                Score lisc3=new Score();
                lisc3.setDate("2016-6-26");
                lisc3.setCoursename("计算机信息技术基础");
                lisc3.setMyscore("76");
                lisc3.setXuefen("2");
                lisc3.setStudent_id(1345747223);
                lisc3.save();

                Score lisc4=new Score();
                lisc4.setDate("2016-6-26");
                lisc4.setCoursename("马克思主义基本原理");
                lisc4.setMyscore("73");
                lisc4.setXuefen("3");
                lisc4.setStudent_id(1345747223);
                lisc4.save();

                Score lisc5=new Score();
                lisc5.setDate("2016-6-27");
                lisc5.setCoursename("中国近代史纲要");
                lisc5.setMyscore("73");
                lisc5.setXuefen("2");
                lisc5.setStudent_id(1345747223);
                lisc5.save();

                Score lisc6=new Score();
                lisc6.setDate("2016-6-27");
                lisc6.setCoursename("计算机程序设计语言");
                lisc6.setMyscore("74");
                lisc6.setXuefen("4.5");
                lisc6.setStudent_id(1345747223);
                lisc6.save();

                Score lisc7=new Score();
                lisc7.setDate("2016-6-28");
                lisc7.setCoursename("管理学");
                lisc7.setMyscore("76");
                lisc7.setXuefen("3");
                lisc7.setStudent_id(1345747223);
                lisc7.save();

                Score lisc8=new Score();
                lisc8.setDate("2016-6-28");
                lisc8.setCoursename("微观经济学");
                lisc8.setMyscore("71");
                lisc8.setXuefen("3");
                lisc8.setStudent_id(1345747223);
                lisc8.save();

                Score lisc9=new Score();
                lisc9.setDate("2016-6-29");
                lisc9.setCoursename("管理信息系统");
                lisc9.setMyscore("77");
                lisc9.setXuefen("3");
                lisc9.setStudent_id(1345747223);
                lisc9.save();

                Score lisc10=new Score();
                lisc10.setDate("2016-6-29");
                lisc10.setCoursename("运筹学");
                lisc10.setMyscore("69");
                lisc10.setXuefen("4");
                lisc10.setStudent_id(1345747223);
                lisc10.save();



                //1345747224成绩
                Score ruasc1=new Score();
                ruasc1.setDate("2016-6-25");
                ruasc1.setCoursename("高等数学1");
                ruasc1.setMyscore("81");
                ruasc1.setXuefen("4");
                ruasc1.setStudent_id(1345747224);
                ruasc1.save();

                Score ruasc2=new Score();
                ruasc2.setDate("2016-6-25");
                ruasc2.setCoursename("大学英语1");
                ruasc2.setMyscore("70");
                ruasc2.setXuefen("4.5");
                ruasc2.setStudent_id(1345747224);
                ruasc2.save();

                Score ruasc3=new Score();
                ruasc3.setDate("2016-6-26");
                ruasc3.setCoursename("计算机信息技术基础");
                ruasc3.setMyscore("73");
                ruasc3.setXuefen("2");
                ruasc3.setStudent_id(1345747224);
                ruasc3.save();

                Score ruasc4=new Score();
                ruasc4.setDate("2016-6-26");
                ruasc4.setCoursename("马克思主义基本原理");
                ruasc4.setMyscore("71");
                ruasc4.setXuefen("3");
                ruasc4.setStudent_id(1345747224);
                ruasc4.save();

                Score ruasc5=new Score();
                ruasc5.setDate("2016-6-27");
                ruasc5.setCoursename("中国近代史纲要");
                ruasc5.setMyscore("79");
                ruasc5.setXuefen("2");
                ruasc5.setStudent_id(1345747224);
                ruasc5.save();

                Score ruasc6=new Score();
                ruasc6.setDate("2016-6-27");
                ruasc6.setCoursename("计算机程序设计语言");
                ruasc6.setMyscore("77");
                ruasc6.setXuefen("4.5");
                ruasc6.setStudent_id(1345747224);
                ruasc6.save();

                Score ruasc7=new Score();
                ruasc7.setDate("2016-6-28");
                ruasc7.setCoursename("管理学");
                ruasc7.setMyscore("72");
                ruasc7.setXuefen("3");
                ruasc7.setStudent_id(1345747224);
                ruasc7.save();

                Score ruasc8=new Score();
                ruasc8.setDate("2016-6-28");
                ruasc8.setCoursename("微观经济学");
                ruasc8.setMyscore("78");
                ruasc8.setXuefen("3");
                ruasc8.setStudent_id(1345747224);
                ruasc8.save();

                Score ruasc9=new Score();
                ruasc9.setDate("2016-6-29");
                ruasc9.setCoursename("管理信息系统");
                ruasc9.setMyscore("75");
                ruasc9.setXuefen("3");
                ruasc9.setStudent_id(1345747224);
                ruasc9.save();

                Score ruasc10=new Score();
                ruasc10.setDate("2016-6-29");
                ruasc10.setCoursename("运筹学");
                ruasc10.setMyscore("77");
                ruasc10.setXuefen("4");
                ruasc10.setStudent_id(1345747224);
                ruasc10.save();

                //1345747219借书
                BookInfo b1=new BookInfo();
                b1.setBookName("计算机导论");
                b1.setAuthorName("陈明");
                b1.setReturnDate("2017-6-21");
                b1.setStudent_id(1345747219);
                b1.save();

                BookInfo b2=new BookInfo();
                b2.setBookName("Java2实用教程");
                b2.setAuthorName("耿祥义");
                b2.setReturnDate("2017-6-11");
                b2.setStudent_id(1345747219);
                b2.save();

                //1345747220借书
                BookInfo chenb1=new BookInfo();
                chenb1.setBookName("Visual C++面向对象与可视化程序设计（第3版）");
                chenb1.setAuthorName("黄维通");
                chenb1.setReturnDate("2017-9-15");
                chenb1.setStudent_id(1345747220);
                chenb1.save();

                BookInfo chenb2=new BookInfo();
                chenb2.setBookName("Java Programming");
                chenb2.setAuthorName("Poo Danny Singapore Associate");
                chenb2.setReturnDate("2017-8-2");
                chenb2.setStudent_id(1345747220);
                chenb2.save();

                //1345747221借书
                BookInfo jigb1=new BookInfo();
                jigb1.setBookName("标准C程序设计（第5版）");
                jigb1.setAuthorName("E Balagurusamy  著  金名 等译");
                jigb1.setReturnDate("2017-4-6");
                jigb1.setStudent_id(1345747221);
                jigb1.save();


                BookInfo jigb2=new BookInfo();
                jigb2.setBookName("数据结构（C语言版）（配光盘）");
                jigb2.setAuthorName("严蔚敏 等 编著");
                jigb2.setReturnDate("2017-5-15");
                jigb2.setStudent_id(1345747221);
                jigb2.save();

                BookInfo jigb3=new BookInfo();
                jigb3.setBookName("计算机组成与结构（第5版）");
                jigb3.setAuthorName("王爱英");
                jigb3.setReturnDate("2017-6-22");
                jigb3.setStudent_id(1345747221);
                jigb3.save();


                BookInfo jinb1=new BookInfo();
                jinb1.setBookName("计算机系统结构教程");
                jinb1.setAuthorName("张晨曦");
                jinb1.setReturnDate("2017-3-2");
                jinb1.setStudent_id(1345747222);
                jinb1.save();


                BookInfo jinb2=new BookInfo();
                jinb2.setBookName("现代计算机体系结构");
                jinb2.setAuthorName("李静梅");
                jinb2.setReturnDate("2017-11-12");
                jinb2.setStudent_id(1345747222);
                jinb2.save();

                BookInfo jinb3=new BookInfo();
                jinb3.setBookName("计算机操作系统");
                jinb3.setAuthorName("郁红英");
                jinb3.setReturnDate("2017-6-21");
                jinb3.setStudent_id(1345747222);
                jinb3.save();


                BookInfo lib1=new BookInfo();
                lib1.setBookName("数据库系统原理教程");
                lib1.setAuthorName("王珊 等");
                lib1.setReturnDate("2017-11-1");
                lib1.setStudent_id(1345747223);
                lib1.save();

                BookInfo lib2=new BookInfo();
                lib2.setBookName("数据仓库与数据挖掘");
                lib2.setAuthorName("陈志泊");
                lib2.setReturnDate("2017-4-1");
                lib2.setStudent_id(1345747223);
                lib2.save();


                BookInfo ruab1=new BookInfo();
                ruab1.setBookName("编译原理（第2版）");
                ruab1.setAuthorName("张素琴 等");
                ruab1.setReturnDate("2017-5-22");
                ruab1.setStudent_id(1345747224);
                ruab1.save();

                BookInfo ruab2=new BookInfo();
                ruab2.setBookName("软件工程导论（第6版）");
                ruab2.setAuthorName("张海藩 等");
                ruab2.setReturnDate("2017-7-23");
                ruab2.setStudent_id(1345747224);
                ruab2.save();







            }
        });
    }

}
