/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.dev.qlb.igflow.event.status;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.igflow.api.FlowSearchBL;
import com.deliverik.framework.igflow.api.FlowSetBL;
import com.deliverik.framework.igflow.api.SysManageBL;
import com.deliverik.framework.igflow.parameter.StatusParticipant;
import com.deliverik.framework.igflow.resultset.ParticipantInfo;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowEventHandlerBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusEventBeanInfo;

/***
 * ָ�ɹ���ת��ִ����ǰ������ִ������ӵ�ִ������˽ڵ�
 * @time 2014/06/11
 * @author zhangqiang
 * @version 1.0
 * @mail zhangq@deliverik.com
 */
public class IGQL0104BLImpl extends BaseBLImpl implements WorkFlowEventHandlerBL {
	
	private static Log log = LogFactory.getLog(IGQL0104BLImpl.class);
	
	/** ��ѯ��API */
	private FlowSearchBL flowSearchBL;
	
	/** ���¹���API�� */
	private FlowSetBL flowSetBL;
	
	/** ϵͳ��BL */
	protected SysManageBL sysManageBL;
	
	/**
	 * @param ϵͳ��BL the sysManageBL to set
	 */
	public void setSysManageBL(SysManageBL sysManageBL) {
		this.sysManageBL = sysManageBL;
	}

	/**
	 * @param ���¹���API�� the flowSetBL to set
	 */
	public void setFlowSetBL(FlowSetBL flowSetBL) {
		this.flowSetBL = flowSetBL;
	}

	/**
	 * ��ѯ��API�趨
	 * @param flowSearchBL ��ѯ��API
	 */
	public void setFlowSearchBL(FlowSearchBL flowSearchBL) {
		this.flowSearchBL = flowSearchBL;
	}
	
	/**
	 * ����
	 */
	public void afterTreatmentExecute(WorkFlowStatusEventBeanInfo bean)
			throws BLException {
		
	}

	/**
	 * ǰ����
	 */
	public void preTreatmentExecute(WorkFlowStatusEventBeanInfo bean)throws BLException {
		log.debug("=====================��ִ������ӵ�ִ������˽ڵ㴦��ʼ=====================");
		//ɾ��ִ����˽ڵ�ԭ�������
		List<ParticipantInfo>  dellist = flowSearchBL.searchStatusParticipant(bean.getLogInfo().getPrid(), "ִ�����");
		if(null != dellist && dellist.size() >0){
			for(ParticipantInfo info:dellist){
				StatusParticipant participant = new StatusParticipant(bean.getLogInfo());
				participant.setStatusname("ִ�����");
				participant.setRoleid(info.getRoleid());
				participant.setUserid(info.getUserid());
				flowSetBL.deleteStatusParticipant(participant);
			}
		}
		
		//��ѯ��ǰ״̬
		List<ParticipantInfo>  list = flowSearchBL.searchStatusParticipant(bean.getLogInfo().getPrid(), "ִ��");
		StatusParticipant participant = new StatusParticipant(bean.getLogInfo());
		participant.setStatusname("ִ�����");
		for(ParticipantInfo info:list){
			participant.setRoleid(info.getRoleid());
			participant.setUserid(info.getUserid());
			flowSetBL.setStatusParticipant(participant);
		}
		
		log.debug("=====================��ִ������ӵ�ִ������˽ڵ㴦�����=====================");
	}
}
