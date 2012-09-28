package com.thoughtworks.wzhai.command;

import com.thoughtworks.wzhai.Library;
import com.thoughtworks.wzhai.LibraryContext;
import com.thoughtworks.wzhai.User;
import com.thoughtworks.wzhai.tool.LogForLibrary;

import java.io.IOException;

public class LoginCommand extends Command {

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
            LogForLibrary.getInstance().bodyMessage(u.getId()+" already login");
            return;
        }

        LogForLibrary.getInstance().bodyMessage("please input the user name.");
        User user = null;

        user = library.getUser(LogForLibrary.getInstance().readLine());
        if (user != null) {
            LogForLibrary.getInstance().bodyMessage("please input the password.");
            if (user.authenticated(LogForLibrary.getInstance().readLine())) {
                libraryContext.login(user);
                LogForLibrary.getInstance().bodyMessage("login success");
            } else {
                LogForLibrary.getInstance().bodyMessage("password wrong!");
            }
        } else {
            LogForLibrary.getInstance().bodyMessage("no such user!");
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
