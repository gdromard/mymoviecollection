package net.dromard.movies.dao;

import java.util.List;

import net.dromard.movies.model.Movie;

public interface IMovieDAO {
	public Movie findNext(Movie movie);
	
	public Movie findPrevious(Movie movie);
	
	public Movie findById(int id);
	
	public List<Movie> findAll();
	
	public Movie persist(Movie entity);
	
	public void remove(int id);
	
	public void flush();

	public void clear();

	public List<Movie> findByTitle(String title);

	public List<Movie> find(String query);
}
