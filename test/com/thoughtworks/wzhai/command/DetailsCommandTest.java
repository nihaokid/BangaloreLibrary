package com.thoughtworks.wzhai.command;

import com.thoughtworks.wzhai.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class DetailsCommandTest {
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
    public void testExcute() throws Exception {
        DetailsCommand detailsCommand = new DetailsCommand();
        detailsCommand.excute("details".split(" "),new User("zhang 3","zhang@gmail.com","13112344321"));
        assertThat(outContent.toString(),is("Name: zhang 3\nEmail: zhang@gmail.com\nNum: 13112344321\n"));
    }
}
