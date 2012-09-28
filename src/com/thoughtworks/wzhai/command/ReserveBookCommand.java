package com.thoughtworks.wzhai.command;

import com.thoughtworks.wzhai.Library;
import com.thoughtworks.wzhai.User;
import com.thoughtworks.wzhai.tool.LogForLibrary;

import java.rmi.activation.ActivationID;

public class ReserveBookCommand extends Command
{

    private Library library;

    public ReserveBookCommand(Library library) {
        super("reserve");
        this.library = library;
    }

    @Override
    public Action excute(String[] command,User user) {
        if(command.length == 1)
        {
            LogForLibrary.getInstance().bodyMessage(getUsage());
            return Action.Ok;
        }
        for(int i=1; i< command.length ;i++)
        {
            reserveBook(command[i],user);
        }
        return Action.Ok;
    }

    @Override
    public String getDescription() {
        return "reserve book from Bangalore Library";
    }

    @Override
    public boolean needToLogin() {
        return true;
    }

    @Override
    public String getUsage() {
        return "reserve <bookcode1> <bookcode2>...   ---will reserve those books---";
    }

    private void reserveBook(String bookCode,User user)
    {
        if(library.reserveBook(bookCode))
        {
            user.reserveBook(bookCode);
            LogForLibrary.getInstance().bodyMessage("Thank You! Enjoy the book of " + library.getBookName(bookCode));
        }
        else
        {
            LogForLibrary.getInstance().bodyMessage("Sorry we don't have that book yet.");
        }
    }
}
