package net.dromard.movies.service;

import net.dromard.movies.service.ICastingService;
import net.dromard.movies.service.IMovieFormatService;
import net.dromard.movies.service.IMovieService;

public class ServiceLocator {
	private ICastingService castingService;
	private IMovieService movieService;
	private IMovieNationalityService movieNationalityService;
	private IMovieGenreServce movieGenreService;
	private IMovieQualityService movieQualityService;
	private IMovieFormatService movieFormatService;
	private IMovieVersionService movieVersionService;

	/**
	 * @return the movieService
	 */
	public IMovieService getMovieService() {
		return movieService;
	}

	/**
	 * @param movieService the movieService to set
	 */
	public void setMovieService(IMovieService movieDAO) {
		this.movieService = movieDAO;
	}

	/**
	 * @return the movieFormatService
	 */
	public IMovieFormatService getMovieFormatService() {
		return movieFormatService;
	}

	/**
	 * @param movieFormatService the movieFormatService to set
	 */
	public void setMovieFormatService(IMovieFormatService movieFormatDAO) {
		this.movieFormatService = movieFormatDAO;
	}

	/**
	 * @return the castingService
	 */
	public ICastingService getCastingService() {
		return castingService;
	}

	/**
	 * @param castingService the castingService to set
	 */
	public void setCastingService(ICastingService castingService) {
		this.castingService = castingService;
	}

	/**
	 * @return the movieNationalityService
	 */
	public IMovieNationalityService getMovieNationalityService() {
		return movieNationalityService;
	}

	/**
	 * @param movieNationalityService the movieNationalityService to set
	 */
	public void setMovieNationalityService(IMovieNationalityService movieNationalityDAO) {
		this.movieNationalityService = movieNationalityDAO;
	}

	/**
	 * @return the movieGenreService
	 */
	public IMovieGenreServce getMovieGenreService() {
		return movieGenreService;
	}

	/**
	 * @param movieGenreService the movieGenreService to set
	 */
	public void setMovieGenreService(IMovieGenreServce movieGenreDAO) {
		this.movieGenreService = movieGenreDAO;
	}

	/**
	 * @return the movieQualityService
	 */
	public IMovieQualityService getMovieQualityService() {
		return movieQualityService;
	}

	/**
	 * @param movieQualityService the movieQualityService to set
	 */
	public void setMovieQualityService(IMovieQualityService movieQualityDAO) {
		this.movieQualityService = movieQualityDAO;
	}

	/**
	 * @return the movieVersionService
	 */
	public IMovieVersionService getMovieVersionService() {
		return movieVersionService;
	}

	/**
	 * @param movieVersionService the movieVersionService to set
	 */
	public void setMovieVersionService(IMovieVersionService movieVersionDAO) {
		this.movieVersionService = movieVersionDAO;
	}
}
