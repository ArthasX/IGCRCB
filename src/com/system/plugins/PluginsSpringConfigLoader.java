package com.system.plugins;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.web.context.ConfigurableWebApplicationContext;
import org.springframework.web.context.WebApplicationContext;

import com.deliverik.framework.platform.WebContextLoaderPlugIn;
import com.system.plugins.utils.PluginsDataUtils;

public class PluginsSpringConfigLoader extends WebContextLoaderPlugIn {
	final String SPRING_FILE_NAME = "applicationContext.xml";
	final String PLUGIN_PATH = "/WEB-INF/plugin";
	
	/*****
	 * 加载配置文件
	 */
	protected WebApplicationContext createWebApplicationContext(
			WebApplicationContext parent) throws BeansException {
		ConfigurableWebApplicationContext wac = (ConfigurableWebApplicationContext) 
				BeanUtils.instantiateClass(getContextClass());
		 wac.setParent(parent);
		 wac.setServletContext(getServletContext());
		 wac.setNamespace(getNamespace());
		 wac.setConfigLocations(getConfig());
		 wac.refresh();
		return wac;
	}
	
	/****
	 * 返回所有插件的配置文件信息
	 * @return
	 */
	private String[] getConfig(){
		PluginsDataUtils pdUtil = new PluginsDataUtils();
		String path = pdUtil.getAbsolutePathByClass()+PLUGIN_PATH;
		List<String> configFiles = new ArrayList<String>();
		//默认配置文件地址
		configFiles.add("/WEB-INF/applicationContext/"+SPRING_FILE_NAME);
		//取得所有插件目录
		
		FileInputStream in;
		String pluginStatus = "N";  //初始化插件状态

		File[] files = new File(path).listFiles();
		File configFile = null;
		if(files!=null && files.length>0){
			for(int i = 0; i < files.length; i++){
				Properties prop = new Properties();
				try {
					in = new FileInputStream(files[i].getPath()+ File.separator +"config/config.properties");
					prop.load(in);
				} catch (Exception e) {
					continue;
				}
				pluginStatus = prop.getProperty("PLUGIN_STATUS");
				if(!"Y".equals(pluginStatus)){
					continue;
				}
				configFile = new File(files[i].getPath()+"/config/"+SPRING_FILE_NAME);
				if(configFile.exists()){
					configFiles.add(PLUGIN_PATH+"/"+files[i].getName()+"/config/"+SPRING_FILE_NAME);
				}
			}
		}
		return (String[])configFiles.toArray(new String[configFiles.size()]);
	}
}
