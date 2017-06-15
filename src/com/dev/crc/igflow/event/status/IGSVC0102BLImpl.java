/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.dev.crc.igflow.event.status;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.igflow.api.FlowOptBL;
import com.deliverik.framework.igflow.api.FlowSearchBL;
import com.deliverik.framework.igflow.api.FlowSetBL;
import com.deliverik.framework.igflow.parameter.PublicProcessInfoValue;
import com.deliverik.framework.igflow.parameter.StatusParticipant;
import com.deliverik.framework.igflow.parameter.WorkFlowLog;
import com.deliverik.framework.igflow.resultset.ProcessRecordInfo;
import com.deliverik.framework.igflow.resultset.ProcessStatusInfo;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowEventHandlerBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusEventBeanInfo;
/**
 * �������� - ����������̷��� �趨�ȴ����� ��ֵ
 * @author zhangqiang
 *
 */
public class IGSVC0102BLImpl extends BaseBLImpl implements WorkFlowEventHandlerBL{
	/**��־����ȡ��*/
	static Log log = LogFactory.getLog(IGSVC0102BLImpl.class);
	
	/**��������ID*/
	protected final static String QUESPRDID = "01083";

	/**ҵ���������ID*/
	protected final static String SERVICEPRDID = "01101";
	
	/**�Ƽ���������ID*/
	protected final static String TECHPRDID = "01100";
	
	/** ���¹���API�� */
	private FlowSetBL flowSetBL;

    /** ��ѯ�๦��API�� */
    private FlowSearchBL flowSearchBL;
    
    /** ������API��*/
    private FlowOptBL flowOptBL;
	/**
	 * ���¹���API���趨
	 * @param flowSetBL ���¹���API��
	 */
	public void setFlowSetBL(FlowSetBL flowSetBL) {
		this.flowSetBL = flowSetBL;
	}

	/**
	 * ��ѯ�๦��API���趨
	 * @param flowSearchBL ��ѯ�๦��API��
	 */
	public void setFlowSearchBL(FlowSearchBL flowSearchBL) {
		this.flowSearchBL = flowSearchBL;
	}

	/**
	 * ������API���趨
	 * @param flowOptBL ������API��
	 */
	public void setFlowOptBL(FlowOptBL flowOptBL) {
		this.flowOptBL = flowOptBL;
	}

	/**ǰ����*/
	public void preTreatmentExecute(WorkFlowStatusEventBeanInfo bean)
			throws BLException {
		//��ȡ������ID
		Integer mainPrid = this.flowSearchBL.searchProcessRelationForPar(bean.getLogInfo().getPrid());
		
		//�ж��Ƿ����������
		if(mainPrid != null && mainPrid > 0){
			//���������̴��ڶ������������ж�ֻ���ڵ�ǰ���������һ��
			List<Integer> exPridList = flowSearchBL.searchProcessRelationForCld(mainPrid);
			boolean flag = true;
			int num = 1;
			if(exPridList != null && exPridList.size()>0){
				for(Integer exPrid : exPridList){
					List<ProcessRecordInfo> pList = flowSearchBL.searchProcessInfo(exPrid, null);
					if(StringUtils.isEmpty(pList.get(0).getPrclosetime())&&
							StringUtils.isNotEmpty(pList.get(0).getPrpdid())
							&& pList.get(0).getPrpdid().substring(0,5).equals("01102")){
						num++;
					}
				}
			}
			if(num>1){
				flag = false;//���ڶ��������δ���д����
			}
			if(flag){
				//��������id��ȡ���������Ϣ
				List<ProcessRecordInfo> searchInfo = flowSearchBL.searchProcessInfo(mainPrid, null);
				//��ȡ������ID
				String prpdid=searchInfo.get(0).getPrpdid();
				//�ж�������״̬
				List<ProcessStatusInfo> statusList = flowSearchBL.searchCurrentStatus(mainPrid);
				//�ж����������������̡�ҵ��������󡢿Ƽ���������
				if(statusList!=null && ("S".equals(statusList.get(0).getPsdcode())
						|| "Y".equals(statusList.get(0).getPsdcode())
						|| "W".equals(statusList.get(0).getPsdcode()))){
					if(prpdid.contains(QUESPRDID)||prpdid.contains(SERVICEPRDID)||prpdid.contains(TECHPRDID)){
						//ʵ������־����
						WorkFlowLog  mainLogInfo = new WorkFlowLog();
						mainLogInfo.setPrid(mainPrid);
						mainLogInfo.setExecutorid(bean.getLogInfo().getExecutorid());
						mainLogInfo.setExecutorRoleid(bean.getLogInfo().getExecutorRoleid());
						//ʵ�������б�ֵ����
						PublicProcessInfoValue info = new PublicProcessInfoValue(mainLogInfo);
						info.setFormname("�ȴ�����");
						info.setFormvalue("0");
						//�趨���б���Ϣ
						flowSetBL.setPublicProcessInfoValue(info);
						//���ò�����
						StatusParticipant participant = new StatusParticipant(mainLogInfo);
						participant.setStatusname("�ȴ����򿪷�");
						participant.setUserid(bean.getLogInfo().getExecutorid());
						participant.setRoleid(bean.getLogInfo().getExecutorRoleid());
						flowSetBL.setStatusParticipant(participant);
						//����ԾǨ
						flowOptBL.transitionProcess(mainPrid, bean.getLogInfo().getExecutorid(), "���½���", IGStringUtils.getCurrentDateTime());
					}					
				}
			}
		}
		
	}
	
	/**����*/
	public void afterTreatmentExecute(WorkFlowStatusEventBeanInfo bean)
			throws BLException {
	}

}
