package com.mobileffort.tools;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ParserTest {
    private Parser parser;
    private List<String> paths;


    @Before
    public void init() {
        parser = new Parser();
        paths = new ArrayList<>();
    }

    @After
    public void destroy() {
        paths = null;
        parser = null;
    }

    @Test
    public void whenFileContainsOnePath() throws Exception {
        File file = new File("src\\test\\resources\\paths.txt");
        String path = file.getAbsolutePath();
        paths = parser.parseInputFile(path);
        final String resultPath = "src\\test\\resources";
        for (String currentPath : paths) {
            assertThat(resultPath, is(currentPath));
        }
    }
}