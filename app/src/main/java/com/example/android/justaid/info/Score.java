package com.example.android.justaid.info;

import org.litepal.crud.DataSupport;

/**
 * Created by jry on 2017/4/25.
 */

public class Score extends DataSupport {

    private  String  date;
    private String coursename;
    private String myscore;
    private String xuefen;
    private long student_id;

    public Score() {
    }

    public Score(String date, String coursename, String myscore, String xuefen) {
        this.date = date;
        this.coursename = coursename;
        this.myscore = myscore;
        this.xuefen = xuefen;
    }

    public long getStudent_id() {
        return student_id;
    }

    public void setStudent_id(long student_id) {
        this.student_id = student_id;
    }


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }

    public String getMyscore() {
        return myscore;
    }

    public void setMyscore(String myscore) {
        this.myscore = myscore;
    }

    public String getXuefen() {
        return xuefen;
    }

    public void setXuefen(String xuefen) {
        this.xuefen = xuefen;
    }

    @Override
    public String toString() {
        return "Score{" +
                "date='" + date + '\'' +
                ", coursename='" + coursename + '\'' +
                ", myscore='" + myscore + '\'' +
                ", xuefen='" + xuefen + '\'' +
                '}';
    }
}
