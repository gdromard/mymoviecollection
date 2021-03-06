package net.dromard.movies.service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.text.ParseException;
import java.util.List;

import net.dromard.movies.model.Movie;

public interface IMovieExtractorService {

	public List<String> findFromWWWByTitle(String title) throws MalformedURLException, IOException;
	
	public Movie getFromWWWByTitle(String title) throws MalformedURLException, IOException, ParseException;
}
