package com.dev.crc.igflow.event.status;

import org.apache.commons.lang.SerializationUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.igflow.api.FlowSearchBL;
import com.deliverik.framework.igflow.parameter.StatusParticipant;
import com.deliverik.framework.workflow.WorkFlowOperationBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowEventHandlerBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusEventBeanInfo;
import com.deliverik.infogovernor.ven.bl.task.MonitoringWorkBL;
import com.deliverik.infogovernor.ven.model.MonitoringWorkInfo;
import com.deliverik.infogovernor.ven.model.entity.MonitoringWorkTB;

/**
 * 
 * ���ܣ�ָ�ɼ�鹤�������ü�鹤����������Ϊ���ύ
 * @author ʷ����   2014-9-9
 */
public class IGVEN0106BLImpl extends BaseBLImpl implements
		WorkFlowEventHandlerBL {

	/** ��־����ȡ�� */
	static Log log = LogFactory.getLog(IGVEN0106BLImpl.class);

	/** ��ѯ�๦��API�� */
	private FlowSearchBL flowSearchBL;
	
	/** ���̴���BL */
    protected WorkFlowOperationBL workFlowOperationBL;

	/** ���ռ����ϢBL */
	protected MonitoringWorkBL monitoringWorkBL;
    
	/** ִ�й��� */
	private String STATUSNAME_ZXGZ = "ִ�й���";

	/**
	 * @param ��ѯ�๦��API��
	 *            the flowSearchBL to set
	 */
	public void setFlowSearchBL(FlowSearchBL flowSearchBL) {
		this.flowSearchBL = flowSearchBL;
	}
	
	

	/**
	 * @param workFlowOperationBL the workFlowOperationBL to set
	 */
	public void setWorkFlowOperationBL(WorkFlowOperationBL workFlowOperationBL) {
		this.workFlowOperationBL = workFlowOperationBL;
	}

	/**
	 * ���ռ����ϢBL�趨
	 * @param monitoringWorkBL the ���ռ����ϢBL
	 */
	public void setMonitoringWorkBL(MonitoringWorkBL monitoringWorkBL) {
		this.monitoringWorkBL = monitoringWorkBL;
	}

	/** ���� */
	public void afterTreatmentExecute(WorkFlowStatusEventBeanInfo bean)
			throws BLException {
	}

	/** ǰ���� */
	public void preTreatmentExecute(WorkFlowStatusEventBeanInfo bean)
			throws BLException {
		 log.debug("========ָ�ɹ������̲�������ǰ�������ò����ߴ���ʼ========");

		    //��־������Ϣ�趨
	        StatusParticipant participant = new StatusParticipant(bean.getLogInfo());
	        
	        //��װ����״̬����
	        participant.setStatusname(STATUSNAME_ZXGZ);
	        
	        setNextPoint(bean);
	        
	        	        
			log.debug("========ָ�ɹ������̲�������ǰ�������ò����ߴ������========");
	}
	
	/**
	 * ������һ���ڵ�
	 * @param bean
	 */
	private void setNextPoint(WorkFlowStatusEventBeanInfo bean) throws BLException{
		// TODO Auto-generated method stub

		String rcrid = flowSearchBL.searchPublicProcessInfo(bean.getLogInfo().getPrid(), "��Ա");
        if(StringUtils.isNotEmpty(rcrid)){
        	MonitoringWorkInfo rcrBean = monitoringWorkBL.searchMonitoringWorkByPK(Integer.parseInt(rcrid));
        	if(rcrBean!=null){
        		MonitoringWorkTB rcrTB = (MonitoringWorkTB)SerializationUtils.clone(rcrBean);
        		rcrTB.setResult("���ύ");
        		monitoringWorkBL.updateMonitoringWork(rcrTB);
        	}			
        }
	}
}