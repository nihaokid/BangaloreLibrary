package com.thoughtworks.wzhai.tool;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LogForLibrary {
    private static LogForLibrary logForLibrary = new LogForLibrary();
    private BufferedReader bufferedReader;

    private LogForLibrary(){
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }

    public static LogForLibrary getInstance()
    {
        return logForLibrary;
    }

    public String readLine()
    {
        try {
            return bufferedReader.readLine();
        } catch (IOException e) {
             error("Error: readline in readLine(),Class LogForLibrary!");
            return null;
        }
    }

    public void headMessage(String message)
    {
        System.out.println(message);
    }

    public void bodyMessageLn(String message)
    {
        System.out.println(message);
    }

    public void bodyMessage(String message)
    {
        System.out.print(message);
    }

    public void error(String error)
    {
        System.err.println("error: "+error);
    }

}
