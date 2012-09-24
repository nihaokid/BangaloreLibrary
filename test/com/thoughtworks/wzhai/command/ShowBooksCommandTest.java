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

public class ShowBooksCommandTest {
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
    public void testExcute() throws Exception {
        Library library = new Library();
        Command command = new ShowBooksCommand(library);
        command.excute("showbook".split(" "));
        assertThat(outContent.toString(),is("Code\tName\t\tLeft\n" +
                "1\tjava\t\t3\n" +
                "2\truby\t\t3\n" +
                "3\tc\t\t3\n" +
                "4\tlisp\t\t3\n"));
    }
}
