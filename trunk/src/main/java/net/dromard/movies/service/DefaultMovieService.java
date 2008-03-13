package net.dromard.movies.service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.text.ParseException;
import java.util.List;

import net.dromard.movies.MovieApplicationContext;
import net.dromard.movies.model.Movie;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public class DefaultMovieService extends ServiceLocatorAware implements IMovieService {

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
		return super.findAll(Movie.class);
	}

	@SuppressWarnings("unchecked")
	public List<Movie> findByTitle(String title) {
		return getEntityManager().createQuery("from " + Movie.class.getName() + " as obj where lower(obj.title) like lower(" + formatString("%"+title+"%") + ") or lower(obj.originalTitle) like lower(" + formatString("%"+title+"%") + ")").getResultList();
	}

	public List<String> findFromWWWByTitle(String title) throws MalformedURLException, IOException {
		return MovieCoverExtractor.searchMovie(title);
	}

	public Movie getFromWWWByTitle(String title) throws MalformedURLException, IOException, ParseException {
		return MovieCoverExtractor.extractMovie(getServiceLocator(), title, MovieApplicationContext.getImagePath());
	}
}
