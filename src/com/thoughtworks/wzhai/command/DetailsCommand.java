package com.thoughtworks.wzhai.command;

import com.thoughtworks.wzhai.User;

public class DetailsCommand extends Command {
    public DetailsCommand()
    {
        super("details");
    }
    @Override
    public void excute(String[] command, User user) {
        if(user == null)
            return;
        System.out.println("Name: "+user.getName());
        System.out.println("Email: "+user.getEmail());
        System.out.println("Num: "+user.getNum());
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
