package com.thoughtworks.wzhai;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Library {
    private Map<String, String> booksName;
    private Map<String, Integer> books;

    public Library() {
        booksName = new LinkedHashMap<String, String>();
        books = new HashMap<String, Integer>();
        initBooks();
    }

    public boolean reserveBook(String bookCode) {
        if (books.containsKey(bookCode) && books.get(bookCode) > 0) {
            books.put(bookCode, books.get(bookCode) - 1);
            return true;
        }
        return false;
    }

    public String getBookName(String bookCode)
    {
        if(booksName.containsKey(bookCode))
            return booksName.get(bookCode);

        return null;
    }

    public void showBooks()
    {
        System.out.println("Code\tName\tLeft");
        for(String bookCode:booksName.keySet())
        {
            System.out.println(bookCode+'\t'+booksName.get(bookCode)+'\t'+books.get(bookCode));
        }
    }

    private void initBooks() {
        booksName.put("1","java");
        booksName.put("2","ruby");
        booksName.put("3","c");
        booksName.put("4","lisp");

        for(String bookCode:booksName.keySet())
        {
            books.put(bookCode,3);
        }
    }

}
