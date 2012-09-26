package com.thoughtworks.wzhai.command;

import com.thoughtworks.wzhai.User;

public class ExitCommand extends Command {
    public ExitCommand() {
        super("exit");
    }

    @Override
    public void excute(String[] command,User user) {
        System.exit(0);
    }

    @Override
    public String getDescription() {
        return "run exit can exit the application";
    }

    @Override
    public boolean needToLogin() {
        return false;
    }

    @Override
    public String getUsage() {
        return "exit    ---will exit the application---";
    }
}
