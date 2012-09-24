package com.thoughtworks.wzhai;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import static com.thoughtworks.wzhai.tool.PrintFormat.formatTab;

public class Library {
    private Map<String, String> booksName;
    private Map<String, Integer> books;
    private Map<String,Movie> movies;

    public Library() {
        initBooks();
        initMovies();
    }

    public boolean reserveBook(String bookCode) {
        if (books.containsKey(bookCode) && books.get(bookCode) > 0) {
            books.put(bookCode, books.get(bookCode) - 1);
            return true;
        }
        return false;
    }

    public String getBookName(String bookCode)
    {
        if(booksName.containsKey(bookCode))
            return booksName.get(bookCode);

        return null;
    }

    public void showBooks()
    {
        System.out.println("Code\tName"+formatTab("Name",2)+"Left");
        for(String bookCode:booksName.keySet())
        {
            System.out.println(bookCode+'\t'+booksName.get(bookCode)+formatTab(booksName.get(bookCode),2)+books.get(bookCode));
        }
    }

    private void initBooks() {
        books = new HashMap<String, Integer>();
        booksName = new LinkedHashMap<String, String>();
        booksName.put("1","java");
        booksName.put("2","ruby");
        booksName.put("3","c");
        booksName.put("4","lisp");

        for(String bookCode:booksName.keySet())
        {
            books.put(bookCode,3);
        }
    }

    private void initMovies()
    {
        movies = new LinkedHashMap<String, Movie>();
        Movie movie1 = new MovieBuilder().withMovieCode(generateMovieCode()).withName("Hobbit 3").withYear("2014").withDirector("Peter Jackson").create();
        movies.put(movie1.getMovieCode(),movie1);
        Movie movie2 = new MovieBuilder().withMovieCode(generateMovieCode()).withName("Jack Ryan").withYear("2013").withDirector("Kenneth Branagh").create();
        movies.put(movie2.getMovieCode(),movie2);
        Movie movie3 = new MovieBuilder().withMovieCode(generateMovieCode()).withName("TED 2").withYear("2014").withDirector("Seth MacFarlane").create();
        movies.put(movie3.getMovieCode(),movie3);
        Movie movie4 = new MovieBuilder().withMovieCode(generateMovieCode()).withName("Safe Haven").withYear("2013").withDirector("Lasse Hallstrom").create();
        Movie movie5 = new MovieBuilder().withMovieCode(generateMovieCode()).withName("Frozen").withYear("2013").withDirector("Chris Buck").create();
        Movie movie6 = new MovieBuilder().withMovieCode(generateMovieCode()).withName("Amazing Spider-Man 3").withYear("2016").withDirector("Marc Webb").create();
        Movie movie7 = new MovieBuilder().withMovieCode(generateMovieCode()).withName("Hummingbird").withYear("2013").withDirector("Steven Knight").create();
        movies.put(movie4.getMovieCode(),movie4);
        movies.put(movie5.getMovieCode(),movie5);
        movies.put(movie6.getMovieCode(),movie6);
        movies.put(movie7.getMovieCode(),movie7);
    }

    private int movieCode = 1;
    private String generateMovieCode()
    {
        return String.valueOf(movieCode++);
    }

    public void showMovieList() {
        System.out.println("Movie"+formatTab("Movie",3)+"Year\tDirector"+formatTab("Director",3)+"Rating");
        for(Movie movie:movies.values())
        {
            movie.print();
        }
    }
}
