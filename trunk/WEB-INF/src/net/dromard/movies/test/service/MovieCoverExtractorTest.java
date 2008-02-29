package net.dromard.movies.test.service;

import java.util.List;

import net.dromard.movies.service.MovieCoverExtractor;
import net.dromard.movies.util.JUnit.AbstractSpringTestCase;

public class MovieCoverExtractorTest  extends AbstractSpringTestCase {

	public void testSearchMovie() {
		try {
			List<String> searchResult = MovieCoverExtractor.searchMovie("matrux");
			assertNotNull(searchResult);
			assertTrue(searchResult.size() >= 4);
			MovieCoverExtractor.extractMovie(getServiceLocator(), searchResult.get(1), "./");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
