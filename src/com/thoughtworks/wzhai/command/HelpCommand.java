package com.thoughtworks.wzhai.command;

import com.thoughtworks.wzhai.LibraryContext;
import com.thoughtworks.wzhai.User;
import com.thoughtworks.wzhai.tool.LogForLibrary;

import java.util.Map;

public class HelpCommand extends Command {
    LibraryContext libraryContent;
    public HelpCommand(LibraryContext libraryContent) {
        super("help");
        this.libraryContent = libraryContent;
    }

    @Override
    public void excute(String[] command,User user) {
        if(command.length == 1)
        {
            libraryContent.showMenuOptions(user);
            return;
        }
        Map<String,Command> commands = libraryContent.getCommands();
        if(commands.containsKey(command[1]))
        {
            LogForLibrary.getInstance().bodyMessage(commands.get(command[1]).getUsage());
        }
        else
        {
            LogForLibrary.getInstance().error("No such command --"+command[1]);
        }
    }

    @Override
    public String getDescription() {
        return "show usage of command";
    }

    @Override
    public boolean needToLogin() {
        return false;
    }

    @Override
    public String getUsage() {
        return "help [command]  ---show the command usage---";
    }
}
