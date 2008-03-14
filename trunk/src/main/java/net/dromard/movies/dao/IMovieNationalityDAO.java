package net.dromard.movies.dao;

import java.util.List;

import net.dromard.movies.model.MovieNationality;

public interface IMovieNationalityDAO {
	public MovieNationality findById(int id);
	
	public List<MovieNationality> findAll();
	
	public MovieNationality persist(MovieNationality entity);
	
	public void remove(int id);
	
	public void flush();

	public void clear();

	public MovieNationality findOrCreate(String nationality);
}
