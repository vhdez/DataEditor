package com.example.dataeditor;

public class Main {
    public static void main(String[] args) throws Exception {
        Film.readAllData();
        Film.describeAllFilms();
        System.out.println("Newest film on list is: "+ Film.newest());

        /*
        // 1	1	Avatar	$2,923,706,026	2009	[# 1][# 2]
        Date date1 = new Date(109,0,1);
        Film film1 = new Film(1,"Avatar", 2923706826L, date1, 1);
        Film.newest();
        System.out.println(film1);
        // 2	1	Avengers: Endgame	$2,797,501,328	2019	[# 3][# 4]
        Date date2 = new Date(119,0,1);
        Film film2 = new Film(2,"Avengers: Endgame", 2797501328L, date2, 1);
        System.out.println(film2);
        // 3	3	Avatar: The Way of Water	$2,320,250,281	2022	[# 5][# 6]
        Date date3 = new Date(122,0,1);
        Film film3 = new Film(3,"Avatar: The Way of Water", 2320250281L, date3, 3);
        System.out.println(film3);

        // The Lion King    March 3, 1995	48,500,000	32,000,000[1]	11,900,000 [2]	3,680,000[3]	$852,000,000[4][2][3]
        Date date4 = new Date(95, 2,3);
        Video video1 = new Video(1, "The Lion King",852000000, date4,48500000	,32000000,	11900000, 3680000);
        System.out.println(video1);
        // Finding Nemo     November 4, 2003	40,600,000	520,000[5]	38,800,000[2]	1,320,000[6]	$801,400,000[5][2][6]
        Date date5 = new Date(103, 10,4);
        Video video2 = new Video(2, "Finding Nemo",801400000, date5,40600000,520000,	38800000, 1320000);
        System.out.println(video2);
        //Snow White and the Seven Dwarfs   October 28, 1994	36,000,000	28,000,000[7]	5,070,000[8]	2,960,000[3]	$598,000,000[9][8][3]
        Date date6 = new Date(94, 9,28);
        Video video3 = new Video(3, "Snow White and the Seven Dwarfs",598000000, date6,36000000,28000000,	5070000, 2960000);
        System.out.println(video3);

        System.out.println("\nLet's print movies:");
        Movie movie1 = film1;
        Movie movie2 = video1;
        System.out.println(movie1);
        System.out.println(movie2);

        System.out.println("\nLet's print allMovies:");
        ArrayList<Movie> allMovies = new ArrayList<Movie>();
        allMovies.add(film1);
        allMovies.add(video1);
        allMovies.add(film2);
        allMovies.add(video2);
        allMovies.add(film3);
        allMovies.add(video3);
        for (Movie movie: allMovies) {
            System.out.println(movie);
        }

        Movie.newest();

         */
    }
}