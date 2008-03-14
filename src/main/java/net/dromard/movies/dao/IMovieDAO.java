package net.dromard.movies.dao;

import java.io.IOException;
import java.net.MalformedURLException;
import java.text.ParseException;
import java.util.List;

import net.dromard.movies.MovieApplicationContext;
import net.dromard.movies.model.Movie;

public interface IMovieDAO {
	public Movie findById(int id);
	
	public List<Movie> findAll();
	
	public Movie persist(Movie entity);
	
	public void remove(int id);
	
	public void flush();

	public void clear();

	public List<Movie> findByTitle(String title);
}
