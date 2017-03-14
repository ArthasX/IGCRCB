package com.system.plugins;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.UnavailableException;

import org.apache.commons.digester.Digester;
import org.apache.struts.Globals;
import org.apache.struts.action.ActionServlet;
import org.apache.struts.config.ModuleConfig;

import com.system.plugins.utils.PluginsDataUtils;

public class PluginsConfigLoader extends ActionServlet{
	private static final long serialVersionUID = 3085693237753703643L;

	protected ModuleConfig initModuleConfig(String prefix, String paths)
			throws ServletException {
		PluginsDataUtils pdUtil = new PluginsDataUtils();
		FileInputStream in;
		String pluginName = "";   //��ʼ���������
		String pluginStatus = "N";  //��ʼ�����״̬
		ModuleConfig config = super.initModuleConfig(prefix,paths);
		Digester digester = initConfigDigester();
		String path = pdUtil.getAbsolutePathByClass();
		String pluginPath = path + "WEB-INF" + File.separator + "plugin";
		try {
			File[] files = new File(pluginPath).listFiles();
			if(files!=null&&files.length>0){
				for(int i = 0; i < files.length; i++){
					if (files[i].isDirectory()) {

						in = new FileInputStream(files[i].getPath()+ File.separator +"config/config.properties");
						Properties prop = new Properties();
						prop.load(in);
				    	pluginStatus = prop.getProperty("PLUGIN_STATUS");
				    	pluginName = prop.getProperty("PLUGIN_NAME");
						in.close();
						in = null;
						log.debug("=====����====="+pluginName+"���struts-config.xml��ʼ======");
						if(!"Y".equals(pluginStatus)){
							log.debug(pluginName+"���δ��������struts-config.xml����======");
							continue;
						}
						digester.push(config);
						String configPath = files[i].getAbsolutePath()+ File.separator + 
								"config"+ File.separator +"struts-config.xml";
						if (new File(configPath).exists()) {
							parseModuleConfigFile(digester, 
									getServletContext().getResource("/WEB-INF/plugin/"+files[i].getName()+"/config/struts-config.xml"));
						}
						log.debug("=====����====="+pluginName+"���struts-config.xml����======");
					}
				}
			}
		} catch (Exception e) {
			throw new UnavailableException(e.getMessage());
		}
		getServletContext().setAttribute(Globals.MODULE_KEY + config.getPrefix(),config);
		return config;
	}
}
