package com.thoughtworks.wzhai.command;

import com.thoughtworks.wzhai.User;
import com.thoughtworks.wzhai.tool.LogForLibrary;

public class DetailsCommand extends Command {
    public DetailsCommand()
    {
        super("details");
    }
    @Override
    public Action excute(String[] command, User user) {
        if(user == null)
            return Action.Ok;
        LogForLibrary.getInstance().bodyMessageLn("Name: " + user.getName());
        LogForLibrary.getInstance().bodyMessageLn("Email: " + user.getEmail());
        LogForLibrary.getInstance().bodyMessageLn("Num: " + user.getNum());
        return Action.Ok;
    }

    @Override
    public String getDescription() {
        return "show personal info";
    }

    @Override
    public boolean needToLogin() {
        return true;
    }

    @Override
    public String getUsage() {
        return "details     --could show personal info--";
    }
}
