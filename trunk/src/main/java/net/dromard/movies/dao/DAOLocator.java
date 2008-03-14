package net.dromard.movies.dao;


public class DAOLocator {
	private ICastingDAO castingDAO;
	private IMovieDAO movieDAO;
	private IMovieNationalityDAO movieNationalityDAO;
	private IMovieGenreDAO movieGenreService;
	private IMovieQualityDAO movieQualityDAO;
	private IMovieFormatDAO movieFormatDAO;
	private IMovieVersionDAO movieVersionDAO;

	/**
	 * @return the movieDAO
	 */
	public IMovieDAO getMovieDAO() {
		return movieDAO;
	}

	/**
	 * @param movieDAO the movieDAO to set
	 */
	public void setMovieDAO(IMovieDAO movieDAO) {
		this.movieDAO = movieDAO;
	}

	/**
	 * @return the movieFormatDAO
	 */
	public IMovieFormatDAO getMovieFormatDAO() {
		return movieFormatDAO;
	}

	/**
	 * @param movieFormatDAO the movieFormatDAO to set
	 */
	public void setMovieFormatDAO(IMovieFormatDAO movieFormatDAO) {
		this.movieFormatDAO = movieFormatDAO;
	}

	/**
	 * @return the castingDAO
	 */
	public ICastingDAO getCastingDAO() {
		return castingDAO;
	}

	/**
	 * @param castingDAO the castingDAO to set
	 */
	public void setCastingDAO(ICastingDAO castingDAO) {
		this.castingDAO = castingDAO;
	}

	/**
	 * @return the movieNationalityDAO
	 */
	public IMovieNationalityDAO getMovieNationalityDAO() {
		return movieNationalityDAO;
	}

	/**
	 * @param movieNationalityDAO the movieNationalityDAO to set
	 */
	public void setMovieNationalityDAO(IMovieNationalityDAO movieNationalityDAO) {
		this.movieNationalityDAO = movieNationalityDAO;
	}

	/**
	 * @return the movieGenreService
	 */
	public IMovieGenreDAO getMovieGenreDAO() {
		return movieGenreService;
	}

	/**
	 * @param movieGenreService the movieGenreService to set
	 */
	public void setMovieGenreDAO(IMovieGenreDAO movieGenreDAO) {
		this.movieGenreService = movieGenreDAO;
	}

	/**
	 * @return the movieQualityDAO
	 */
	public IMovieQualityDAO getMovieQualityDAO() {
		return movieQualityDAO;
	}

	/**
	 * @param movieQualityDAO the movieQualityDAO to set
	 */
	public void setMovieQualityDAO(IMovieQualityDAO movieQualityDAO) {
		this.movieQualityDAO = movieQualityDAO;
	}

	/**
	 * @return the movieVersionDAO
	 */
	public IMovieVersionDAO getMovieVersionDAO() {
		return movieVersionDAO;
	}

	/**
	 * @param movieVersionDAO the movieVersionDAO to set
	 */
	public void setMovieVersionDAO(IMovieVersionDAO movieVersionDAO) {
		this.movieVersionDAO = movieVersionDAO;
	}
}
