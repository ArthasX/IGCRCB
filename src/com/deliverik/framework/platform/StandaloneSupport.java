package com.deliverik.framework.platform;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

public class StandaloneSupport {

	private static BeanFactory beanFactory = null;
	
	// sample config file : 
	//"D:\\workspace\\InfoGovernor\\WebContent\\WEB-INF\\applicationContext\\applicationContext.xml";

	
	public static void initStandaloneSupport(String configFile) {
		Resource resource = new FileSystemResource(configFile);
        beanFactory = new XmlBeanFactory(resource);
	}
	
	public static Object getBean(String name) {
		return getBeanFactory().getBean(name);
	}

	public static BeanFactory getBeanFactory() {
		return beanFactory;
	}
	
	public static void setBeanFactory(BeanFactory beanFactory) {
		StandaloneSupport.beanFactory = beanFactory;
	}
	
}
