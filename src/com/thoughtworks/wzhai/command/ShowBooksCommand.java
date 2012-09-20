package com.thoughtworks.wzhai.command;

import com.thoughtworks.wzhai.Library;

public class ShowBooksCommand extends Command{

    private Library library;

    public ShowBooksCommand(Library library)
    {
        super("showbook");
        this.library = library;
    }

    @Override
    public void excute(String[] command) {
        library.showBooks();
    }

    @Override
    public String getDescription() {
        return "showbook a book list of Bangalore Library";  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public String getUsage() {
        return "showbook    ---will show a book list of the library--- ";
    }
}
