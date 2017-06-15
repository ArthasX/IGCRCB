package com.system.plugins;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionServlet;
import org.apache.struts.action.PlugIn;
import org.apache.struts.config.ModuleConfig;

import com.system.plugins.utils.PluginsDataUtils;

public class PluginJarLoader implements PlugIn{
	static Log log = LogFactory.getLog(PluginJarLoader.class);

	public void init(ActionServlet servlet, ModuleConfig config) throws ServletException {
		PluginsDataUtils pdUtil = new PluginsDataUtils();
		String rootPath = pdUtil.getAbsolutePathByClass();
		String path = rootPath + "WEB-INF" + File.separator + "plugin";
		List<String> urlList = new ArrayList<String>();
		PluginsDataUtils pluginUtil = new PluginsDataUtils();
		List<String> pluginList = pluginUtil.getPluginPath(path);
		for(String pluginPath:pluginList){
			File jarDir = new File(pluginPath+"/lib");
			if(jarDir.isDirectory()){
				File[] jarFiles = jarDir.listFiles();
				if(jarFiles!=null){
					for(File jarFile:jarFiles){
						String fileType = jarFile.getName().substring(jarFile.getName().length()-3,jarFile.getName().length());
						if(jarFile.exists()&&"jar".equals(fileType)){
							urlList.add(jarFile.toURI().toString());
						}
					}
				}
			}
		}

		URL[] jarURLs = new URL[urlList.size()];
		for(int i=0;i<urlList.size();i++){
			try {
				jarURLs[i] = new URL(urlList.get(i));
			} catch (MalformedURLException e) {
				
			}
		}
		URLClassLoader loader = new URLClassLoader(jarURLs ,Thread.currentThread().getContextClassLoader());
		Thread.currentThread().setContextClassLoader(loader);   
	}



	public void destroy() {
	}
}
