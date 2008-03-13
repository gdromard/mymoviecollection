package net.dromard.movies.util.JUnit;

import junit.framework.TestCase;
import net.dromard.movies.service.ServiceLocator;

import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.core.io.ClassPathResource;

public abstract class AbstractSpringTestCase extends TestCase {
	private ServiceLocator serviceLocator;
	
	@Override
	protected void setUp() throws Exception {
		try {
			super.setUp();
			GenericApplicationContext ctx = new GenericApplicationContext();
			XmlBeanDefinitionReader xmlReader = new XmlBeanDefinitionReader(ctx);
			xmlReader.loadBeanDefinitions(new ClassPathResource("applicationContext.xml"));
			ctx.refresh();
			setServiceLocator((ServiceLocator) ctx.getBean("serviceLocator"));
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	protected String getConfigLocation() {
		return "applicationContext.xml";
	}
	
	/**
	 * @param serviceLocator the serviceLocator to set
	 */
	public void setServiceLocator(ServiceLocator serviceLocator) {
		this.serviceLocator = serviceLocator;
	}
	
	/**
	 * @return the serviceLocator to set
	 */
	public ServiceLocator getServiceLocator() {
		return serviceLocator;
	}
}
