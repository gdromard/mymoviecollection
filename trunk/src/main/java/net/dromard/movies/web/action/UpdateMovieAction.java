package net.dromard.movies.web.action;

import net.dromard.movies.model.Movie;
import net.dromard.movies.service.IMovieService;


import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.Preparable;

public class UpdateMovieAction implements Preparable {
    private IMovieService service;
    private Movie movie;
    private Integer id;

    public UpdateMovieAction(IMovieService service) {
        this.service = service;
    }

    public String execute() {
    	this.service.persist(movie);
    	this.movie = new Movie();
        return Action.SUCCESS;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public Movie getMovie() {
    	return movie;
    }
    
    public void setMovie(Movie movie) {
    	this.movie = movie;
    }

    public void prepare() throws Exception {
        if (id != null) movie = service.findById(id);
    }
}