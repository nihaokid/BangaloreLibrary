package com.thoughtworks.wzhai.command;

import com.thoughtworks.wzhai.Library;
import com.thoughtworks.wzhai.LibraryContext;
import com.thoughtworks.wzhai.User;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LoginCommand extends Command {

    BufferedReader bufferedReader= new BufferedReader(new InputStreamReader(System.in));
    private Library library;
    private LibraryContext libraryContext;
    public LoginCommand(Library library,LibraryContext libraryContext)
    {
        super("login");
        this.library = library;
        this.libraryContext = libraryContext;
    }
    @Override
    public void excute(String[] command,User u) {
        if(u != null)
        {
            System.out.println(u.getId()+" already login");
            return;
        }

        System.out.println("please input the user name.");
        User user = null;
        try {
            user = library.getUser(bufferedReader.readLine());
            if(user != null)
            {
                System.out.println("please input the password.");
                if(user.authenticated(bufferedReader.readLine()))
                {
                    libraryContext.login(user);
                    System.out.println("login success");
                }
                else
                {
                    System.out.println("password wrong!");
                }
            }
            else
            {
                System.out.println("no such user!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getDescription() {
        return "user can login in the Library system";
    }

    @Override
    public boolean needToLogin() {
        return false;
    }

    @Override
    public String getUsage() {
        return "input your userName and password to login the system";
    }
}
