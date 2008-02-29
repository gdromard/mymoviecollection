package net.dromard.movies.test.service;

import java.util.List;

import net.dromard.movies.model.MovieFormat;
import net.dromard.movies.util.JUnit.AbstractSpringTestCase;

public class MovieFormatServiceTest extends AbstractSpringTestCase {
	public void testMovieFormats() {
		try {
			List<MovieFormat> movieFormats = getServiceLocator().getMovieFormatService().findAll();
			for (MovieFormat movieFormat : movieFormats) {
				System.out.println(movieFormat.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
}
