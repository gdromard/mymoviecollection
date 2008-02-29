package net.dromard.movies.test.service;

import java.util.Date;
import java.util.List;

import net.dromard.common.jdbc.DBManager;
import net.dromard.movies.model.Movie;
import net.dromard.movies.util.DBUtil;
import net.dromard.movies.util.JUnit.AbstractSpringTestCase;

public class MovieServiceTest extends AbstractSpringTestCase {

	public void testFindAll() {
		try {
			List<Movie> movies = getServiceLocator().getMovieService().findAll();
			for (Movie movie : movies) {
				System.out.println(movie.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	public void testSave() throws Exception {
		DBManager dbManager = DBUtil.createDBManager();
		int id = -1;
		try {
			// Create
			Movie movie = new Movie();
			movie.setTitle("TEST");
			movie = getServiceLocator().getMovieService().persist(movie);
			id = movie.getId();
			List<String[]> movie0 = dbManager.getQueryResult("SELECT ID, TITLE FROM MOVIE WHERE ID = " + id);
			assertNotNull(movie0);
			assertTrue(movie0.size() == 2);
			assertTrue(movie0.get(1).length > 0);
			assertTrue(movie0.get(1)[1].equals("TEST"));
			// Update
			movie = getServiceLocator().getMovieService().findById(movie.getId());
			movie.setSynopsis("This is a TEST movie");
			movie.setSize(600);
			movie.setLength(new Date(60*60*2)); // 2h = 60s/minutes * 60minutes/Hours * 2 hours
			movie = getServiceLocator().getMovieService().persist(movie);
			movie0 = dbManager.getQueryResult("SELECT ID, TITLE, SYNOPSIS, SIZE, LENGTH FROM MOVIE WHERE ID = " + id);
			assertNotNull(movie0);
			assertTrue(movie0.size() == 2);
			assertTrue(movie0.get(1).length > 0);
			assertTrue(movie0.get(1)[1].equals("TEST"));
			assertTrue(movie0.get(1)[2].equals("This is a TEST movie"));
			assertTrue(movie0.get(1)[3].equals("600"));
			assertTrue(movie0.get(1)[4] != null);
			DBManager.printQueryResult(movie0);
		} finally {
			assertTrue(id > -1);
			dbManager.executeUpdate("DELETE FROM MOVIE WHERE ID = " + id);
		}
	}

	public void testRemove() throws Exception {
		DBManager createDBManager = DBUtil.createDBManager();
		createDBManager.executeQuery("INSERT INTO MOVIE (ID, TITLE) VALUES (0, 'TEST')");
		try {
			getServiceLocator().getMovieService().remove(0);
			
			List<String[]> movie0 = createDBManager.getQueryResult("SELECT * FROM MOVIE WHERE ID = 0");
			assertNull(movie0);
		} catch (Exception ex) {
			createDBManager.executeUpdate("DELETE FROM MOVIE WHERE ID = 0");
			throw ex;
		}
	}

	public void testFind() {
		try {
			Movie movie = getServiceLocator().getMovieService().findById(1);
			assertNotNull("Movie with id 1 must be found", movie);
			assertNotNull("Movie must have a non null format", movie.getFormat());
			assertNotNull("Movie must have a non null version", movie.getVersion());
			assertNotNull("Movie must have a non null quality", movie.getQuality());
			assertNotNull("Movie must have a non null genre", movie.getGenre());
			assertNotNull("Movie must have a non null nationality", movie.getNationality());
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
}
