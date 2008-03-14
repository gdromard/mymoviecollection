package net.dromard.movies.dao;

public class DAOLocatorAware {
	private DAOLocator daoLocator;
	
	/**
	 * @param daoLocator the daoLocator to set
	 */
	public final void setDaoLocator(DAOLocator serviceLocator) {
		this.daoLocator = serviceLocator;
	}
	
	/**
	 * @return the daoLocator to set
	 */
	protected final DAOLocator getDaoLocator() {
		return daoLocator;
	}
}
