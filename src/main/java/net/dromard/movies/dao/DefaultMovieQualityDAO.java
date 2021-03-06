package net.dromard.movies.dao;

import java.util.List;

import net.dromard.movies.model.MovieQuality;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public class DefaultMovieQualityDAO extends GenericDAO implements IMovieQualityDAO {

	public MovieQuality findById(int id) {
		return super.findById(MovieQuality.class, id);
	}

	protected Class<MovieQuality> getEntityClass() {
		return MovieQuality.class;
	}

	public MovieQuality persist(MovieQuality entity) {
		if (entity.getId() == null) {
			return super.create(entity);
		} else { 
			return super.update(entity);
		}
	}

	public void remove(int id) {
		super.remove(getEntityClass(), id);
	}

	public List<MovieQuality> findAll() {
		return super.findAll(MovieQuality.class, "name");
	}
}
