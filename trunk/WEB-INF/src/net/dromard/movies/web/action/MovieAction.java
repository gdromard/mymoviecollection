package net.dromard.movies.web.action;

import java.util.List;

import net.dromard.movies.model.Movie;
import net.dromard.movies.service.DefaultMovieService;


import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.Preparable;

public class MovieAction implements Preparable {
    private DefaultMovieService service;
    private List<Movie> movies;
    private Movie movie;
    private Integer id;

    public MovieAction(DefaultMovieService service) {
        this.service = service;
    }

    public String execute() {
        this.movies = service.findAll();
        return Action.SUCCESS;
    }

    public String save() {
        this.service.persist(movie);
        this.movie = new Movie();
        return execute();
    }

    public String remove() {
        service.remove(id);
        return execute();
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void prepare() throws Exception {
        if (id != null)
        	movie = service.findById(id);
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }
}