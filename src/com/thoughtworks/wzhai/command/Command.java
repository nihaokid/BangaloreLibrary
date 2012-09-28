package com.thoughtworks.wzhai.command;

import com.thoughtworks.wzhai.User;

public abstract class Command {
    private String name;

    public abstract Action excute(String[] command,User user);

    public abstract String getDescription();

    public abstract boolean needToLogin();

    public Command(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public abstract String getUsage();


}
