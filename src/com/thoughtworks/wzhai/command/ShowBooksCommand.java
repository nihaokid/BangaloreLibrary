package com.thoughtworks.wzhai.command;

import com.thoughtworks.wzhai.Library;

public class ShowBooksCommand extends Command{

    private Library library;

    public ShowBooksCommand(Library library)
    {
        super("showbooks");
        this.library = library;
    }

    @Override
    public void excute(String[] command) {
        library.showBooks();
    }

    @Override
    public String getDescription() {
        return "showbooks a book list of Bangalore Library";
    }

    @Override
    public String getUsage() {
        return "showbooks    ---will show a book list of the library--- ";
    }
}
