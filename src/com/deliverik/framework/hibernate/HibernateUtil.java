package com.deliverik.framework.hibernate;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
//import org.jbpm.JbpmException;
//import org.jbpm.util.ClassLoaderUtil;

@SuppressWarnings("rawtypes")
public abstract class HibernateUtil {

	/** maps SessionFactory's to Configurations. */
	/** by default, configuration lookup will be enabled */

	static Map configurations = new HashMap();

	public static void clearConfigurationsCache() {
		configurations = new HashMap();
	}

	public static SessionFactory createSessionFactory() {
		return createSessionFactory(null, null, true);
	}

	public static SessionFactory createSessionFactory(String cfgXmlResource) {
		return createSessionFactory(cfgXmlResource, null, true);
	}

	public static SessionFactory createSessionFactory(String cfgXmlResource,
			String propertiesResource) {
		return createSessionFactory(cfgXmlResource, propertiesResource, true);
	}

	public static SessionFactory createSessionFactory(String cfgXmlResource,
			String propertiesResource, boolean isConfigLookupEnabled) {
		Configuration configuration = createConfiguration(cfgXmlResource,
				propertiesResource);
		return createSessionFactory(configuration, isConfigLookupEnabled);
	}

	public static SessionFactory createAnnotationSessionFactory(
			String cfgXmlResource) {
		AnnotationConfiguration configuration = new AnnotationConfiguration();
		if (cfgXmlResource != null) {
			configuration.configure(cfgXmlResource);
		}
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		return sessionFactory;
	}

	@SuppressWarnings("unchecked")
	public static SessionFactory createSessionFactory(
			Configuration configuration, boolean isConfigLookupEnabled) {
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		if (isConfigLookupEnabled) {
			configurations.put(sessionFactory, configuration);
		}
		return sessionFactory;
	}

	public static Configuration createConfiguration(String cfgXmlResource,
			String propertiesResource) {
		Configuration configuration = new Configuration();

		// if a special hibernate configuration xml file is specified,
		if (cfgXmlResource != null) {
			// use the configured file name
			log.debug("creating hibernate configuration resource '"
					+ cfgXmlResource + "'");
			configuration.configure(cfgXmlResource);
		} else {
			log.debug("using default hibernate configuration resource (hibernate.cfg.xml)");
			configuration.configure();
		}

		// if the properties are specified in a separate file
		if (propertiesResource != null) {
			log.debug("using hibernate properties from resource '"
					+ propertiesResource + "'");
			// load the properties
			Properties properties = loadPropertiesFromResource(propertiesResource);
			// and overwrite the properties with the specified properties
			configuration.setProperties(properties);
		}

		return configuration;
	}

	public static Configuration getConfiguration(SessionFactory sessionFactory) {
		return (Configuration) configurations.get(sessionFactory);
	}

	public static SchemaExport createSchemaExport(SessionFactory sessionFactory) {
		return new SchemaExport(getConfiguration(sessionFactory));
	}

	public static boolean createSchemaExportScript(SessionFactory sessionFactory) {
		boolean script = false;
		String showSql = getConfiguration(sessionFactory).getProperty(
				"hibernate.show_sql");
		if ("true".equalsIgnoreCase(showSql)) {
			script = true;
		}
		return script;
	}

	public static void clearHibernateCache(SessionFactory sessionFactory) {
		sessionFactory.evictQueries();

		Map classMetadata = sessionFactory.getAllClassMetadata();
		Iterator iter = classMetadata.keySet().iterator();
		while (iter.hasNext()) {
			String entityName = (String) iter.next();
			log.debug("evicting entities " + entityName);
			Class entityClass = ClassLoaderUtil.loadClass(entityName);
			sessionFactory.evict(entityClass);
		}

		Map collectionMetadata = sessionFactory.getAllCollectionMetadata();
		iter = collectionMetadata.keySet().iterator();
		while (iter.hasNext()) {
			String collectionName = (String) iter.next();
			log.debug("evicting collection " + collectionName);
			sessionFactory.evictCollection(collectionName);
		}
	}

	static Properties loadPropertiesFromResource(String resource) {
		Properties properties = new Properties();
		try {
			InputStream inputStream = ClassLoaderUtil.getStream(resource);
			properties.load(inputStream);

		} catch (NullPointerException e) {
			throw new HibernateUtilException(
					"couldn't load hibernate properties from unexisting resource '"
							+ resource + "'", e);
		} catch (IOException e) {
			throw new HibernateUtilException(
					"couldn't load hibernate properties from resource '"
							+ resource + "'", e);
		}
		return properties;
	}

	private static Log log = LogFactory.getLog(HibernateUtil.class);
}
