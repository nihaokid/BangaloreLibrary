package com.thoughtworks.wzhai.command;

import com.thoughtworks.wzhai.Library;
import com.thoughtworks.wzhai.User;

public class ShowBooksCommand extends Command{

    private Library library;

    public ShowBooksCommand(Library library)
    {
        super("showbooks");
        this.library = library;
    }

    @Override
    public void excute(String[] command,User user) {
        library.showBooks();
    }

    @Override
    public String getDescription() {
        return "showbooks a book list of Bangalore Library";
    }

    @Override
    public boolean needToLogin() {
        return false;
    }

    @Override
    public String getUsage() {
        return "showbooks    ---will show a book list of the library--- ";
    }
}
