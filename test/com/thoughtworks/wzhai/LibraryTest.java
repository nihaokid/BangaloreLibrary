package com.thoughtworks.wzhai;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

public class LibraryTest {

    public ByteArrayOutputStream outContent;

    @Before
    public void redirectSystemStream() {
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void resetSystemStream() throws IOException {
        outContent.close();
        System.setOut(System.out);
    }

    @Test
    public void testShowBooks() throws Exception {
        Library library = new Library();
        library.showBooks();
        assertThat(outContent.toString(), is("Code\tName\t\tLeft\n" +
                "1\tjava\t\t3\n" +
                "2\truby\t\t3\n" +
                "3\tc\t\t3\n" +
                "4\tlisp\t\t3\n"));
    }

    @Test
    public void testReserveBook() throws Exception {
        Library library = new Library();

        assertThat(library.reserveBook("1"),is(true));
        assertThat(library.reserveBook("abc"),is(false));
    }

    @Test
    public void testGetBookName() throws Exception {
        Library library = new Library();
        assertThat(library.getBookName("1"),is("java"));
        assertThat(library.getBookName("abc"),is(nullValue()));
    }

    @Test
    public void testShowMovieList()
    {
        Library library = new Library();
        library.showMovieList();
        assertThat(outContent.toString(),is("Movie\t\t\tYear\tDirector\t\tRating\n"+
                "Hobbit 3\t\t2014\tPeter Jackson\t\tN/A\n"+
                "Jack Ryan\t\t2013\tKenneth Branagh\t\tN/A\n"+
                "TED 2\t\t\t2014\tSeth MacFarlane\t\tN/A\n"+
                "Safe Haven\t\t2013\tLasse Hallstrom\t\tN/A\n"+
                "Frozen\t\t\t2013\tChris Buck\t\tN/A\n"+
                "Amazing Spider-Man 3\t2016\tMarc Webb\t\tN/A\n"+
                "Hummingbird\t\t2013\tSteven Knight\t\tN/A\n"
                ));
    }


}
