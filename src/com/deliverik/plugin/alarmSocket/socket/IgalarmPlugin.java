/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
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
 * ���ɸ澯SOCKET plugin
 * @time 2014/06/23
 * @author taoye
 * @version 1.0
 * @mail taoye@deliverik.com
 */
public class IgalarmPlugin implements PlugIn{
	
	private static final Log log = LogFactory.getLog(IgalarmPlugin.class);

	private IgalarmThread igalarmThread;//���ɸ澯socket�߳�
	
	/**
	 * �رռ��ɸ澯SOCKET�߳�
	 */
	public void destroy() {
		if(null!=igalarmThread && !igalarmThread.isInterrupted())  
		{  
			igalarmThread.close();  
			igalarmThread.interrupt();  
			log.debug("���ɸ澯SOCKET�̹߳ر�");
		} 	
	}

	/**
	 * �������ɸ澯SOCKET�߳�
	 */
	public void init(ActionServlet paramActionServlet,
			ModuleConfig paramModuleConfig) throws ServletException {
		if(null==igalarmThread)  
		{  
			//�½��߳���  
			igalarmThread=new IgalarmThread(null);  
			//�����߳�  
			igalarmThread.start();
		}  
	}	

}
