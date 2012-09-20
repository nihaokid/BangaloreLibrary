package com.thoughtworks.wzhai.command;

import com.thoughtworks.wzhai.Library;

public class ReserveBookCommand extends Command
{

    private Library library;

    public ReserveBookCommand(Library library) {
        super("reserve");
        this.library = library;
    }

    @Override
    public void excute(String[] command) {
        if(command.length == 1)
        {
            System.out.println(getUsage());
            return;
        }
        for(int i=1; i< command.length ;i++)
        {
            reserveBook(command[i]);
        }
    }

    @Override
    public String getDescription() {
        return "reserve book from Bangalore Library";
    }

    @Override
    public String getUsage() {
        return "reserve <bookcode1> <bookcode2>...   ---will reserve those books---";
    }

    private void reserveBook(String bookCode)
    {
        if(library.reserveBook(bookCode))
        {
            System.out.println("Thank You! Enjoy the book of "+library.getBookName(bookCode));
        }
        else
        {
            System.out.println("Sorry we don't have that book yet.");
        }
    }
}
