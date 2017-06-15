/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.dev.ext.igflow.bds.event.status;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;

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
 * Description: ��ʵ���������˻�������
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IGBDS0204BLImpl implements WorkFlowEventHandlerBL{
	
	/** ��ѯ��api */
	protected FlowSearchBL flowSearchBL;
	
	/** ������api */
	protected FlowSetBL flowSetBL;
	
	/** ϵͳ��api */
	protected SysManageBL sysManageBL;

	/**
	 * ��ѯ��api�趨
	 * @param flowSearchBL ��ѯ��api
	 */
	public void setFlowSearchBL(FlowSearchBL flowSearchBL) {
		this.flowSearchBL = flowSearchBL;
	}

	/**
	 * ������api�趨
	 * @param flowSetBL ������api
	 */
	public void setFlowSetBL(FlowSetBL flowSetBL) {
		this.flowSetBL = flowSetBL;
	}
	
	/**
	 * ϵͳ��api�趨
	 * @param sysManageBL ϵͳ��api
	 */
	public void setSysManageBL(SysManageBL sysManageBL) {
		this.sysManageBL = sysManageBL;
	}

	/**
	 * ǰ����
	 */
	public void preTreatmentExecute(WorkFlowStatusEventBeanInfo bean)
			throws BLException {
		UserInfo userInfo = sysManageBL.searchUserInfo(bean.getLogInfo().getExecutorid());
		String orgid = userInfo.getOrgid().length() > 7 ?  userInfo.getOrgid().substring(0,7) : userInfo.getOrgid();
		List<ParticipantInfo> participants = flowSearchBL.searchStatusParticipantByCode(bean.getLogInfo().getPrid(), bean.getAfstatus());
		
		//��һ��ָ������ɫ�µ���
		Boolean isFirstHandled = true;
		ParticipantInfo participantInfo = null;
		
		if(CollectionUtils.isNotEmpty(participants)){
			for(ParticipantInfo pp : participants){
				if(StringUtils.isNotEmpty(pp.getPpproctime())){
					isFirstHandled = false;
					participantInfo = pp;
				}
			}
		}
		
		if(participants != null){
			StatusParticipant del = new StatusParticipant(bean.getLogInfo());
			del.setStatuscode(bean.getAfstatus());
			flowSetBL.deleteStatusParticipant(del);
			
			if(isFirstHandled){
				
				for(ParticipantInfo pp : participants){
					
					List<UserInfo> users = sysManageBL.searchUserInfo(pp.getRoleid(), orgid);
					if(users != null){
						for(UserInfo user:users){
							StatusParticipant participant = new StatusParticipant(bean.getLogInfo());
							participant.setRoleid(pp.getRoleid());
							participant.setUserid(user.getUserid());
							participant.setStatuscode(bean.getAfstatus());
							flowSetBL.setStatusParticipant(participant);
						}
					}
				}
			}else{
			//����ϴδ��������Ϊ������
				if(participantInfo != null){
					
					StatusParticipant participant = new StatusParticipant(bean.getLogInfo());
					participant.setRoleid(participantInfo.getRoleid());
					participant.setUserid(participantInfo.getUserid());
					participant.setStatuscode(bean.getAfstatus());
					flowSetBL.setStatusParticipant(participant);
				}
				
			}
			
			
		}
	}

	/**
	 * ����
	 */
	public void afterTreatmentExecute(WorkFlowStatusEventBeanInfo bean)
			throws BLException {
		
	}

}
