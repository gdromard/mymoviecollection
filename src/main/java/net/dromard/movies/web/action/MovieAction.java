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

public class MovieAction extends ServiceLocatorAware implements ActionIF, Preparable {
    private Movie movie;
    private Integer id;
	private List<MovieFormat> formats;
	private List<MovieGenre> genres;
	private List<MovieNationality> nationalities;
	private List<MovieQuality> qualities;
	private List<MovieVersion> versions;
	private List<Casting> castings;
    private List<Movie> movies;

    /**
     * Default action does nothing just returning success.
     * @return success result.
     */
    public String execute() {
        return Action.SUCCESS;
    }

    /**
     * List action.
     * @return success result.
     */
    public String list() {
        this.movies = getServiceLocator().getDaoLocator().getMovieDAO().findAll();
        return Action.SUCCESS;
    }

    /**
     * Edit action.
     * @return success result.
     */
    public String edit() {
    	formats = getServiceLocator().getDaoLocator().getMovieFormatDAO().findAll();
    	genres = getServiceLocator().getDaoLocator().getMovieGenreDAO().findAll();
    	nationalities = getServiceLocator().getDaoLocator().getMovieNationalityDAO().findAll();
    	qualities = getServiceLocator().getDaoLocator().getMovieQualityDAO().findAll();
    	versions = getServiceLocator().getDaoLocator().getMovieVersionDAO().findAll();
    	castings = getServiceLocator().getDaoLocator().getCastingDAO().findAll();
    	System.out.println("[DEBUG] MovieAction.prepare() - formats.size: " + formats.size());
    	System.out.println("[DEBUG] MovieAction.prepare() - genres.size: " + genres.size());
    	System.out.println("[DEBUG] MovieAction.prepare() - nationality.size: " + nationalities.size());
    	System.out.println("[DEBUG] MovieAction.prepare() - qualities.size: " + qualities.size());
    	System.out.println("[DEBUG] MovieAction.prepare() - versions.size: " + versions.size());
    	System.out.println("[DEBUG] MovieAction.prepare() - castings.size: " + castings.size());
        return Action.SUCCESS;
    }

    /**
     * View action.
     * @return success result.
     */
    public String view() {
        return Action.SUCCESS;
    }

    /**
     * Update action.
     * @return success result.
     */
    public String update() {
        getServiceLocator().getDaoLocator().getMovieDAO().persist(movie);
        this.movie = null;
        return VIEW;
    }

    /**
     * Delete action.
     * @return success result.
     */
    public String delete() {
    	getServiceLocator().getDaoLocator().getMovieDAO().remove(id);
        return LIST;
    }

    /**
     * Prepare the action.
     */
    public void prepare() {
    	System.out.println("[DEBUG] MovieAction.prepare() - id: " + id);
        if (id != null) {
        	movie = getServiceLocator().getDaoLocator().getMovieDAO().findById(id);
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

    
    /* ------------- List Setters / Getters ------------- */

    public List<Movie> getMovies() {
        return movies;
    }
    
    /* ----------- Sub List Setters / Getters ----------- */
    
	public List<MovieFormat> getFormats() {
		return formats;
	}

	public List<MovieGenre> getGenres() {
		return genres;
	}

	public List<MovieNationality> getNationalities() {
		return nationalities;
	}

	public List<MovieQuality> getQualities() {
		return qualities;
	}

	public List<MovieVersion> getVersions() {
		return versions;
	}

	public List<Casting> getCastings() {
		return castings;
	}

	/**
	 * @param castings the castings to set
	 */
	public void setCastings(List<Casting> castings) {
		this.castings = castings;
	}

	/**
	 * @param formats the formats to set
	 */
	public void setFormats(List<MovieFormat> formats) {
		this.formats = formats;
	}

	/**
	 * @param genres the genres to set
	 */
	public void setGenres(List<MovieGenre> genres) {
		this.genres = genres;
	}

	/**
	 * @param nationality the nationality to set
	 */
	public void setNationalities(List<MovieNationality> nationality) {
		this.nationalities = nationality;
	}

	/**
	 * @param qualities the qualities to set
	 */
	public void setQualities(List<MovieQuality> qualities) {
		this.qualities = qualities;
	}

	/**
	 * @param versions the versions to set
	 */
	public void setVersions(List<MovieVersion> versions) {
		this.versions = versions;
	}
}