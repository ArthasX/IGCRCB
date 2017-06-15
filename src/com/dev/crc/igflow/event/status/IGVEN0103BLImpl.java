package com.dev.crc.igflow.event.status;

import java.util.List;

import org.apache.commons.lang.SerializationUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.igflow.api.FlowSearchBL;
import com.deliverik.framework.igflow.parameter.StatusParticipant;
import com.deliverik.framework.igflow.resultset.ParticipantInfo;
import com.deliverik.framework.workflow.WorkFlowOperationBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowEventHandlerBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusEventBeanInfo;
import com.deliverik.framework.workflow.prr.model.IG599Info;
import com.deliverik.framework.workflow.prr.model.condition.IG599SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.entity.IG599TB;
import com.deliverik.infogovernor.ven.bl.task.MonitoringWorkBL;
import com.deliverik.infogovernor.ven.model.MonitoringWorkInfo;
import com.deliverik.infogovernor.ven.model.entity.MonitoringWorkTB;

/**
 * 
 * ���ܣ�����ָ�ɼ�鹤��������ڵ����ѡ�������Ա���������ɽڵ㣬���ѡ�����ˣ�������ִ�нڵ�
 * @author ʷ����   2014-9-9
 */
public class IGVEN0103BLImpl extends BaseBLImpl implements
		WorkFlowEventHandlerBL {

	/** ��־����ȡ�� */
	static Log log = LogFactory.getLog(IGVEN0103BLImpl.class);

	/** ��ѯ�๦��API�� */
	private FlowSearchBL flowSearchBL;
	
	/** ���̴���BL */
    protected WorkFlowOperationBL workFlowOperationBL;

    
	/** ִ�й��� */
	private String STATUSNAME_ZXGZ = "ִ�й���";

	/** ���ռ�⹤��BL*/
	private MonitoringWorkBL monitoringWorkBL;

	/**
	 * @param ��ѯ�๦��API��
	 *            the flowSearchBL to set
	 */
	public void setFlowSearchBL(FlowSearchBL flowSearchBL) {
		this.flowSearchBL = flowSearchBL;
	}
	
	/**
	 * ���ռ�⹤��BL�趨
	 * @param monitoringWorkBL the ���ռ�⹤��BL
	 */
	public void setMonitoringWorkBL(MonitoringWorkBL monitoringWorkBL) {
		this.monitoringWorkBL = monitoringWorkBL;
	}



	/**
	 * @param workFlowOperationBL the workFlowOperationBL to set
	 */
	public void setWorkFlowOperationBL(WorkFlowOperationBL workFlowOperationBL) {
		this.workFlowOperationBL = workFlowOperationBL;
	}


	/** ǰ���� */
	public void preTreatmentExecute(WorkFlowStatusEventBeanInfo bean)
			throws BLException {
	}

	/** ���� */
	public void afterTreatmentExecute(WorkFlowStatusEventBeanInfo bean)
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
		
		//��ѯ���ɽڵ㴦����		
		List<ParticipantInfo> ppList = flowSearchBL.searchStatusParticipant(bean.getLogInfo().getPrid(), "������");
		//��ѯִ�нڵ㴦����
		List<ParticipantInfo> ppList2 = flowSearchBL.searchStatusParticipant(bean.getLogInfo().getPrid(), "���ִ��");
		//���ɽڵ��д�����,�������ɱ�ʾ������Ϊ1
		if(ppList != null && ppList.size() > 0){
			
			IG599SearchCondImpl cond = new IG599SearchCondImpl();
			cond.setPrid(bean.getLogInfo().getPrid());//����ID
			cond.setPivarlabel("���ɱ�ʾ");//������
			List<IG599Info> lst_ProcessInfo = workFlowOperationBL.searchProcessInfoByCond(cond);
			if(lst_ProcessInfo.isEmpty()) {
				throw new BLException("IGFLOW0000.E001", "�������ɱ�ʾ��");
			} else if(lst_ProcessInfo.size() > 1) {
				throw new BLException("IGFLOW0000.E002", "�������ɱ�ʾ��");
			} else{
				IG599TB instance = (IG599TB)SerializationUtils.clone(lst_ProcessInfo.get(0));
				instance.setPivarvalue("1");
				workFlowOperationBL.updateProcessInfo(instance);
			}
		}
		
		//ִ�нڵ��д����ˣ��������ɱ�ʾ������Ϊ1
		else if(ppList2 != null && ppList2.size() > 0){
			IG599SearchCondImpl cond = new IG599SearchCondImpl();
			cond.setPrid(bean.getLogInfo().getPrid());//����ID
			cond.setPivarlabel("���ɱ�ʾ");//������
			List<IG599Info> lst_ProcessInfo = workFlowOperationBL.searchProcessInfoByCond(cond);
			if(lst_ProcessInfo.isEmpty()) {
				throw new BLException("IGFLOW0000.E001", "�������ɱ�ʾ��");
			} else if(lst_ProcessInfo.size() > 1) {
				throw new BLException("IGFLOW0000.E002", "�������ɱ�ʾ��");
			} else{
				IG599TB instance = (IG599TB)SerializationUtils.clone(lst_ProcessInfo.get(0));
				instance.setPivarvalue("2");
				workFlowOperationBL.updateProcessInfo(instance);
			}
		}
		
		//���ռ�⹤������id
		String rcrid = flowSearchBL.searchPublicProcessInfo(bean.getLogInfo().getPrid(), "��Ա");
        if(StringUtils.isNotEmpty(rcrid)){
        	MonitoringWorkInfo rcrBean = monitoringWorkBL.searchMonitoringWorkByPK(Integer.parseInt(rcrid));
        	if(rcrBean!=null){
        		MonitoringWorkTB rcrTB = (MonitoringWorkTB)SerializationUtils.clone(rcrBean);
        		rcrTB.setAssignprid(bean.getLogInfo().getPrid());
        		monitoringWorkBL.updateMonitoringWork(rcrTB);
        	}			
        }

		
	}
}