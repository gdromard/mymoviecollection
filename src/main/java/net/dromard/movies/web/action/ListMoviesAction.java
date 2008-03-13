package net.dromard.movies.web.action;

import java.util.List;

import net.dromard.movies.model.Movie;
import net.dromard.movies.service.IMovieService;


import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.Preparable;

public class ListMoviesAction implements Preparable {
    private IMovieService service;
    private List<Movie> movies;

    public ListMoviesAction(IMovieService service) {
        this.service = service;
    }

    public String execute() {
        this.movies = service.findAll();
        return Action.SUCCESS;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void prepare() throws Exception {
    }
}