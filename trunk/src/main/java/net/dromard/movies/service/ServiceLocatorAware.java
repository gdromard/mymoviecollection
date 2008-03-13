package net.dromard.movies.service;

import net.dromard.movies.dao.GenericDAO;

public abstract class ServiceLocatorAware extends GenericDAO {
	private ServiceLocator serviceLocator;
	
	/**
	 * @param serviceLocator the serviceLocator to set
	 */
	public final void setServiceLocator(ServiceLocator serviceLocator) {
		this.serviceLocator = serviceLocator;
	}
	
	/**
	 * @return the serviceLocator to set
	 */
	protected final ServiceLocator getServiceLocator() {
		return serviceLocator;
	}
}
