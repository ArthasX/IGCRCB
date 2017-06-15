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
import com.deliverik.framework.igflow.api.FlowOptBL;
import com.deliverik.framework.igflow.api.FlowSearchBL;
import com.deliverik.framework.igflow.api.FlowSetBL;
import com.deliverik.framework.igflow.parameter.PublicProcessInfoValue;
import com.deliverik.framework.igflow.parameter.WorkFlowLog;
import com.deliverik.framework.igflow.resultset.ProcessRecordInfo;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowEventHandlerBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusEventBeanInfo;
/**
 * �������� - ����������̷��� �趨�ȴ����� ��ֵ
 * @author zhangqiang
 *
 */
public class IGSVC0101BLImpl extends BaseBLImpl implements WorkFlowEventHandlerBL{
	/**��־����ȡ��*/
	static Log log = LogFactory.getLog(IGSVC0101BLImpl.class);
	
	/**��������ID*/
	protected final static String QUESPRDID = "01083";
	
	/**��������ID*/
	protected final static String SERVICEPRDID = "01101";
	/**�Ƽ���������ID*/
	protected final static String TECHPRDID = "01100";
	
	/** ���¹���API�� */
	private FlowSetBL flowSetBL;

    /** ��ѯ�๦��API�� */
    private FlowSearchBL flowSearchBL;
    
    /**
	 * ��ѯ�๦��API���趨
	 * @param flowSearchBL ��ѯ�๦��API��
	 */
	public void setFlowSearchBL(FlowSearchBL flowSearchBL) {
		this.flowSearchBL = flowSearchBL;
	}

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
	 * ������API���趨
	 * @param flowOptBL ������API��
	 */
	public void setFlowOptBL(FlowOptBL flowOptBL) {
		this.flowOptBL = flowOptBL;
	}

	/**ǰ����*/
	public void preTreatmentExecute(WorkFlowStatusEventBeanInfo bean)
			throws BLException {
		
		
	}
	
	/**����*/
	public void afterTreatmentExecute(WorkFlowStatusEventBeanInfo bean)
			throws BLException {
		//��ȡ������
		Integer mainPrid = this.flowSearchBL.searchProcessRelationForPar(bean.getLogInfo().getPrid());
		
		if(mainPrid != null && mainPrid > 0){
			List<ProcessRecordInfo> searchInfo = flowSearchBL.searchProcessInfo(mainPrid, null);
			//ʵ������־����
			WorkFlowLog  mainLogInfo = new WorkFlowLog();
			mainLogInfo.setPrid(mainPrid);
			mainLogInfo.setExecutorid(bean.getLogInfo().getExecutorid());
			mainLogInfo.setExecutorRoleid(bean.getLogInfo().getExecutorRoleid());
			//��ȡ������ID
			String prpdid=searchInfo.get(0).getPrpdid();
			if(prpdid.contains(QUESPRDID)||prpdid.contains(SERVICEPRDID)||prpdid.contains(TECHPRDID)){
				//ʵ�������б�ֵ����
				PublicProcessInfoValue info = new PublicProcessInfoValue(mainLogInfo);
				info.setFormname("�ȴ�����");
				info.setFormvalue("1");
			    //�趨���б���Ϣ
				flowSetBL.setPublicProcessInfoValue(info);
				//�ж�����������������
				if(prpdid.contains(QUESPRDID)){
					//����ԾǨ
					flowOptBL.transitionProcess(mainPrid, bean.getLogInfo().getExecutorid(), "�������", IGStringUtils.getCurrentDateTime());
				//�ж���������ҵ�������������ǿƼ���������	
				}else if (prpdid.contains(SERVICEPRDID)||prpdid.contains(TECHPRDID)){
					//����ԾǨ
					flowOptBL.transitionProcess(mainPrid, bean.getLogInfo().getExecutorid(), "������֤", IGStringUtils.getCurrentDateTime());
				}
			}
		}		
	}

}
