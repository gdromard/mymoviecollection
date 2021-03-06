package net.dromard.movies.dao;

import java.util.List;

import net.dromard.movies.model.MovieQuality;

public interface IMovieQualityDAO {
	public MovieQuality findById(int id);
	
	public List<MovieQuality> findAll();
	
	public MovieQuality persist(MovieQuality entity);
	
	public void remove(int id);
	
	public void flush();

	public void clear();
}
