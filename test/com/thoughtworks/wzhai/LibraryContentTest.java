package com.thoughtworks.wzhai;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class LibraryContentTest {
    ByteArrayOutputStream outContent;
    @Before
    public void redirectSystemStream()
    {
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }
    @After
    public void resetSystemStream() throws IOException {
        outContent.close();
        System.setOut(System.out);
    }
    @Test
    public void testShowMessage(){
        LibraryContent libraryContent = new LibraryContent();
        libraryContent.showWelcomeMessage();
        assertThat(outContent.toString(), is("Welcome guys!!!\n"));
    }

    @Test
    public void testShowMenuOptions()
    {
        LibraryContent libraryContent = new LibraryContent();
        libraryContent.showMenuOptions();
        assertThat(outContent.toString(),is(
                "showbook\tshowbook a book list of Bangalore Library\n" +
                        "reserve\treserve book from Bangalore Library\n" +
                        "help\tshow usage of command\n" +
                        "exit\tnull\n"
        ));
    }

}
