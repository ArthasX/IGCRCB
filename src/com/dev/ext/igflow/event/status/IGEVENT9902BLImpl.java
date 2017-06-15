/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.dev.ext.igflow.event.status;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.igflow.api.FlowSetBL;
import com.deliverik.framework.igflow.parameter.StatusParticipant;
import com.deliverik.framework.workflow.WorkFlowOperationBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowEventHandlerBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusEventBeanInfo;
import com.deliverik.framework.workflow.prr.model.IG500Info;

/**
 * ������� - ���ȴ���ˣ��ڵ�ǰ������Ӳ������߼��������������Ϊ�����ˣ�
 * @author Administrator
 *
 */
public class IGEVENT9902BLImpl extends BaseBLImpl implements WorkFlowEventHandlerBL{
	
	/**��־����ȡ��*/
	static Log log = LogFactory.getLog(IGEVENT9902BLImpl.class);
	
	/** ���¹���API�� */
	private FlowSetBL flowSetBL;

    /** ���̴���BL */
    private WorkFlowOperationBL workFlowOperationBL;
	
	/**
	 * ע����¹���API��
	 * 
	 * @param flowSetBL
	 */
	public void setFlowSetBL(FlowSetBL flowSetBL) {
		this.flowSetBL = flowSetBL;
	}
	
	/**
     * ���̴���BL�趨
     *
     * @param workFlowOperationBL ���̴���BL
     */
    public void setWorkFlowOperationBL(WorkFlowOperationBL workFlowOperationBL) {
        this.workFlowOperationBL = workFlowOperationBL;
    }
    
	public void afterTreatmentExecute(WorkFlowStatusEventBeanInfo bean)
			throws BLException {
		
	}
	
	/**
	 * ǰ������Ӳ�����
	 */
	public void preTreatmentExecute(WorkFlowStatusEventBeanInfo bean) throws BLException {
		
	    log.debug("========����������̵ȴ����ǰ�������ò����ߴ���ʼ========");

        //��ô�����Ĳ����ߵĲ��Ż�����
        IG500Info prInfo = workFlowOperationBL.searchProcessRecordByKey(bean.getLogInfo().getPrid());
        
        //��־������Ϣ�趨
        StatusParticipant spInfo = new StatusParticipant(bean.getLogInfo());
        
        //��װ����״̬����
        spInfo.setStatusname("�ȴ����");
        
        //ɾ��ԾǨ�ڵ��ԭ�в�����
        flowSetBL.deleteStatusParticipant(spInfo);
        
        //��־������Ϣ�趨
        StatusParticipant participants = new StatusParticipant(bean.getLogInfo());
        
        //��װ���̴�����id
        participants.setUserid(prInfo.getPruserid());
        
        //��װ���̴����ɫid
        participants.setRoleid(prInfo.getPrroleid());
        
        //��װ����״̬����
        participants.setStatusname("�ȴ����");
        
        //�����ɫ�Ͳ��������
        flowSetBL.setStatusParticipant(participants);
        
		log.debug("========����������̵ȴ����ǰ�������ò����ߴ������========");
	}

}

