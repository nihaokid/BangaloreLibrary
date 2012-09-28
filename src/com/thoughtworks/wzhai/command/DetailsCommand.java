package com.thoughtworks.wzhai.command;

import com.thoughtworks.wzhai.User;
import com.thoughtworks.wzhai.tool.LogForLibrary;

public class DetailsCommand extends Command {
    public DetailsCommand()
    {
        super("details");
    }
    @Override
    public void excute(String[] command, User user) {
        if(user == null)
            return;
        LogForLibrary.getInstance().bodyMessage("Name: "+user.getName());
        LogForLibrary.getInstance().bodyMessage("Email: "+user.getEmail());
        LogForLibrary.getInstance().bodyMessage("Num: "+user.getNum());
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
