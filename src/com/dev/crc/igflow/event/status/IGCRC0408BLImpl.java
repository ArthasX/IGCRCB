package com.dev.crc.igflow.event.status;

import java.util.List;

import org.apache.commons.lang.SerializationUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.igflow.api.FlowSearchBL;
import com.deliverik.framework.igflow.api.FlowSetBL;
import com.deliverik.framework.igflow.parameter.PublicProcessInfoValue;
import com.deliverik.framework.igflow.parameter.StatusParticipant;
import com.deliverik.framework.igflow.parameter.WorkFlowLog;
import com.deliverik.framework.igflow.resultset.ParticipantInfo;
import com.deliverik.framework.workflow.WorkFlowOperationBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowEventHandlerBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusEventBeanInfo;
import com.deliverik.framework.workflow.prr.model.IG599Info;
import com.deliverik.framework.workflow.prr.model.condition.IG599SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.entity.IG599TB;
import com.deliverik.infogovernor.risk.bl.task.RiskCheckBL;
import com.deliverik.infogovernor.risk.bl.task.RiskCheckResultBL;
import com.deliverik.infogovernor.risk.model.RiskCheckResult;
import com.deliverik.infogovernor.risk.model.entity.RiskCheckResultTB;

/**
 * 
 * ���ܣ�ָ�ɼ�鹤��������ڵ����ѡ�������Ա���������ɽڵ㣬���ѡ�����ˣ�������ִ�нڵ�
 * @author ʷ����   2014-9-9
 */
public class IGCRC0408BLImpl extends BaseBLImpl implements
		WorkFlowEventHandlerBL {

	/** ��־����ȡ�� */
	static Log log = LogFactory.getLog(IGCRC0408BLImpl.class);

	/** ���¹���API�� */
	private FlowSetBL flowSetBL;

	/** ��ѯ�๦��API�� */
	private FlowSearchBL flowSearchBL;
	
	/** ���̴���BL */
    protected WorkFlowOperationBL workFlowOperationBL;

	/** ���ռ����ϢBL */
	protected RiskCheckResultBL riskCheckResultBL;
    
	/** ִ�й��� */
	private String STATUSNAME_ZXGZ = "ִ�й���";

	/**
	 * ע����¹���API��
	 * 
	 * @param flowSetBL
	 */
	public void setFlowSetBL(FlowSetBL flowSetBL) {
		this.flowSetBL = flowSetBL;
	}

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
	 * @param riskCheckResultBL the riskCheckResultBL to set
	 */
	public void setRiskCheckResultBL(RiskCheckResultBL riskCheckResultBL) {
		this.riskCheckResultBL = riskCheckResultBL;
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
	        
	        //ɾ��ԾǨ�ڵ��ԭ�в�����
//	        flowSetBL.deleteStatusParticipant(participant);
	        
	        // ������һ���ڵ�
//	        setParticipant(bean);
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
		
		//
		String rcrid = flowSearchBL.searchPublicProcessInfo(bean.getLogInfo().getPrid(), "��Ա");
		String people = flowSearchBL.searchPublicProcessInfo(bean.getLogInfo().getPrid(), "������");
        if(StringUtils.isNotEmpty(rcrid)){
        	rcrid = rcrid.split("#")[2];
        	RiskCheckResult rcrBean = riskCheckResultBL.searchRiskCheckResultByKey(Integer.parseInt(rcrid));
        	if(rcrBean!=null){
        		RiskCheckResultTB rcrTB = (RiskCheckResultTB)SerializationUtils.clone(rcrBean);
        		rcrTB.setAssignprid(bean.getLogInfo().getPrid());
        		rcrTB.setRcrusername(people);
        		riskCheckResultBL.updateRiskCheckResult(rcrTB);
        	}			
        }

		
	}
}