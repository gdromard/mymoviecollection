package net.dromard.movies.test.service;

import java.util.List;

import net.dromard.common.jdbc.DBManager;
import net.dromard.movies.model.Casting;
import net.dromard.movies.util.DBUtil;
import net.dromard.movies.util.JUnit.AbstractSpringTestCase;

public class CastingServiceTest extends AbstractSpringTestCase {

	public void testFindAll() {
		try {
			List<Casting> castings = getServiceLocator().getCastingService().findAll();
			for (Casting casting : castings) {
				System.out.println(casting.toString());
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
			Casting casting = new Casting();
			casting.setFirstname("Firstname");
			casting.setLastname("Lastname");
			casting = getServiceLocator().getCastingService().persist(casting);
			assertNotNull(casting.getId());
			id = casting.getId();
			List<String[]> casting0 = dbManager.getQueryResult("SELECT ID, FIRSTNAME, LASTNAME FROM CASTING WHERE ID = " + id);
			assertNotNull(casting0);
			assertTrue(casting0.size() == 2);
			assertTrue(casting0.get(1).length > 0);
			assertTrue(casting0.get(1)[1].equals("Firstname"));
			assertTrue(casting0.get(1)[2].equals("Lastname"));
			// Update
			casting = getServiceLocator().getCastingService().findById(casting.getId());
			casting.setFirstname("FIRSTNAME");
			casting.setLastname("LASTNAME");
			getServiceLocator().getCastingService().persist(casting);
			casting0 = dbManager.getQueryResult("SELECT ID, FIRSTNAME, LASTNAME FROM CASTING WHERE ID = " + id);
			assertNotNull(casting0);
			assertTrue(casting0.size() == 2);
			assertTrue(casting0.get(1).length > 0);
			assertTrue(casting0.get(1)[1].equals("FIRSTNAME"));
			assertTrue(casting0.get(1)[2].equals("LASTNAME"));
			DBManager.printQueryResult(casting0);
		} finally {
			assertTrue(id > -1);
			dbManager.executeUpdate("DELETE FROM CASTING WHERE ID = " + id);
		}
	}

	public void testRemove() throws Exception {
		DBManager createDBManager = DBUtil.createDBManager();
		createDBManager.executeUpdate("DELETE FROM CASTING WHERE ID = 6666");
		createDBManager.executeQuery("INSERT INTO CASTING (ID, FIRSTNAME, LASTNAME) VALUES (6666, 'TEST', 'TEST')");
		try {
			Casting entity = getServiceLocator().getCastingService().findById(6666);
			getServiceLocator().getCastingService().remove(entity.getId());
			List<String[]> casting0 = createDBManager.getQueryResult("SELECT * FROM CASTING WHERE ID = 6666");
			assertNull(casting0);
		} catch (Exception ex) {
			ex.printStackTrace();
			createDBManager.executeUpdate("DELETE FROM CASTING WHERE ID = 6666");
			throw ex;
		}
	}

	public void testFind() {
		try {
			Casting casting = getServiceLocator().getCastingService().findById(1);
			assertNotNull("Casting with id 1 must be found", casting);
			assertNotNull("Casting must have a non null format", casting.getFirstname());
			assertNotNull("Casting must have a non null version", casting.getLastname());
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
}
