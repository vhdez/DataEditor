package com.example.dataeditor;

import java.time.LocalDate;

public class Movie {
    private int rank;
    private String title;
    private long revenue;
    private LocalDate releaseDate;

    public Movie(int rank, String title, long revenue, LocalDate releaseDate) {
        this.rank = rank;
        this.title = title;
        this.revenue = revenue;
        this.releaseDate = releaseDate;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getRevenue() {
        return revenue;
    }

    public void setRevenue(long revenue) {
        this.revenue = revenue;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String toString() {
        return "#" + rank + " is " + title + " (released on: " + releaseDate + ") earning $" + revenue;
    }
    static String newest() {
        return null;
    }
    int averageRevenue() {
        return 0;
    }

}
