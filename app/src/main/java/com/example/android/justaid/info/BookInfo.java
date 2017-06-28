package com.example.android.justaid.info;

import org.litepal.crud.DataSupport;

import java.io.Serializable;

/**
 * Created by 浩然 on 2017-4-15.
 */

public class BookInfo extends DataSupport implements Serializable {
    private String bookName;
    private String authorName;
    private String borrowDate;
    private String returnDate;
    private String barCode;
    private String checkNum;
    private long student_id;

    public BookInfo(String bookName,String authorName,String borrowDate,String returnDate,String barCode,String checkNum)
    {
        this.bookName=bookName;
        this.authorName=authorName;
        this.borrowDate=borrowDate;
        this.returnDate=returnDate;
        this.barCode=barCode;
        this.checkNum=checkNum;
    }


    public long getStudent_id() {
        return student_id;
    }

    public void setStudent_id(long student_id) {
        this.student_id = student_id;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public String getCheckNum() {
        return checkNum;
    }

    public void setCheckNum(String checkNum) {
        this.checkNum = checkNum;
    }

    public BookInfo() {
    }

    public BookInfo(String bookName) {
        this.bookName = bookName;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(String borrowDate) {
        this.borrowDate = borrowDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    @Override
    public String toString() {
        return "BookInfo{" +
                "bookName='" + bookName + '\'' +
                ", authorName='" + authorName + '\'' +
                ", borrowDate='" + borrowDate + '\'' +
                ", returnDate='" + returnDate + '\'' +
                ", barCode='" + barCode + '\'' +
                ", checkNum='" + checkNum + '\'' +
                '}';
    }
}
