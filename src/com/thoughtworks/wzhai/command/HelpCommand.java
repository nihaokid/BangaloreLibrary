package com.thoughtworks.wzhai.command;

import com.thoughtworks.wzhai.LibraryContext;

import java.util.Map;

public class HelpCommand extends Command {
    LibraryContext libraryContent;
    public HelpCommand(LibraryContext libraryContent) {
        super("help");
        this.libraryContent = libraryContent;
    }

    @Override
    public void excute(String[] command) {
        if(command.length == 1)
        {
            libraryContent.showMenuOptions();
            return;
        }
        Map<String,Command> commands = libraryContent.getCommands();
        if(commands.containsKey(command[1]))
        {
            System.out.println(commands.get(command[1]).getUsage());
        }
        else
        {
            System.out.println("No such command --"+command[1]);
        }
    }

    @Override
    public String getDescription() {
        return "show usage of command";
    }

    @Override
    public String getUsage() {
        return "help [command]  ---show the command usage---";
    }
}
