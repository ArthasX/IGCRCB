/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.plugin.change.socket;

import javax.servlet.ServletException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionServlet;
import org.apache.struts.action.PlugIn;
import org.apache.struts.config.ModuleConfig;

/***
 * 流程日志 SOCKET plugin
 * @time 2015/07/08
 * @author zhangqiang	
 * @version 1.0
 * @mail zhangqiang@deliverik.com
 */
public class ChangePlugin implements PlugIn{
	
	private static final Log log = LogFactory.getLog(ChangePlugin.class);

	private ChangeThread changeThread;//流程日志socket线程
	
	/**
	 * 关闭流程日志SOCKET线程
	 */
	public void destroy() {
		if(null!=changeThread && !changeThread.isInterrupted())  
		{  
			changeThread.close();  
			changeThread.interrupt();  
			log.debug("流程日志SOCKET线程关闭");
		} 	
	}

	/**
	 * 启动流程日志SOCKET线程
	 */
	public void init(ActionServlet paramActionServlet,
			ModuleConfig paramModuleConfig) throws ServletException {
		if(null==changeThread)  
		{  
			//新建线程类  
			changeThread=new ChangeThread(null);  
			//启动线程  
			changeThread.start();
			System.out.println("事件变更线程启动成功");
		}  
	}	

}
