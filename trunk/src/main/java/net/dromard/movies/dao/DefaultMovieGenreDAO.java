package net.dromard.movies.dao;

import java.util.List;

import net.dromard.movies.model.MovieGenre;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public class DefaultMovieGenreDAO extends GenericDAO implements IMovieGenreDAO {

	public MovieGenre findById(int id) {
		return super.findById(MovieGenre.class, id);
	}

	protected Class<MovieGenre> getEntityClass() {
		return MovieGenre.class;
	}

	public MovieGenre persist(MovieGenre entity) {
		if (entity.getId() == null) {
			return super.create(entity);
		} else { 
			return super.update(entity);
		}
	}

	public void remove(int id) {
		super.remove(getEntityClass(), id);
	}

	public List<MovieGenre> findAll() {
		return super.findAll(MovieGenre.class);
	}

	@SuppressWarnings("unchecked")
	public MovieGenre findOrCreate(String name) {
		List<MovieGenre> found = getEntityManager().createQuery("from " + MovieGenre.class.getName() + " as obj where lower(obj.name) = lower(" + formatString(name) + ")").getResultList();
		if (found.size() > 0) {
			return found.get(0);
		}
		return new MovieGenre(name);
	}
}
