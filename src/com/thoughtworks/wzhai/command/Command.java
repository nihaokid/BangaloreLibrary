package com.thoughtworks.wzhai.command;

public abstract class Command {
    private String name;

    public abstract void excute(String[] command);

    public abstract String getDescription();

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
