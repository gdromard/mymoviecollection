package net.dromard.movies.web.action;

import java.util.List;

import net.dromard.movies.model.Casting;
import net.dromard.movies.model.Movie;
import net.dromard.movies.model.MovieFormat;
import net.dromard.movies.model.MovieGenre;
import net.dromard.movies.model.MovieNationality;
import net.dromard.movies.model.MovieQuality;
import net.dromard.movies.model.MovieVersion;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.Preparable;

public class MovieAction extends ServiceLocatorAware implements Preparable {
    private Movie movie;
    private Integer id;
	private List<MovieFormat> formats;
	private List<MovieGenre> genres;
	private List<MovieNationality> nationality;
	private List<MovieQuality> qualities;
	private List<MovieVersion> versions;
	private List<Casting> castings;

    /**
     * Default action (use for edit & view).
     * @return success result.
     */
    public String execute() {
    	System.out.println("[DEBUG] MovieAction.execute()");
        //prepare();
        return Action.SUCCESS;
    }

    /**
     * Update action.
     * @return success result.
     */
    public String update() {
        getServiceLocator().getDaoLocator().getMovieDAO().persist(movie);
        this.movie = new Movie();
        return Action.SUCCESS;
    }

    /**
     * Delete action.
     * @return success result.
     */
    public String delete() {
    	getServiceLocator().getDaoLocator().getMovieDAO().remove(id);
        return Action.SUCCESS;
    }

    /**
     * Prepare the action.
     */
    public void prepare() {
    	System.out.println("[DEBUG] MovieAction.prepare() - id: " + id);
        if (id != null) {
        	movie = getServiceLocator().getDaoLocator().getMovieDAO().findById(id);
        	formats = getServiceLocator().getDaoLocator().getMovieFormatDAO().findAll();
        	genres = getServiceLocator().getDaoLocator().getMovieGenreDAO().findAll();
        	nationality = getServiceLocator().getDaoLocator().getMovieNationalityDAO().findAll();
        	qualities = getServiceLocator().getDaoLocator().getMovieQualityDAO().findAll();
        	versions = getServiceLocator().getDaoLocator().getMovieVersionDAO().findAll();
        	castings = getServiceLocator().getDaoLocator().getCastingDAO().findAll();
        }
    }
    
    /* ----------- Movie Setters / Getters ----------- */
    
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

    
    /* ----------- List Setters / Getters ----------- */
    
	protected List<MovieFormat> getFormats() {
		return formats;
	}

	protected List<MovieGenre> getGenres() {
		return genres;
	}

	protected List<MovieNationality> getNationality() {
		return nationality;
	}

	protected List<MovieQuality> getQualities() {
		return qualities;
	}

	protected List<MovieVersion> getVersions() {
		return versions;
	}

	protected List<Casting> getCastings() {
		return castings;
	}
}