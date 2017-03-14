package com.deliverik.framework.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;

public interface SendMessageBL extends BaseBL{
	/**
	 * ���û�������
	 * 
	 * @param userid
	 * @param sms
	 * @exception BLException
	 */
	public void sendSmsToUser(String userid, String sms);

	/**
	 * ����ɫֵ���ֻ�������
	 * 
	 * @param roleid
	 * @param sms
	 * @exception BLException
	 */
	public void sendSmsToRole(Integer roleid, String sms);
}
