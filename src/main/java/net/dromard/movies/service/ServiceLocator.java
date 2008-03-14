package net.dromard.movies.service;

import net.dromard.movies.dao.DAOLocator;


public class ServiceLocator {
	private DAOLocator daoLocator;
	private IMovieExtractorService movieExtractorService;

	public DAOLocator getDaoLocator() {
		return daoLocator;
	}
	public void setDaoLocator(DAOLocator daoLocator) {
		this.daoLocator = daoLocator;
	}
	public IMovieExtractorService getMovieExtractorService() {
		return movieExtractorService;
	}
	public void setMovieExtractorService(IMovieExtractorService movieExtractorService) {
		this.movieExtractorService = movieExtractorService;
	}
}
