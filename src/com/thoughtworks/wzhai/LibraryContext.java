package com.thoughtworks.wzhai;

import com.thoughtworks.wzhai.command.*;
import com.thoughtworks.wzhai.tool.LogForLibrary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

import static com.thoughtworks.wzhai.tool.PrintFormat.formatTab;

public class LibraryContext {
    private Library library;
    private Map<String,Command> commandMap;
    private User currentUser = null;

    public LibraryContext()
    {
        library = new Library();
        commandMap = new LinkedHashMap<String,Command>();
        initCommands();
    }

    public void showWelcomeMessage() {
        LogForLibrary.getInstance().headMessage("Welcome guys!!!");
    }

    public void showMenuOptions(User user) {
        for(Command command: commandMap.values())
        {
            if(command.needToLogin() && user == null)
            {
                continue;
            }
            LogForLibrary.getInstance().bodyMessage(command.getName()+formatTab(command.getName(), 2)+command.getDescription());
        }
    }

    public Map<String, Command> getCommands() {
        return commandMap;
    }

    public void play() throws IOException {
        showWelcomeMessage();
        showMenuOptions(currentUser);
        while(true)
        {
            runCommand();
        }
    }

    private void initCommands()
    {
        addCommand(new ShowBooksCommand(library));
        addCommand(new ShowMoviesCommand(library));
        addCommand(new ReserveBookCommand(library));
        addCommand(new DetailsCommand());
        addCommand(new LoginCommand(library,this));
        addCommand(new LogoutCommand(this));
        addCommand(new HelpCommand(this));
        addCommand(new ExitCommand());
    }

    private void runCommand() throws IOException {
        LogForLibrary.getInstance().headMessage(commandPrompting());
        String command = LogForLibrary.getInstance().readLine();
        String[] commands = command.split(" ");
        if(commandMap.containsKey(commands[0]) &&
                (!commandMap.get(commands[0]).needToLogin() || currentUser != null))
        {
            commandMap.get(commands[0]).excute(commands,currentUser).run();
        }
        else
        {
            LogForLibrary.getInstance().error("Select a valid command!!");
        }
    }

    private String commandPrompting()
    {
        if(currentUser == null)
            return "Library->";

        return currentUser.getId()+"->";
    }

    private void addCommand(Command command)
    {
        commandMap.put(command.getName(), command);
    }

    public void logout() {
        this.currentUser = null;
    }

    public void login(User user) {
        this.currentUser = user;
    }

    public static void main(String[] asd) throws IOException {
        new LibraryContext().play();
    }
}
