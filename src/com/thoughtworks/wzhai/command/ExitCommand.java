package com.thoughtworks.wzhai.command;

public class ExitCommand extends Command {
    public ExitCommand() {
        super("exit");
    }

    @Override
    public void excute(String[] command) {
        System.exit(0);
    }

    @Override
    public String getDescription() {
        return "run exit can exit the application";
    }

    @Override
    public String getUsage() {
        return "exit    ---will exit the application---";
    }
}
