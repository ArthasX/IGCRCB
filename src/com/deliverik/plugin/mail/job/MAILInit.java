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

	/** 邮件线程 */
	private static Thread mailThread = null;//单例模式由mailOpen决定获取Instance并start还是退出run方法并销毁

	public void destroy() {}

	public void init(ActionServlet servlet, ModuleConfig config) throws ServletException {
		CodeListUtils codeListUtils=(CodeListUtils) WebApplicationSupport.getBean("codeListUtils");
		String serviceFlg = codeListUtils.getCodeValue("170", null, null, "3");//是否开启
		if("1".equals(serviceFlg)){
			mailThread = new Thread(MAILThread.getInstance());
			MAILThread.setMailOpen(true);
			if(!mailThread.isAlive()){//线程不是活动状态时启动避免重复启动线程
				mailThread.start();
				log.info("已启动邮件发送线程");
			}
		}
	}
	
}
