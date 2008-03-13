package net.dromard.movies;

import java.io.File;

import net.dromard.movies.service.ServiceLocator;

import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class MovieApplicationContext {
	private static ServiceLocator serviceLocator;
	private static String imagePath = "";
	static {
		imagePath = new File(".").getAbsolutePath();
		if (imagePath.indexOf("WEB-INF") > -1) {
			imagePath = imagePath.substring(0, imagePath.indexOf("WEB-INF")) + "/images";
		}
		System.out.println("[INFO] Images path: " + imagePath);
	}
	
	public static synchronized ServiceLocator getServiceLocator() throws Exception {
		if (serviceLocator == null) {
			GenericApplicationContext ctx = new GenericApplicationContext();
			XmlBeanDefinitionReader xmlReader = new XmlBeanDefinitionReader(ctx);
			xmlReader.loadBeanDefinitions(new ClassPathResource("applicationContext.xml"));
			ctx.refresh();
			serviceLocator = (ServiceLocator) ctx.getBean("serviceLocator");
		}
		return serviceLocator;
	}

	public static String getImagePath() {
		return imagePath;
	}
}
