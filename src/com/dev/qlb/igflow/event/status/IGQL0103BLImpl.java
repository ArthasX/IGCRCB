/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.dev.qlb.igflow.event.status;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.igflow.api.FlowSearchBL;
import com.deliverik.framework.igflow.api.FlowSetBL;
import com.deliverik.framework.igflow.parameter.StatusParticipant;
import com.deliverik.framework.igflow.resultset.ParticipantInfo;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowEventHandlerBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusEventBeanInfo;

/***
 * �����Ӻ����˺���
 * @time 2014/06/11
 * @author zhangqiang
 * @version 1.0
 * @mail zhangq@deliverik.com
 */
public class IGQL0103BLImpl extends BaseBLImpl implements WorkFlowEventHandlerBL {
	
	private static Log log = LogFactory.getLog(IGQL0103BLImpl.class);
	
	/** ��ѯ��API */
	protected FlowSearchBL flowSearchBL;
	
	/** ���¹���API�� */
	protected FlowSetBL flowSetBL;

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
		log.debug("=====================���һ����������ʼ=====================");
		//��ѯ�����˱�ֵ
		 List<ParticipantInfo> participants = flowSearchBL.searchPublicParticipantFormValue(bean.getLogInfo().getPrid(), "������");
		//��ѯ��ǰ״̬
		List<ParticipantInfo>  list = flowSearchBL.searchStatusParticipantByCode(bean.getLogInfo().getPrid(), bean.getAfstatus());
		Map<String, ParticipantInfo> map = new HashMap<String, ParticipantInfo>();
		for(ParticipantInfo info:list){
			if(StringUtils.isNotEmpty(info.getUserid())){
				map.put(info.getUserid(), info);
			}
		}
		if(participants != null){
			StatusParticipant participant = new StatusParticipant(bean.getLogInfo());
			participant.setStatuscode(bean.getAfstatus());
			for(ParticipantInfo info:participants){
				if(map.get(info.getUserid()) == null){
					participant.setRoleid(info.getRoleid());
					participant.setUserid(info.getUserid());
					flowSetBL.setStatusParticipant(participant);
				}
			}
		}
		log.debug("=====================���һ�������������=====================");
	}
}
