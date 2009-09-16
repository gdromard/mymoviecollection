package net.dromard.movies.dao;

import java.util.List;

import net.dromard.movies.model.Movie;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public class DefaultMovieDAO extends GenericDAO implements IMovieDAO {

	public Movie findById(int id) {
		return super.findById(Movie.class, id);
	}

	protected Class<Movie> getEntityClass() {
		return Movie.class;
	}

	public Movie persist(Movie entity) {
		if (entity.getId() == null) {
			return super.create(entity);
		} else { 
			return super.update(entity);
		}
	}

	public void remove(int id) {
		super.remove(getEntityClass(), id);
	}

	public List<Movie> findAll() {
		return super.findAll(Movie.class, "title");
	}

	@SuppressWarnings("unchecked")
	public List<Movie> find(String search) {
		return getEntityManager().createQuery("from " + Movie.class.getName() + " as obj where lower(obj.title) like lower(" + formatString("%"+search+"%") + ") or lower(obj.originalTitle) like lower(" + formatString("%"+search+"%") + ") or lower(obj.synopsis) like lower(" + formatString("%"+search+"%") + ")").getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Movie> findByTitle(String title) {
		return getEntityManager().createQuery("from " + Movie.class.getName() + " as obj where lower(obj.title) like lower(" + formatString("%"+title+"%") + ") or lower(obj.originalTitle) like lower(" + formatString("%"+title+"%") + ")").getResultList();
	}

	public Movie findNext(Movie movie) {
		return super.findNext(movie, "title", movie.getTitle());
	}

	public Movie findPrevious(Movie movie) {
		return super.findPrevious(movie, "title", movie.getTitle());
	}
}
