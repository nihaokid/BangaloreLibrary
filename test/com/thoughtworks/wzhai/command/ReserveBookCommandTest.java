package com.thoughtworks.wzhai.command;

import com.thoughtworks.wzhai.Library;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ReserveBookCommandTest {

    ByteArrayOutputStream outContent;

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
    public void testExcuteWithNoBookCode() throws Exception {
        Library library = new Library();
        Command command = new ReserveBookCommand(library);
        command.excute("reserve".split(" "));
        assertThat(outContent.toString(), is("reserve <bookcode1> <bookcode2>...   ---will reserve those books---\n"));
    }

    @Test
    public void testExcuteWithCorrectBookCode() throws Exception {
        Library library = new Library();
        Command command = new ReserveBookCommand(library);
        command.excute("reserve 1".split(" "));
        assertThat(outContent.toString(), is("Thank You! Enjoy the book of java\n"));
    }

    @Test
    public void testExcuteWithWrongBookCode() throws Exception {
        Library library = new Library();
        Command command = new ReserveBookCommand(library);
        command.excute("reserve 6".split(" "));
        assertThat(outContent.toString(), is("Sorry we don't have that book yet.\n"));
    }
}
