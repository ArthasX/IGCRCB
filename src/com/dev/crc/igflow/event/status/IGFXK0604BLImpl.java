/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.dev.crc.igflow.event.status;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.igflow.api.FlowSearchBL;
import com.deliverik.framework.igflow.api.FlowSetBL;
import com.deliverik.framework.igflow.api.SysManageBL;
import com.deliverik.framework.igflow.parameter.StatusParticipant;
import com.deliverik.framework.igflow.resultset.ParticipantInfo;
import com.deliverik.framework.igflow.resultset.UserInfo;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowEventHandlerBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusEventBeanInfo;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ��ѯ��ɫ�µ������˲����óɲ�����
 * </p>
 * 
 * @author wanglei@deliverik.com
 * @version 1.0
 */
public class IGFXK0604BLImpl implements WorkFlowEventHandlerBL{
	
	/** ��־���� */
	private static final Log log = LogFactory.getLog(IGFXK0604BLImpl.class);
	
	/** ��ѯ��API */
	protected FlowSearchBL flowSearchBL;
	
	/** ������API */
	protected FlowSetBL flowSetBL;
	
	/** ϵͳ��BL */
	protected SysManageBL sysManageBL;

	/**
	 * ��ѯ��API�趨
	 * @param flowSearchBL ��ѯ��API
	 */
	public void setFlowSearchBL(FlowSearchBL flowSearchBL) {
		this.flowSearchBL = flowSearchBL;
	}

	/**
	 * ������API�趨
	 * @param flowSetBL ������API
	 */
	public void setFlowSetBL(FlowSetBL flowSetBL) {
		this.flowSetBL = flowSetBL;
	}

	/**
	 * ϵͳ��BL�趨
	 * @param sysManageBL ϵͳ��BL
	 */
	public void setSysManageBL(SysManageBL sysManageBL) {
		this.sysManageBL = sysManageBL;
	}

	/**
	 * ǰ����
	 */
	public void preTreatmentExecute(WorkFlowStatusEventBeanInfo bean)
			throws BLException {
		log.debug("=================����ִ���˿�ʼ=================");
		//��ѯ�����˶���
		List<ParticipantInfo> list = flowSearchBL.searchStatusParticipantByCode(bean.getLogInfo().getPrid(), bean.getAfstatus());
		//��ɫ��Ϣ����
		Set<Integer> set = new LinkedHashSet<Integer>();
		for(ParticipantInfo info:list){
			set.add(info.getRoleid());
		}
		//ʵ������������Ϣ
		StatusParticipant participant = new StatusParticipant(bean.getLogInfo());
		participant.setStatuscode(bean.getAfstatus());
		//ɾ�������˶���
		flowSetBL.deleteStatusParticipant(participant);
		//��ѯ��ɫ�û�
		for(Iterator<Integer> iter = set.iterator();iter.hasNext();){
			Integer roleid = iter.next();
			//��ѯ��ɫ�û�
			List<UserInfo> userList = sysManageBL.searchUserInfo(roleid, null);
			//���������û�
			for(UserInfo user:userList){
				participant.setRoleid(roleid);
				participant.setUserid(user.getUserid());
				flowSetBL.setStatusParticipant(participant);
			}
		}
		log.debug("=================����ִ���˽���=================");
	}

	/**
	 * ����
	 */
	public void afterTreatmentExecute(WorkFlowStatusEventBeanInfo bean)
			throws BLException {
		
	}

}
