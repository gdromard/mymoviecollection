package net.dromard.movies.web.action;

import net.dromard.movies.service.IMovieService;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.Preparable;

public class DeleteMovieAction implements Preparable {
    private IMovieService service;
    private Integer id;

    public DeleteMovieAction(IMovieService service) {
        this.service = service;
    }

    public String execute() {
    	service.remove(id);
        return Action.SUCCESS;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void prepare() throws Exception {
    }
}