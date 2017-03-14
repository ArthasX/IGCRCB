/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.dev.crc.igflow.event.status;

import java.util.List;

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
 * ������� - UAT������Է��ɽڵ㴦���˳�ʼ��
 * @time 2014/08/26
 * @author wanglei
 * @version 1.0
 * @mail wanglei@deliverik.com
 */
public class IGCRC0405BLImpl extends BaseBLImpl implements WorkFlowEventHandlerBL{
	
	/**��־����ȡ��*/
	static Log log = LogFactory.getLog(IGCRC0401BLImpl.class);
	
	/** ���¹���API�� */
	private FlowSetBL flowSetBL;
    
    /** ���̲�ѯ����API�� */
    private FlowSearchBL flowSearchBL;
    
	/**
	 * ע����¹���API��
	 * 
	 * @param flowSetBL
	 */
	public void setFlowSetBL(FlowSetBL flowSetBL) {
		this.flowSetBL = flowSetBL;
	}

    /**
     * @param ���̲�ѯ����API�� the flowSearchBL to set
     */
    public void setFlowSearchBL(FlowSearchBL flowSearchBL) {
        this.flowSearchBL = flowSearchBL;
    }
    
	/**
     * ����
     */
	public void afterTreatmentExecute(WorkFlowStatusEventBeanInfo bean) throws BLException {
	}
	
	/**
	 * ǰ������Ӳ�����
	 */
	public void preTreatmentExecute(WorkFlowStatusEventBeanInfo bean) throws BLException {
		
	    log.debug("========�������UAT������Է���ǰ����ʼ========");
	    //���ȫ�������ߴ������ʱ��
        flowSetBL.setStatusParticipantAllRehandle(bean.getLogInfo().getPrid(), bean.getAfstatus());
	    //��ȡ���̲�������Ϣ
	    List<ParticipantInfo> participantInfos =  flowSearchBL.searchStatusParticipant(bean.getLogInfo().getPrid(), "�������");
	    for (ParticipantInfo participantInfo : participantInfos) {
	    	//�趨״̬������
	    	StatusParticipant statusParticipant = new StatusParticipant(bean.getLogInfo());
	    	statusParticipant.setStatusname("UAT������Է���");
	    	statusParticipant.setUserid(participantInfo.getUserid());
	    	statusParticipant.setRoleid(participantInfo.getRoleid());
	    	//��Ӳ����ɫ�Ͳ�����
	    	flowSetBL.setStatusParticipant(statusParticipant);
		}
	    
		log.debug("========�������UAT������Է���ǰ�������========");
	}
}

