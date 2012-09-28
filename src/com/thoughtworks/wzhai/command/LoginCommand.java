package com.thoughtworks.wzhai.command;

import com.thoughtworks.wzhai.Library;
import com.thoughtworks.wzhai.LibraryContext;
import com.thoughtworks.wzhai.User;
import com.thoughtworks.wzhai.tool.LogForLibrary;

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
    public Action excute(String[] command,User u) {
        if(u != null)
        {
            LogForLibrary.getInstance().bodyMessageLn(u.getId() + " already login");
            return Action.Ok;
        }

        LogForLibrary.getInstance().bodyMessageLn("please input the user name.");
        User user = null;

        user = library.getUser(LogForLibrary.getInstance().readLine());
        if (user != null) {
            LogForLibrary.getInstance().bodyMessageLn("please input the password.");
            if (user.authenticated(LogForLibrary.getInstance().readLine())) {
                libraryContext.login(user);
                LogForLibrary.getInstance().bodyMessageLn("login success");
            } else {
                LogForLibrary.getInstance().bodyMessageLn("password wrong!");
            }
        } else {
            LogForLibrary.getInstance().bodyMessageLn("no such user!");
        }
        return Action.Ok;
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
