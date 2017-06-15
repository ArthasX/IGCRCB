/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
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
 * ������־ SOCKET plugin
 * @time 2015/07/08
 * @author zhangqiang	
 * @version 1.0
 * @mail zhangqiang@deliverik.com
 */
public class ChangePlugin implements PlugIn{
	
	private static final Log log = LogFactory.getLog(ChangePlugin.class);

	private ChangeThread changeThread;//������־socket�߳�
	
	/**
	 * �ر�������־SOCKET�߳�
	 */
	public void destroy() {
		if(null!=changeThread && !changeThread.isInterrupted())  
		{  
			changeThread.close();  
			changeThread.interrupt();  
			log.debug("������־SOCKET�̹߳ر�");
		} 	
	}

	/**
	 * ����������־SOCKET�߳�
	 */
	public void init(ActionServlet paramActionServlet,
			ModuleConfig paramModuleConfig) throws ServletException {
		if(null==changeThread)  
		{  
			//�½��߳���  
			changeThread=new ChangeThread(null);  
			//�����߳�  
			changeThread.start();
			System.out.println("�¼�����߳������ɹ�");
		}  
	}	

}
