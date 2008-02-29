package net.dromard.movies.test.web;

import net.dromard.movies.util.JUnit.AbstractStrutsTestCase;
import net.dromard.movies.web.action.MovieAction;

public class MovieTest extends AbstractStrutsTestCase {

	/**
	 * Invoke all interceptors and specify value of the action
	 * class' domain objects directly.
	 * @throws Exception Exception
	 */
	public void testInterceptorsBySettingDomainObjects() throws Exception {
		MovieAction action = createAction(MovieAction.class, "movie", "delete");
		action.setId(66666);
		String result = proxy.execute();
		assertEquals(result, "success");
	} 

	/**
	 * Invoke all interceptors and specify value of action class'
	 * domain objects through request parameters.
	 * @throws Exception Exception
	 */
	public void testInterceptorsBySettingRequestParameters() throws Exception {
		createAction(MovieAction.class, "movie", "delete");
		request.addParameter("id", "66666");
		String result = proxy.execute();
		assertEquals(result, "success");
	} 

	/**
	 * Skip interceptors and specify value of action class'
	 * domain objects by setting them directly.
	 * @throws Exception Exception
	 */
	public void testActionAndSkipInterceptors() throws Exception {
		MovieAction action = createAction(MovieAction.class, "movie", "add");
		request.addParameter("id", "66666");
		request.addParameter("title", "Test");
		String result = action.save();
		assertEquals(result, "success");
	}
}

