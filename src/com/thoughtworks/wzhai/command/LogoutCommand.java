package com.thoughtworks.wzhai.command;

import com.thoughtworks.wzhai.LibraryContext;
import com.thoughtworks.wzhai.User;

public class LogoutCommand extends Command {
    private LibraryContext libraryContext;

    public LogoutCommand(LibraryContext libraryContext)
    {
        super("logout");
        this.libraryContext = libraryContext;
    }
    @Override
    public void excute(String[] command, User user) {
        libraryContext.logout();
        System.out.println(user.getId()+" logout success.");
    }

    @Override
    public String getDescription() {
        return "user logout";
    }

    @Override
    public boolean needToLogin() {
        return true;
    }

    @Override
    public String getUsage() {
        return "logout  --currout user logout--";
    }
}
