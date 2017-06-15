/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.dev.zwj.igflow.event.status;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

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
 * Description: 
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IGZWJ0102BLImpl implements WorkFlowEventHandlerBL{
	
	/** ��ѯ��API */
	protected FlowSearchBL flowSearchBL;
	
	/** ����API */
	protected FlowSetBL flowSetBL;
	
	/** ϵͳ��API */
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
	 * ϵͳ��API�趨
	 * @param sysManageBL ϵͳ��API
	 */
	public void setSysManageBL(SysManageBL sysManageBL) {
		this.sysManageBL = sysManageBL;
	}

	public void afterTreatmentExecute(WorkFlowStatusEventBeanInfo bean)
			throws BLException {
		
	}

	public void preTreatmentExecute(WorkFlowStatusEventBeanInfo bean)
			throws BLException {
		//��ѯ����ڵ������
		List<ParticipantInfo> list = flowSearchBL.searchStatusParticipant(bean.getLogInfo().getPrid(), "����");
		//ɾ����ʵ�ڵ㴦����
		StatusParticipant p = new StatusParticipant(bean.getLogInfo());
		p.setStatusname("��ʵ");
		flowSetBL.deleteStatusParticipant(p);
		Set<String> set = new HashSet<String>();
		for(ParticipantInfo pp:list){
			set.add(pp.getRolename());
		}
		for(Iterator<String> iter = set.iterator();iter.hasNext();){
			String rolename = iter.next();
			Integer roleid = 0;
			if("ϵͳ��".equals(rolename)){
				roleid = 1019;
			}
			if("������".equals(rolename)){
				roleid = 1020;
			}
			if("�豸��".equals(rolename)){
				roleid = 1021;
			}
			List<UserInfo> userList = sysManageBL.searchUserInfo(roleid, null);
			for(UserInfo user : userList){
				p.setRoleid(roleid);
				p.setUserid(user.getUserid());
				flowSetBL.setStatusParticipant(p);
			}
		}
	}

}
