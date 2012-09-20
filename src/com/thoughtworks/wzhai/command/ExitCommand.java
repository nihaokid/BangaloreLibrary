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
        return null;
    }

    @Override
    public String getUsage() {
        return "exit    ---will exit the application---";
    }
}
