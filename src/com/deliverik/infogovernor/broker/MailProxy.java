package com.deliverik.infogovernor.broker;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.platform.WebApplicationSupport;
import com.deliverik.framework.utility.CodeListUtils;
import com.deliverik.infogovernor.adapter.CodeDefinition;
import com.deliverik.infogovernor.scheduling.jobs.JobManager;
import com.deliverik.infogovernor.scheduling.jobs.MailJob;

public class MailProxy {

	private static Log log = LogFactory.getLog(MailProxy.class);
	private static MailProxy inst = null;

	public static MailProxy getInstance() {
		if (null == inst) {
			inst = new MailProxy();
		}
		return inst;
	}

	private MailProxy() {}

	/**
	 * 检查是否开启Mail发送功能
	 * 
	 * @return
	 */
	private boolean isStartMail() {
		CodeListUtils ctlBL = (CodeListUtils) WebApplicationSupport.getBean("codeListUtils");
		String isSendMail = ctlBL.getCodeValue(CodeDefinition.MAIL, "", "", CodeDefinition.MAIL_IS_SEND);
		if ("1".equals(isSendMail)) {
			return true;
		} else {
			log.debug("邮件发送功能关闭");
			return false;// 邮件发送功能已关闭
		}
	}

	/**
	 * 发送邮件
	 * 
	 * @return
	 */
	public void sendMail(String title, String content, String[] receiverArr, String[]... ccAndBcc) {
		try {
			if (isStartMail()) {
				String time = String.valueOf(System.currentTimeMillis());
				Map<String, Object> argsMap = new HashMap<String, Object>();
				argsMap.put("title", title);
				argsMap.put("content", content);
				argsMap.put("receiverArr", receiverArr);
				if (ccAndBcc != null && ccAndBcc.length == 1) {
					argsMap.put("ccArr", ccAndBcc[0]);
				} else if (ccAndBcc != null && ccAndBcc.length > 1) {
					argsMap.put("ccArr", ccAndBcc[0]);
					argsMap.put("bccArr", ccAndBcc[1]);
				} 
				JobManager.addMailJob(time, MailJob.GROUP_NAME, time, new MailJob(), argsMap);
			}
		} catch (Exception e) {
			log.error("-----sendMial Exception-----");
			log.error(e.getMessage());
		}
	}

}