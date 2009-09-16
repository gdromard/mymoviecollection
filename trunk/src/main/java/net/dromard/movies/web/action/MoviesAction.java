package net.dromard.movies.web.action;

import java.util.List;

import net.dromard.movies.model.Movie;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.Preparable;

public class MoviesAction extends ServiceLocatorAware implements ActionIF, Preparable {
    private List<Movie> movies;
    private Integer page = 1;
    private Integer pageSize = 20;
    private String search;

    /**
     * View action.
     * @return success result.
     */
    public String search() {
        return Action.SUCCESS;
    }

    public String execute() {
        return Action.SUCCESS;
    }

    /**
     * List action.
     * @return success result.
     */
    public String list() {
    	if (search != null) {
    		this.movies = getServiceLocator().getDaoLocator().getMovieDAO().find(search);
    	} else {
    		this.movies = getServiceLocator().getDaoLocator().getMovieDAO().findAll();
    	}
        return Action.SUCCESS;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void prepare() throws Exception {
    }
    
    public Integer getPage() {
    	return page;
    }
    
    public void setPage(Integer page) {
    	this.page = page;
    }
    
    public Integer getPageSize() {
    	return pageSize;
    }
    
    public void setPageSize(Integer pageSize) {
    	this.pageSize = pageSize;
    }

	public void setSearch(String search) {
		this.search = search;
	}

	public String getSearch() {
		return search;
	}
}