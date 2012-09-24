package com.thoughtworks.wzhai.tool;

import org.junit.Test;

import static com.thoughtworks.wzhai.tool.PrintFormat.formatTab;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PrintFormatTest {
    @Test
    public void testFormatTab() throws Exception {
        assertThat(formatTab("0000007",3),is("\t\t\t"));
        assertThat(formatTab("00000008",3),is("\t\t"));
        assertThat(formatTab("00005",5),is("\t\t\t\t\t"));
        assertThat(formatTab("00000000000000017",5),is("\t\t\t"));
    }
}
