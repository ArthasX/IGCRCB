package com.deliverik.framework.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;

public interface SendMessageBL extends BaseBL{
	/**
	 * 给用户发短信
	 * 
	 * @param userid
	 * @param sms
	 * @exception BLException
	 */
	public void sendSmsToUser(String userid, String sms);

	/**
	 * 给角色值班手机发短信
	 * 
	 * @param roleid
	 * @param sms
	 * @exception BLException
	 */
	public void sendSmsToRole(Integer roleid, String sms);
}
