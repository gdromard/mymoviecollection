package net.dromard.movies.web.action;

import java.util.List;

import net.dromard.movies.model.Movie;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.Preparable;

public class MoviesAction extends ServiceLocatorAware implements Preparable {
    private List<Movie> movies;

    public String execute() {
        this.movies = getServiceLocator().getDaoLocator().getMovieDAO().findAll();
        return Action.SUCCESS;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void prepare() throws Exception {
    }
}