package com.deliverik.plugin.sms.job;

import javax.servlet.ServletException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionServlet;
import org.apache.struts.action.PlugIn;
import org.apache.struts.config.ModuleConfig;

import com.deliverik.framework.platform.WebApplicationSupport;
import com.deliverik.framework.utility.CodeListUtils;
import com.deliverik.plugin.sms.SMSThread;

public class SMSInit implements PlugIn {
	
	private static Log log = LogFactory.getLog(SMSInit.class);

	/** �����߳� */
	private static Thread smsThread = null;//����ģʽ��smsOpen������ȡInstance��start�����˳�run����������

	public void destroy() {}

	public void init(ActionServlet servlet, ModuleConfig config) throws ServletException {
		CodeListUtils codeListUtils=(CodeListUtils) WebApplicationSupport.getBean("codeListUtils");
		String serviceFlg = codeListUtils.getCodeValue("153", null, null, "6");
		if("1".equals(serviceFlg)){
			smsThread = new Thread(SMSThread.getInstance());
			SMSThread.setSmsOpen(true);
			if(!smsThread.isAlive()){//�̲߳��ǻ״̬ʱ���������ظ������߳�
				smsThread.start();
				log.info("���������ŷ����߳�");
			}
		}
	}
	
}
