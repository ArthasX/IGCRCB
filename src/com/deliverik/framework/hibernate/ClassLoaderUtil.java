package com.deliverik.framework.hibernate;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ClassLoaderUtil {

	@SuppressWarnings("rawtypes")
	public static Class loadClass(String className) {
		try {
			return getClassLoader().loadClass(className);
		} catch (ClassNotFoundException e) {
			throw new HibernateUtilException("class not found '" + className + "'", e);
		}
	}

	public static ClassLoader getClassLoader() {
		return ClassLoaderUtil.class.getClassLoader();
	}

	public static InputStream getStream(String resource) {
		return getClassLoader().getResourceAsStream(resource);
	}

	public static Properties getProperties(String resource) {
		Properties properties = new Properties();
		try {
			properties.load(getStream(resource));
		} catch (IOException e) {
			throw new HibernateUtilException("couldn't load properties file '" + resource + "'", e);
		}
		return properties;
	}

}

