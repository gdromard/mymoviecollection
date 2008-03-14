package net.dromard.movies.dao;

import java.util.List;

import net.dromard.movies.model.MovieFormat;

public interface IMovieFormatDAO {
	public MovieFormat findById(int id);
	
	public List<MovieFormat> findAll();
	
	public MovieFormat persist(MovieFormat entity);
	
	public void remove(int id);
	
	public void flush();

	public void clear();
}
