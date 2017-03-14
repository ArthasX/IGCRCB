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
	 * ���������ļ�
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
	 * �������в���������ļ���Ϣ
	 * @return
	 */
	private String[] getConfig(){
		PluginsDataUtils pdUtil = new PluginsDataUtils();
		String path = pdUtil.getAbsolutePathByClass()+PLUGIN_PATH;
		List<String> configFiles = new ArrayList<String>();
		//Ĭ�������ļ���ַ
		configFiles.add("/WEB-INF/applicationContext/"+SPRING_FILE_NAME);
		//ȡ�����в��Ŀ¼
		
		FileInputStream in;
		String pluginStatus = "N";  //��ʼ�����״̬

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
