package com.deliverik.framework.bl;

import com.deliverik.framework.base.BaseBL;

public interface SendMailBL extends BaseBL {

	public void sendMail(String title, String content, String[] receiverArr, String[]... ccAndBcc);

}
