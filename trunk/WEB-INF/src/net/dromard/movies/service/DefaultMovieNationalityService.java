package net.dromard.movies.service;

import java.util.List;

import net.dromard.movies.dao.GenericDAO;
import net.dromard.movies.model.MovieNationality;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public class DefaultMovieNationalityService extends GenericDAO implements IMovieNationalityService {

	public MovieNationality findById(int id) {
		return super.findById(MovieNationality.class, id);
	}

	protected Class<MovieNationality> getEntityClass() {
		return MovieNationality.class;
	}

	public MovieNationality persist(MovieNationality entity) {
		if (entity.getId() == null) {
			return super.create(entity);
		} else { 
			return super.update(entity);
		}
	}

	public void remove(int id) {
		super.remove(getEntityClass(), id);
	}

	public List<MovieNationality> findAll() {
		return super.findAll(MovieNationality.class);
	}

	@SuppressWarnings("unchecked")
	public MovieNationality findOrCreate(String name) {
		List<MovieNationality> found = getEntityManager().createQuery("from " + MovieNationality.class.getName() + " as obj where lower(obj.name) = lower(" + formatString(name) + ")").getResultList();
		if (found.size() > 0) {
			return found.get(0);
		}
		return new MovieNationality(name);
	}
}
