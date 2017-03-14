/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.dev.crc.igflow.event.status.bl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.bl.SendMailBL;
import com.deliverik.framework.bl.SendMessageBL;
import com.deliverik.framework.igflow.api.SysManageBL;
import com.deliverik.framework.igflow.resultset.UserInfo;
	
/***
	 * ���չ�����Ϣ���ѣ����͸�ͬ��ɫ�µ������ˡ� 
	 * 	 (1)��������
	 *   (2)�ʼ����� 
	 * @time 2014/06/11
	 * @author zq
	 * @email zhangq@deliverik.com
	 * @version 1.0
	 */
public class IGFXKDataSendBLImpl implements IGFXKDataSendBL {

	/**������־*/
	private static Log log = LogFactory.getLog(IGFXKDataSendBLImpl.class);
	/** ����BL */
	protected SendMessageBL sendMessageBL;

	/** �ʼ�BL */
	protected SendMailBL sendMailBL;

	/** ��ѯBL */
	protected SysManageBL sysManageBL;

	/** ���չ���ڵĽ�ɫID*/
	protected static final Integer ROLE_ID = 1224;

	/***
	 * ����BL�趨
	 * 
	 * @param sendMessageBL
	 */
	public void setSendMessageBL(SendMessageBL sendMessageBL) {
		this.sendMessageBL = sendMessageBL;
	}

	/**
	 * �ʼ�BL �趨
	 * 
	 * @param sendMailBL
	 */
	public void setSendMailBL(SendMailBL sendMailBL) {
		this.sendMailBL = sendMailBL;
	}

	/***
	 * ����BL �趨
	 * 
	 * @param sysManageBL
	 */
	public void setSysManageBL(SysManageBL sysManageBL) {
		this.sysManageBL = sysManageBL;
	}
	
	/**
	 * ���չ���������
	 * @param bTime �ƻ���ʼʱ��
	 * @param eTime �ƻ�����ʱ��
	 * @param title �ƻ�����
	 */
	public void dataSend(Object bTime, Object eTime, Object title)
			throws BLException {
		log.debug("============================���չ��������ѿ�ʼ=========================");
		
		// ���ݽ�ɫID ��ѯ ��Ա��Ϣ
		List<UserInfo> userlist = this.sysManageBL.searchUserInfo(ROLE_ID, null);
	
		// �������͵�����
		StringBuffer messageContent = new StringBuffer();
		messageContent.append("�ƻ�ʱ����");
		messageContent.append(bTime);
		messageContent.append(" - ");
		messageContent.append(eTime);
		messageContent.append("�ķ��ռƻ�");
		messageContent.append(title);
		messageContent.append("��Ҫ��ִ�м�顣");

		// ���������ʼ��ı���
		StringBuffer mailTitle = new StringBuffer();
		mailTitle.append("����");
		mailTitle.append(title);
		mailTitle.append("�ķ��ռƻ�֪ͨ��");
		//����յ������ַ����	
		String address[]; 
		for (UserInfo info : userlist) {
			// ����û��������
			if(StringUtils.isNotEmpty(info.getUseremail())){
				//��ʼ������Ϊ1��String��������
				address=new String[1];
				//��ȡ�û������ַ���뵽����
				address[0]=info.getUseremail();
				// �����ʼ�����
				this.sendMailBL	.sendMail((String) mailTitle.toString(), messageContent.toString(), address);

			}
			// ���Ͷ�������
			this.sendMessageBL.sendSmsToUser(info.getUserid(),messageContent.toString());

		}
		log.debug("============================���չ��������ѽ���=========================");
	}
}
