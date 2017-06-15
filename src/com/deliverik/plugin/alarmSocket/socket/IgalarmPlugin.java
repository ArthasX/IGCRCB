/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.plugin.alarmSocket.socket;

import javax.servlet.ServletException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionServlet;
import org.apache.struts.action.PlugIn;
import org.apache.struts.config.ModuleConfig;

/***
 * 集成告警SOCKET plugin
 * @time 2014/06/23
 * @author taoye
 * @version 1.0
 * @mail taoye@deliverik.com
 */
public class IgalarmPlugin implements PlugIn{
	
	private static final Log log = LogFactory.getLog(IgalarmPlugin.class);

	private IgalarmThread igalarmThread;//集成告警socket线程
	
	/**
	 * 关闭集成告警SOCKET线程
	 */
	public void destroy() {
		if(null!=igalarmThread && !igalarmThread.isInterrupted())  
		{  
			igalarmThread.close();  
			igalarmThread.interrupt();  
			log.debug("集成告警SOCKET线程关闭");
		} 	
	}

	/**
	 * 启动集成告警SOCKET线程
	 */
	public void init(ActionServlet paramActionServlet,
			ModuleConfig paramModuleConfig) throws ServletException {
		if(null==igalarmThread)  
		{  
			//新建线程类  
			igalarmThread=new IgalarmThread(null);  
			//启动线程  
			igalarmThread.start();
		}  
	}	

}
