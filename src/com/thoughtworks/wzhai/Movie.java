package com.thoughtworks.wzhai;

public class Movie {
    String movieCode;
    String name;
    String year;
    String director;
    String rating;
    public Movie(String movieCode,String name,String year,String director,String rating)
    {
        this.movieCode = movieCode;
        this.name = name;
        this.year = year;
        this.director = director;
        this.rating = rating;
    }
    public void print()
    {
        System.out.println(name+'\t'+year+'\t'+director+'\t'+rating);
    }
    @Override
    public boolean equals(Object obj) {
        if(obj == null)
            return false;

        if(! (obj instanceof Movie))
            return false;
        Movie movie = (Movie) obj;

        return movieCode.equals(movie.movieCode);
    }
    @Override
    public int hashCode() {
        return movieCode.hashCode();
    }

    public String getMovieCode() {
        return movieCode;
    }
}
