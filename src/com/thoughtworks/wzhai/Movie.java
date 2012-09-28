package com.thoughtworks.wzhai;

import com.thoughtworks.wzhai.tool.LogForLibrary;

import static com.thoughtworks.wzhai.tool.PrintFormat.formatTab;

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
        LogForLibrary.getInstance().bodyMessageLn(name + formatTab(name, 3) + year + '\t' + director + formatTab(director, 3) + rating);
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
