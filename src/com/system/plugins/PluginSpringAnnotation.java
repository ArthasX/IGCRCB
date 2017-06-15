package com.system.plugins;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;

import org.hibernate.HibernateException;
import org.hibernate.cfg.AnnotationConfiguration;
import org.springframework.orm.hibernate3.annotation.AnnotationSessionFactoryBean;

import com.system.plugins.utils.PluginsDataUtils;

public class PluginSpringAnnotation extends AnnotationSessionFactoryBean{
	
	protected void postProcessAnnotationConfiguration(AnnotationConfiguration config) throws HibernateException {
		try {

			PluginsDataUtils pluginUtil = new PluginsDataUtils();
			String path = pluginUtil.getAbsolutePathByClass();
			path = path + "WEB-INF" + File.separator + "plugin";
			
			List<String> pluginList = pluginUtil.getPluginPath(path);
			FileInputStream in;
			String pluginStatus = "N";  //³õÊ¼»¯²å¼þ×´Ì¬
			File dataFile = null;
			for(String pluginPath:pluginList){
				in = new FileInputStream(pluginPath+ File.separator +"config/config.properties");
				Properties prop = new Properties();
				prop.load(in);
		    	pluginStatus = prop.getProperty("PLUGIN_STATUS");
		    	String dataFilePath = pluginPath+ File.separator +"/config/data.xml";
		    	if("Y".equals(pluginStatus)){
			    	dataFile = new File(dataFilePath);
			    	if(!dataFile.exists()){
			    		continue;
			    	}
			    	List<String> entityList = pluginUtil.parseXmlToEntityList(dataFilePath);
			    	for(String entityPath:entityList){
			    		config.addAnnotatedClass(Class.forName(entityPath));
			    	}
		    	}
			}
		} catch (Exception e) {
			throw new HibernateException(e);
		} 
		
	}
}
