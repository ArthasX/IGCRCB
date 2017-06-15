package com.deliverik.plugin.mail.job;

import javax.servlet.ServletException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionServlet;
import org.apache.struts.action.PlugIn;
import org.apache.struts.config.ModuleConfig;

import com.deliverik.framework.platform.WebApplicationSupport;
import com.deliverik.framework.utility.CodeListUtils;
import com.deliverik.plugin.mail.MAILThread;

public class MAILInit implements PlugIn {
	
	private static Log log = LogFactory.getLog(MAILInit.class);

	/** �ʼ��߳� */
	private static Thread mailThread = null;//����ģʽ��mailOpen������ȡInstance��start�����˳�run����������

	public void destroy() {}

	public void init(ActionServlet servlet, ModuleConfig config) throws ServletException {
		CodeListUtils codeListUtils=(CodeListUtils) WebApplicationSupport.getBean("codeListUtils");
		String serviceFlg = codeListUtils.getCodeValue("170", null, null, "3");//�Ƿ���
		if("1".equals(serviceFlg)){
			mailThread = new Thread(MAILThread.getInstance());
			MAILThread.setMailOpen(true);
			if(!mailThread.isAlive()){//�̲߳��ǻ״̬ʱ���������ظ������߳�
				mailThread.start();
				log.info("�������ʼ������߳�");
			}
		}
	}
	
}
