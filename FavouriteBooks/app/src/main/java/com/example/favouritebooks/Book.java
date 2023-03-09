package com.example.favouritebooks;

import java.io.Serializable;

public class Book implements Serializable {
    private String bookName;
    private String bookGenre;
    private int bookYear;
    private String bookImageName;
    private double bookPrice;
    private String bookDesc;

public Book(String bookName, String bookGenre, int bookYear, String bookImageName, double bookPrice, String bookDesc) {
        this.bookName = bookName;
        this.bookGenre = bookGenre;
        this.bookYear = bookYear;
        this.bookImageName = bookImageName;
        this.bookPrice = bookPrice;
        this.bookDesc = bookDesc;
    }

    public String getBookName() {
        return bookName;
    }

    public String getBookGenre() {
        return bookGenre;
    }

    public int getBookYear() {
        return bookYear;
    }

    public String getBookImageName() {
        return bookImageName;
    }

    public double getBookPrice() {
        return bookPrice;
    }

    public String getBookDesc() {
        return bookDesc;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setBookGenre(String bookGenre) {
        this.bookGenre = bookGenre;
    }

    public void setBookYear(int bookYear) {
        this.bookYear = bookYear;
    }

    public void setBookImageName(String bookImageName) {
        this.bookImageName = bookImageName;
    }

    public void setBookPrice(double bookPrice) {
        this.bookPrice = bookPrice;
    }

    public void setBookDesc(String bookDesc) {
        this.bookDesc = bookDesc;
    }
}
