package com.deliverik.infogovernor.bl;


import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.bl.SendMessageBL;
import com.deliverik.framework.user.bl.task.RoleBL;
import com.deliverik.framework.user.bl.task.UserBL;
import com.deliverik.framework.user.model.Role;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.broker.CCProxy;

public class SendMessageBLImpl extends BaseBLImpl implements SendMessageBL{
	
	private static Log log = LogFactory.getLog(SendMessageBLImpl.class);
	
	private UserBL userBL;
	
	private RoleBL roleBL;
	
	private CCProxy ccProxy;
	
	public void setUserBL(UserBL userBL) {
		this.userBL = userBL;
	}

	public void setRoleBL(RoleBL roleBL) {
		this.roleBL = roleBL;
	}

	/**
	 * ���û�������
	 * 
	 * @param userid
	 * @param sms
	 * @exception BLException
	 */
	public void sendSmsToUser(String userid, String sms){
		User user;
		try {
			user = userBL.searchUserByKey(userid);
			ccProxy.sendSmsMessage(user.getUsermobile(), sms);
			//sendMailBL.sendMail("�ʼ�����", sms, new String[]{user.getUseremail()}, null);
		} catch (BLException e) {
			log.debug("===============�û��������쳣,�û�"+userid+"������Ϣ������===================");
		}
	}

	/**
	 * ����ɫֵ���ֻ�������
	 * 
	 * @param roleid
	 * @param sms
	 * @exception BLException
	 */
	public void sendSmsToRole(Integer roleid, String sms){
		Role role;
		try {
			role = roleBL.searchRoleByKey(roleid);
			if(StringUtils.isEmpty(role.getRoleinfo())) {
				log.debug("===============��ɫֵ���ֻ��������쳣����ɫ"+roleid+"�ֻ���Ϣ������===================");
			} else {
				if(role.getRoleinfo().split("###").length == 2) {
					ccProxy.sendSmsMessage(role.getRoleinfo().split("###")[1], sms);
					//sendMailBL.sendMail("�ʼ�����", sms, new String[]{role.getRoleinfo().split("###")[0]}, null);
				} else {
					log.debug("===============��ɫֵ���ֻ��������쳣����ɫ"+roleid+"�ֻ���Ϣ������===================");
				}
			}
		} catch (BLException e) {
			log.debug("===============��ɫֵ���ֻ��������쳣����ɫ"+roleid+"������Ϣ������===================");
		}
	}

	public void setCcProxy(CCProxy ccProxy) {
		this.ccProxy = ccProxy;
	}
}
