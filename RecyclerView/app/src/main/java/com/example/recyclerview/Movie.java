package com.example.recyclerview;

public class Movie {
    private String movieName;
    private String movieGenre;
    private int movieYear;
    private String movieImageName;

    public Movie(String movieName, String movieGenre, int movieYear, String movieImageName) {
        this.movieName = movieName;
        this.movieGenre = movieGenre;
        this.movieYear = movieYear;
        this.movieImageName = movieImageName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public void setMovieGenre(String movieGenre) {
        this.movieGenre = movieGenre;
    }

    public void setMovieYear(int movieYear) {
        this.movieYear = movieYear;
    }

    public void setMovieImageName(String movieImageName) {
        this.movieImageName = movieImageName;
    }

    public String getMovieName() {
        return movieName;
    }

    public String getMovieGenre() {
        return movieGenre;
    }

    public int getMovieYear() {
        return movieYear;
    }

    public String getMovieImageName() {
        return movieImageName;
    }
}
