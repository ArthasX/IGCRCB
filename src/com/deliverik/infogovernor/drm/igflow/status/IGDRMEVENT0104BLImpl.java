/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.drm.igflow.status;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.igflow.api.FlowSearchBL;
import com.deliverik.framework.igflow.api.FlowSetBL;
import com.deliverik.framework.igflow.api.SysManageBL;
import com.deliverik.framework.igflow.parameter.StatusParticipant;
import com.deliverik.framework.igflow.resultset.ParticipantInfo;
import com.deliverik.framework.igflow.resultset.UserInfo;
import com.deliverik.framework.workflow.prd.bl.task.IG222BL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowEventHandlerBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusEventBeanInfo;
import com.deliverik.framework.workflow.prr.bl.task.IG337BL;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: δָ�����˵��������ѯ��ɫ�µ������˲����óɲ�����
 * 				   ָ�����˵������ָ����Ϊ������
 * </p>
 * 
 * @author ZYL
 * @version 1.0
 */
public class IGDRMEVENT0104BLImpl implements WorkFlowEventHandlerBL{
	
	/** ��־���� */
	private static final Log log = LogFactory.getLog(IGDRMEVENT0104BLImpl.class);
	
	/** ��ѯ��API */
	protected FlowSearchBL flowSearchBL;
	
	/** ������API */
	protected FlowSetBL flowSetBL;
	
	/** ϵͳ��BL */
	protected SysManageBL sysManageBL;
	
	/** ϵͳ��BL */
	protected IG337BL ig337BL;
	
	/** ���̲�����BL */
	protected IG222BL ig222BL;

	/**
	 * @param ig337bl the ϵͳ��BL to set
	 */
	public void setIg337BL(IG337BL ig337bl) {
		ig337BL = ig337bl;
	}

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
	 * @param ig222bl the ���̲�����BL to set
	 */
	public void setIg222BL(IG222BL ig222bl) {
		ig222BL = ig222bl;
	}

	/**
	 * ǰ����
	 */
	public void preTreatmentExecute(WorkFlowStatusEventBeanInfo bean)
			throws BLException {
		log.debug("=================����ִ���˿�ʼ=================");
		//ʵ��������������Ϣ
		StatusParticipant participant = new StatusParticipant(bean.getLogInfo());
		participant.setStatuscode(bean.getAfstatus());
		//��ѯ��ǰ������в�����
		List<ParticipantInfo> list = flowSearchBL.searchStatusParticipantByCode(bean.getLogInfo().getPrid(), bean.getAfstatus());
		if(list!=null){
		Set<Integer> set = new HashSet<Integer>();
		for(ParticipantInfo info:list){
			//������ָ������ɫ�Ĳ�������Ϣ���˴�������ɫ���뼯�ϣ���ɾ����ǰ��ɫ�Ĳ�������Ϣ
			if(StringUtils.isEmpty(info.getUserid())){
				set.add(info.getRoleid());
				participant.setRoleid(info.getRoleid());
				flowSetBL.deleteStatusParticipant(participant);
			}
		}
		//������ɫ���ϣ���ԭ��ֻ����ɫ�Ĳ�������Ϣ����������
		for(Iterator<Integer> iter = set.iterator();iter.hasNext();){
			Integer roleid = iter.next();
			//��ѯ��ɫ�µ������û� 
			List<UserInfo> userList = sysManageBL.searchUserInfo(roleid, null);
			participant.setRoleid(roleid);
			//�����û���Ӳ����� 
			for(UserInfo info:userList){
				participant.setUserid(info.getUserid());
				flowSetBL.setStatusParticipant(participant);;
			}
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
