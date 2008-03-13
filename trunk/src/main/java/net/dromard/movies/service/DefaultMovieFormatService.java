package net.dromard.movies.service;

import java.util.List;

import net.dromard.movies.dao.GenericDAO;
import net.dromard.movies.model.MovieFormat;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public class DefaultMovieFormatService extends GenericDAO implements IMovieFormatService {

	public MovieFormat findById(int id) {
		return super.findById(MovieFormat.class, id);
	}

	protected Class<MovieFormat> getEntityClass() {
		return MovieFormat.class;
	}

	public MovieFormat persist(MovieFormat entity) {
		if (entity.getId() == null) {
			return super.create(entity);
		} else { 
			return super.update(entity);
		}
	}

	public void remove(int id) {
		super.remove(getEntityClass(), id);
	}

	public List<MovieFormat> findAll() {
		return super.findAll(MovieFormat.class);
	}
}
