package com.example.favouritebooks;

public class Book {
    private String bookName;
    private String bookGenre;
    private int bookYear;
    private String bookImageName;

    public Book(String bookName, String bookGenre, int bookYear, String bookImageName) {
        this.bookName = bookName;
        this.bookGenre = bookGenre;
        this.bookYear = bookYear;
        this.bookImageName = bookImageName;
    }

    public void setBookName(String bookName) { this.bookName = bookName; }
    public void setBookGenre(String bookGenre) { this.bookName = bookGenre; }
    public void setBookYear(int bookYear) { this.bookYear = bookYear; }
    public void setBookImageName(String bookImageName) { this.bookImageName = bookImageName; }

    public String getBookName() { return bookName; }
    public String getBookGenre() { return bookGenre; }
    public int getBookYear() { return bookYear; }
    public String getBookImageName() { return bookImageName; }
}
