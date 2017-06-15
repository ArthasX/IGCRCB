/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.dev.crc.igflow.event.status;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.igflow.api.FlowSearchBL;
import com.deliverik.framework.igflow.api.FlowSetBL;
import com.deliverik.framework.igflow.parameter.PublicProcessInfoValue;
import com.deliverik.framework.igflow.resultset.ProcessRecordInfo;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowEventHandlerBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusEventBeanInfo;
import com.deliverik.infogovernor.fxk.bl.IGFXK03BLType;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨-���ռƻ�������ڵ㴦��
 * </p>
 * <p>
 * Description: 
 * </p>
 * 
 * @version 1.0
 */
public class IGFXK0301BLImpl extends BaseBLImpl implements WorkFlowEventHandlerBL{
	
	/** ��־���� */
	private static final Log log = LogFactory.getLog(IGFXK0301BLImpl.class);
	
	/** ��ѯ��API */
	protected FlowSearchBL flowSearchBL;
	
	/** ������API */
	protected FlowSetBL flowSetBL;

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

	public void preTreatmentExecute(WorkFlowStatusEventBeanInfo bean)
			throws BLException {
		
	}

	/**
	 * ����
	 */
	public void afterTreatmentExecute(WorkFlowStatusEventBeanInfo bean)
			throws BLException {
		log.debug("==============���ռƻ�������ڵ����ɼƻ���Ų�����ʼ==============");
		//��ȡ��������
		Integer prid = bean.getLogInfo().getPrid();
		//��ȡ�����Ϣ
		String number = flowSearchBL.searchPublicProcessInfo(prid, "�ƻ����");
		
		//���ƻ���Ų�����ʱ
		if(StringUtils.isEmpty(number)){
			//��ȡ��ǰ����
			String nowDate = IGStringUtils.getCurrentDate();
			//��ѯ���ռƻ����췢�������
			StringBuffer startTime = new StringBuffer();
			startTime.append(nowDate).append(" 00:00");
			List<ProcessRecordInfo> lst_process = flowSearchBL.searchProcessInfo(IGFXK03BLType.PROCESS_RISK_PDID, startTime.toString(), null);
			if(lst_process != null ){
				//����ǰ���̴Ӳ�ѯ�������̼������Ƴ�
				for (ProcessRecordInfo processRecord : lst_process) {
					if(processRecord.getPrid().equals(prid)){
						lst_process.remove(processRecord);
						break;
					}
				}
			}
			//���ɷ��ռƻ����
			StringBuffer riskNum = new StringBuffer();
			riskNum.append("PL");
			riskNum.append(IGStringUtils.getCurrentDate().replaceAll("/", ""));
			if(lst_process != null ){
				//���ɱ��ʱ���ж��Ƿ���Ҫ�ڱ��ǰ����0��
				if(lst_process.size() > 8){
					riskNum.append(lst_process.size() + 1);
				}else{
					riskNum.append("0").append(lst_process.size()+1);
				}
			}else{
				riskNum.append("01");
			}
			
			//ʵ������ֵ����
			PublicProcessInfoValue value = new PublicProcessInfoValue(bean.getLogInfo());
			value.setFormname("�ƻ����");
			value.setFormvalue(riskNum.toString());
			//���ñ�ֵ
			flowSetBL.setPublicProcessInfoValue(value);
		}
		
		
		log.debug("==============���ռƻ�������ڵ����ɼƻ���Ų�������==============");
	}

}
