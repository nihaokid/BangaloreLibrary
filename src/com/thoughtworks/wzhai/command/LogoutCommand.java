package com.thoughtworks.wzhai.command;

import com.thoughtworks.wzhai.LibraryContext;
import com.thoughtworks.wzhai.User;
import com.thoughtworks.wzhai.tool.LogForLibrary;

public class LogoutCommand extends Command {
    private LibraryContext libraryContext;

    public LogoutCommand(LibraryContext libraryContext)
    {
        super("logout");
        this.libraryContext = libraryContext;
    }
    @Override
    public Action excute(String[] command, User user) {
        libraryContext.logout();
        LogForLibrary.getInstance().bodyMessageLn(user.getId() + " logout success.");
        return Action.Ok;
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
