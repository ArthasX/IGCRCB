/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.dev.crc.igflow.event.status;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.igflow.api.FlowSearchBL;
import com.deliverik.framework.igflow.api.FlowSetBL;
import com.deliverik.framework.igflow.parameter.PublicProcessInfoValue;
import com.deliverik.framework.igflow.resultset.ParticipantInfo;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowEventHandlerBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusEventBeanInfo;

/***
 * �������Ĺ��������ĺ��ô���
 * @time 2014/06/18
 * @author taoye
 * @version 1.0
 * @mail taoye@deliverik.com
 */
public class IGFXK0601BLImpl extends BaseBLImpl implements WorkFlowEventHandlerBL {
	
	static Log log = LogFactory.getLog(IGFXK0601BLImpl.class);
	
	/** ��ѯ��API */
	private FlowSearchBL flowSearchBL;
	
	/** ���̸���API */
	private FlowSetBL flowSetBL;
	
	/**
	 * ��ѯ��API�趨
	 * @param flowSearchBL ��ѯ��API
	 */
	public void setFlowSearchBL(FlowSearchBL flowSearchBL) {
		this.flowSearchBL = flowSearchBL;
	}
	
	/**
	 * ���̸���API�趨
	 * @param flowSetBL ���̸���API
	 */
	public void setFlowSetBL(FlowSetBL flowSetBL) {
		this.flowSetBL = flowSetBL;
	}
	
	/**
	 * ǰ����
	 */
	public void preTreatmentExecute(WorkFlowStatusEventBeanInfo bean)
			throws BLException {		
	}

	/**
	 * ����
	 * ����:
	 *     �������� �Ƿ�ַ��ɽ��и�ֵ�����������Ƿ���Ҫ������ɽڵ�
	 */
	public void afterTreatmentExecute(WorkFlowStatusEventBeanInfo bean)
			throws BLException {
		log.debug("=====================�������Ĺ��������ĺ��ô���ʼ=====================");
		
		/** ��ȡ���ļƻ�ִ�еĲ������б� */
		List<ParticipantInfo> listExe = flowSearchBL.searchStatusParticipant(bean.getLogInfo().getPrid(), "���ļƻ�ִ��");
		
		/** ���б���Ϣ���� */
		PublicProcessInfoValue value = new PublicProcessInfoValue(bean.getLogInfo());
		
		/** ���Ƿ���ɱ���ֵ */
		value.setFormname("�Ƿ����");
		
		/** �ж����ļƻ�ִ�еĲ������б��Ƿ��˲����ˣ�����У�Ϊ�Ƿ����������ֵΪ2����ʾ���÷��ɣ����򣬸�ֵΪ1����ʾ��Ҫ���� */
		if(listExe == null || listExe.isEmpty()){
			/** �����ڲ����ˣ���ֵΪ1 */
			value.setFormvalue("1");
		}else{
			/** ���ڲ����ˣ���ֵΪ2 */
			value.setFormvalue("2");
		}
		
		/** ����Ϣ���� */
		flowSetBL.setPublicProcessInfoValue(value);
		
		log.debug("=====================�������Ĺ��������ĺ��ô������=====================");
	
	}
	
	
}
