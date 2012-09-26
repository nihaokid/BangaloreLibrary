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
        LibraryContext libraryContent = new LibraryContext();
        libraryContent.showWelcomeMessage();
        assertThat(outContent.toString(), is("Welcome guys!!!\n"));
    }

    @Test
    public void testShowMenuOptions()
    {
        LibraryContext libraryContent = new LibraryContext();
        libraryContent.showMenuOptions(null);
        assertThat(outContent.toString(),is(
                "showbooks\tshowbooks a book list of Bangalore Library\n" +
                        "showmovies\tshowmovies a movie list of Bangalore Library\n"+
                        "login\t\tuser can login in the Library system\n"+
                        "help\t\tshow usage of command\n" +
                        "exit\t\trun exit can exit the application\n"
        ));
    }

}
