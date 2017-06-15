/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.dev.ext.igflow.bds.event.status;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.igflow.api.FlowSearchBL;
import com.deliverik.framework.igflow.api.FlowSetBL;
import com.deliverik.framework.igflow.api.SysManageBL;
import com.deliverik.framework.igflow.parameter.StatusParticipant;
import com.deliverik.framework.igflow.resultset.ParticipantInfo;
import com.deliverik.framework.igflow.resultset.UserInfo;
import com.deliverik.framework.user.bl.task.OrganizationBL;
import com.deliverik.framework.user.model.Organization;
import com.deliverik.framework.user.model.condition.OrganizationSearchCondImpl;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowEventHandlerBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusEventBeanInfo;
import com.deliverik.framework.workflow.prr.bl.task.IG500BL;
import com.deliverik.framework.workflow.prr.model.IG500Info;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �о���άԤ�ô�����
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IGBDS0215BLImpl implements WorkFlowEventHandlerBL{
	
	/** ��ѯ��api */
	protected FlowSearchBL flowSearchBL;
	
	/** ������api */
	protected FlowSetBL flowSetBL;
	
	/** ϵͳ��api */
	protected SysManageBL sysManageBL;
	
	/** ��BL */
	protected IG500BL ig500BL;
	
	/** ����BL */
	protected OrganizationBL organizationBL;
	
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
	 * ��BL�趨
	 * @param ig500BL ��BL
	 */
	public void setIg500BL(IG500BL ig500bl) {
		ig500BL = ig500bl;
	}
	
	/**
	 * ����BL�趨
	 * @param organizationBL ����BL
	 */
	public void setOrganizationBL(OrganizationBL organizationBL) {
		this.organizationBL = organizationBL;
	}

	public void preTreatmentExecute(WorkFlowStatusEventBeanInfo bean)
			throws BLException {
		IG500Info info = ig500BL.searchIG500InfoByKey(bean.getLogInfo().getPrid());
		String orgid = info.getProrgid().length() > 7 ? info.getProrgid().substring(0,7) : info.getProrgid();
		if(info.getPrpdid().startsWith("01220")){
			orgid = "0002001";
		}else{
			if(info.getProrgid().startsWith("0002001")){
				Integer parPrid = flowSearchBL.searchProcessRelationForPar(bean.getLogInfo().getPrid());
				String orgname = flowSearchBL.searchPublicProcessInfo(parPrid, "�·�����");
				OrganizationSearchCondImpl cond = new OrganizationSearchCondImpl();
				cond.setOrgname(orgname);
				List<Organization> list = organizationBL.searchOrganization(cond);
				if(list != null && list.size() > 0){
					orgid = list.get(0).getOrgsyscoding();
				}
			}
		}
		List<ParticipantInfo> participants = flowSearchBL.searchStatusParticipantByCode(bean.getLogInfo().getPrid(), bean.getAfstatus());
		if(participants != null){
			StatusParticipant del = new StatusParticipant(bean.getLogInfo());
			del.setStatuscode(bean.getAfstatus());
			flowSetBL.deleteStatusParticipant(del);
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
		}
	}

	public void afterTreatmentExecute(WorkFlowStatusEventBeanInfo bean)
			throws BLException {
		
	}

}
