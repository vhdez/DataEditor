package com.example.dataeditor;

import java.io.*;
import java.time.LocalDate;
import javafx.scene.image.Image;
import javafx.embed.swing.SwingFXUtils;
import javax.imageio.ImageIO;

public class Movie implements Serializable {
    private int rank;
    private String title;
    private long revenue;
    private LocalDate releaseDate;
    private transient Image moviePoster;

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

    public Image getMoviePoster() {
        return moviePoster;
    }

    public void setMoviePoster(Image moviePoster) {
        this.moviePoster = moviePoster;
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

    // implements serializable for transient posterImage field
    @Serial
    private void writeObject(ObjectOutputStream s) throws IOException {
        // write NON-transient fields
        s.defaultWriteObject();
        // write transient fields
        if (moviePoster != null) {
            ImageIO.write(SwingFXUtils.fromFXImage(moviePoster, null), "png", s);
        }
    }

    @Serial
    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        // read NON-transient fields
        s.defaultReadObject();
        // read transient fields
        Image maybePoster = null;
        try {
            maybePoster = SwingFXUtils.toFXImage(ImageIO.read(s), null);
        } catch (Exception ex) {

        }
        moviePoster = maybePoster;
    }
}
