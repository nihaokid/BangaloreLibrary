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
        assertThat(outContent.toString(), is("Code\tName\tLeft\n" +
                "1\tjava\t3\n" +
                "2\truby\t3\n" +
                "3\tc\t3\n" +
                "4\tlisp\t3\n"));
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


}
