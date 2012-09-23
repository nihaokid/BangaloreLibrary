package com.thoughtworks.wzhai;

public class MovieBuilder {
    String movieCode = "N/A";
    String name = "N/A";
    String year = "N/A";
    String director = "N/A";
    String rating = "N/A";
    public MovieBuilder withMovieCode(String movieCode) {
        this.movieCode = movieCode;
        return this;
    }

    public MovieBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public MovieBuilder withYear(String year) {
        this.year =  year;
        return this;
    }

    public MovieBuilder withDirector(String director) {
        this.director = director;
        return this;
    }

    public MovieBuilder withRating(String rating) {
        this.rating = rating;
        return this;
    }

    public Movie create() {
        return new Movie(movieCode,name,year,director,rating);
    }
}
