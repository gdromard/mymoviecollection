package net.dromard.movies.service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.text.ParseException;
import java.util.List;

import net.dromard.movies.model.Movie;

public interface IMovieService {
	public Movie findById(int id);
	
	public List<Movie> findAll();
	
	public Movie persist(Movie entity);
	
	public void remove(int id);
	
	public void flush();

	public void clear();

	public List<Movie> findByTitle(String title);

	public List<String> findFromWWWByTitle(String title) throws MalformedURLException, IOException;
	
	public Movie getFromWWWByTitle(String title) throws MalformedURLException, IOException, ParseException;
}
