package net.dromard.movies.dao;

import java.util.List;

import net.dromard.movies.model.Casting;

public interface ICastingDAO {
	public Casting findById(int id);
	
	public List<Casting> findAll();
	
	public Casting persist(Casting entity);
	
	public void remove(int id);
	
	public void flush();

	public void clear();

	public Casting findOrCreate(String firstname, String lastname);
}
