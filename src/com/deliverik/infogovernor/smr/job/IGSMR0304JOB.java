/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.smr.job;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.bl.SendMessageBL;
import com.deliverik.framework.platform.WebApplicationSupport;
import com.deliverik.framework.user.bl.task.UserRoleBL;
import com.deliverik.framework.user.model.UserRoleInfo;
import com.deliverik.framework.user.model.condition.UserRoleVWSearchCondImpl;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.infogovernor.smr.bl.IGSMRCONSTANT;
import com.deliverik.infogovernor.smr.bl.task.RemindInfoBL;
import com.deliverik.infogovernor.smr.model.entity.RemindInfoTB;

/**
 * ����:��ʱ���� 
 * ������������ʱ���� 
 * �����ˣ�����͢
 * ������¼�� 2013-08-06
 * �޸ļ�¼��
 */
public class IGSMR0304JOB implements Job {

    private static Log log = LogFactory.getLog(IGSMR0304JOB.class);
	
	
	private static SendMessageBL sendMessageBL = (SendMessageBL) WebApplicationSupport.getBean("sendMessageBL");
	
	private static UserRoleBL userRoleBL = (UserRoleBL) WebApplicationSupport.getBean("userRoleBL");
	
	private static RemindInfoBL remindInfoBL = (RemindInfoBL) WebApplicationSupport.getBean("remindInfoBL");
	
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		log.debug("========���붨ʱ������Ϣ����ʼ========");
        //�鿴������˽�ɫ�µ�������
		//ʵ������ѯ����
		UserRoleVWSearchCondImpl cond = new UserRoleVWSearchCondImpl();
		cond.setRoletype(IGSMRCONSTANT.ROLETYPE_REPORT);
		List<UserRoleInfo> listrole =  userRoleBL.searchUserRoleVW(cond);
		//����Щ�˷Ž�������Ϣ���У����Ҹ���Щ�˷�����
		for(UserRoleInfo info:listrole){
			//ʵ����������Ϣ��
			RemindInfoTB tb  = new RemindInfoTB();
			tb.setRiuseid(info.getUserid());
			tb.setRistatus(IGSMRJOBCONSTANTS.INFOMATION_NODATED);
			tb.setRitype(IGSMRJOBCONSTANTS.QUARTER3REPORT_TYPE);
			tb.setRiinfo("�뷢��������ȵļ����");
			//���뵽������Ϣ����
			try {
				remindInfoBL.registRemindInfo(tb);
			} catch (BLException e) {
				e.printStackTrace();
			}
			//���Ͷ�������
			sendMessageBL.sendSmsToUser(info.getUserid(), "�뷢��������ȵļ����");
		}
		
		
		log.debug("========���붨ʱ������Ϣ�������========");

	}

}
