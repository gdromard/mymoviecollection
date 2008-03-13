package net.dromard.movies.service;

import java.util.List;

import net.dromard.movies.model.MovieVersion;

public interface IMovieVersionService {
	public MovieVersion findById(int id);
	
	public List<MovieVersion> findAll();
	
	public MovieVersion persist(MovieVersion entity);
	
	public void remove(int id);
	
	public void flush();

	public void clear();
}
