/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.dev.crc.igflow.event.button;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.igflow.api.FlowSetBL;
import com.deliverik.framework.igflow.parameter.PublicProcessInfoValue;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusButtonHandlerBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusEventBeanInfo;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ���ñ�����ش���
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IGCRC0404BLImpl implements WorkFlowStatusButtonHandlerBL{
	
	
	/** ��־���� */
	private static final Log log = LogFactory.getLog(IGCRC0404BLImpl.class);
	
	/** ������API */
	protected FlowSetBL flowSetBL;

	/**
	 * ������API�趨
	 * @param flowSetBL ������API
	 */
	public void setFlowSetBL(FlowSetBL flowSetBL) {
		this.flowSetBL = flowSetBL;
	}

	public void statusButtonTreatmentExecute(WorkFlowStatusEventBeanInfo info)
			throws BLException {
		log.debug("============���ñ�ֵ������ʼ============");
		PublicProcessInfoValue value = new PublicProcessInfoValue(info.getLogInfo());
		value.setFormname("���ش���");
		value.setFormvalue("1");
		flowSetBL.setPublicProcessInfoValue(value);
		log.debug("============���ñ�ֵ��������============");
	}

}
