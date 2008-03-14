package net.dromard.movies.dao;

import java.util.List;

import net.dromard.movies.model.MovieVersion;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public class DefaultMovieVersionDAO extends GenericDAO implements IMovieVersionDAO {

	public MovieVersion findById(int id) {
		return super.findById(MovieVersion.class, id);
	}

	protected Class<MovieVersion> getEntityClass() {
		return MovieVersion.class;
	}

	public MovieVersion persist(MovieVersion entity) {
		if (entity.getId() == null) {
			return super.create(entity);
		} else { 
			return super.update(entity);
		}
	}

	public void remove(int id) {
		super.remove(getEntityClass(), id);
	}

	public List<MovieVersion> findAll() {
		return super.findAll(MovieVersion.class);
	}
}
