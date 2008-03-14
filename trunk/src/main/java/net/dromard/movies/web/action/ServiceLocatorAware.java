package net.dromard.movies.web.action;

import net.dromard.movies.service.ServiceLocator;

abstract class ServiceLocatorAware {
	private ServiceLocator serviceLocator;
	
	public final void setServiceLocator(ServiceLocator serviceLocator) {
		this.serviceLocator = serviceLocator;
	}

	protected ServiceLocator getServiceLocator() {
		return serviceLocator;
	}
}
