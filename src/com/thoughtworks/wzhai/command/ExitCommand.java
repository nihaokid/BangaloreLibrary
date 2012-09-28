package com.thoughtworks.wzhai.command;

import com.thoughtworks.wzhai.User;

public class ExitCommand extends Command {
    public ExitCommand() {
        super("exit");
    }

    @Override
    public Action excute(String[] command,User user) {
        return Action.Exit;
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
