package net.dromard.movies.dao;

import java.util.List;

import net.dromard.movies.model.MovieNationality;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public class DefaultMovieNationalityDAO extends GenericDAO implements IMovieNationalityDAO {

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
		return super.findAll(MovieNationality.class, "name");
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
