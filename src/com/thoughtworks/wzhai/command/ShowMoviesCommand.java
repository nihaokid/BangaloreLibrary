package com.thoughtworks.wzhai.command;

import com.thoughtworks.wzhai.Library;
import com.thoughtworks.wzhai.LibraryContext;

public class ShowMoviesCommand extends Command {
    Library library;
    public ShowMoviesCommand(Library library)
    {
        super("showmovies");
        this.library = library;
    }
    @Override
    public void excute(String[] command) {
        library.showMovieList();
    }

    @Override
    public String getDescription() {
        return "showmovies a movie list of Bangalore Library";
    }

    @Override
    public String getUsage() {
        return "showmovies    ---will show a movie list of the library--- ";
    }
}
