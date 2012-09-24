package com.thoughtworks.wzhai.tool;

public class PrintFormat {
    public static String formatTab(String colunmValue,int tabNumber)
    {
        String result = "\t";
        for(int i = 1; i<tabNumber - (colunmValue.length()/8) ;i++)
        {
            result += "\t";
        }
        return result;
    }
}
