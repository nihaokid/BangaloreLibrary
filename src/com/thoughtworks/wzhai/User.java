package com.thoughtworks.wzhai;

import java.util.HashMap;
import java.util.Map;

public class User {
    private String id;
    private Map<String,Integer> reservedBooks;
    private String password;
    private String name;
    private String email;
    private String num;

    public User(String name, String email, String num)
    {
        this.name = name;
        this.email = email;
        this.num = num;
        this.reservedBooks = new HashMap<String, Integer>();
        String nextId = nextId();
        this.id = "111-"+nextId;
        this.password = nextId;
    }

    public String getId()
    {
        return id;
    }

    public void reserveBook(String bookCode) {
        if(reservedBooks.containsKey(bookCode))
            reservedBooks.put(bookCode,reservedBooks.get(bookCode)+1);
        else
            reservedBooks.put(bookCode,1);
    }

    public boolean authenticated(String password)
    {
        if(this.password.equals(password))
        {
            return true;
        }
        return false;
    }

    private static int userId = 1111;
    private static String nextId()
    {
        return String.valueOf(userId++);
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getNum() {
        return num;
    }
}
