package com.deliverik.infogovernor.bl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.bl.SendMailBL;
import com.deliverik.infogovernor.broker.MailProxy;

public class SendMailBLImpl extends BaseBLImpl implements SendMailBL {

	private static Log log = LogFactory.getLog(SendMailBLImpl.class);

	public void sendMail(String title, String content, String[] receiverArr, String[]... ccAndBcc) {

		log.debug("=================邮件发送开始=================");
		if (ccAndBcc != null && ccAndBcc.length == 1) {
			MailProxy.getInstance().sendMail(title, content, receiverArr, ccAndBcc[0]);
		} else if (ccAndBcc != null && ccAndBcc.length > 1) {
			MailProxy.getInstance().sendMail(title, content, receiverArr, ccAndBcc[0], ccAndBcc[1]);
		} else {
			MailProxy.getInstance().sendMail(title, content, receiverArr);
		}
		log.debug("=================邮件发送结束=================");
	}

}
