package com.thoughtworks.wzhai;

import com.thoughtworks.wzhai.command.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class LibraryContext {
    private Library library;
    private Map<String,Command> commandMap;
    private BufferedReader bufferRead;

    public LibraryContext()
    {
        library = new Library();
        commandMap = new LinkedHashMap<String,Command>();
        initCommands();
        bufferRead = new BufferedReader(new InputStreamReader(System.in));
    }

    public void showWelcomeMessage() {
        System.out.println("Welcome guys!!!");
    }

    public void showMenuOptions() {
        for(Command command: commandMap.values())
        {
            System.out.println(command.getName()+'\t'+command.getDescription());
        }
    }

    public Map<String, Command> getCommands() {
        return commandMap;
    }

    public void play() throws IOException {
        showWelcomeMessage();
        showMenuOptions();
        while(true)
        {
            runCommand();
        }
    }

    private void initCommands()
    {
        addCommand(new ShowBooksCommand(library));
        addCommand(new ReserveBookCommand(library));
        addCommand(new ShowMoviesCommand(library));
        addCommand(new HelpCommand(this));
        addCommand(new ExitCommand());
    }

    private void runCommand() throws IOException {
        System.out.print("Library->");
        String command = bufferRead.readLine();
        String[] commands = command.split(" ");
        if(commandMap.containsKey(commands[0]))
        {
            commandMap.get(commands[0]).excute(commands);
        }
        else
        {
            System.out.println("Select a valid command!!");
        }
    }

    private void addCommand(Command command)
    {
        commandMap.put(command.getName(), command);
    }

    public static void main(String[] asd) throws IOException {
        new LibraryContext().play();
    }
}
