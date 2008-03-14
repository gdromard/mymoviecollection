package net.dromard.movies.dao;

import java.util.List;

import net.dromard.movies.model.MovieGenre;

public interface IMovieGenreDAO {
	public MovieGenre findById(int id);
	
	public List<MovieGenre> findAll();
	
	public MovieGenre persist(MovieGenre entity);
	
	public void remove(int id);
	
	public void flush();

	public void clear();

	public MovieGenre findOrCreate(String genre);
}
