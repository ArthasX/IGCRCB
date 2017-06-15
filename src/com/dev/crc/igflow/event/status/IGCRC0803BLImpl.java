/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.dev.crc.igflow.event.status;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.SerializationUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.igflow.api.FlowSearchBL;
import com.deliverik.framework.igflow.api.FlowSetBL;
import com.deliverik.framework.igflow.api.SysManageBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowEventHandlerBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusEventBeanInfo;
import com.deliverik.framework.workflow.prr.bl.task.IG599BL;
import com.deliverik.framework.workflow.prr.model.IG599Info;
import com.deliverik.framework.workflow.prr.model.condition.IG599SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.entity.IG599TB;

/***
 * �ĵ���� �ĵ���ű�ֵ��ʼ��   �������ڵ�ǰ����
 *
 */
public class IGCRC0803BLImpl extends BaseBLImpl implements WorkFlowEventHandlerBL{
	
	/**��־����ȡ��*/
	static Log log = LogFactory.getLog(IGCRC0803BLImpl.class);
	
	/** ���¹���API�� */
	private FlowSetBL flowSetBL;

    /** ��ѯ�๦��API�� */
    private FlowSearchBL flowSearchBL;
    
    /** ���̲�ѯ����API */
    private SysManageBL sysManageBL;
    
    /** ���̱������� */
	private IG599BL ig599BL;

	/**
	 * ���̱��������趨
	 * 
	 * @param ig599bl
	 *            ig599BL
	 */
	public void setIg599BL(IG599BL ig599bl) {
		ig599BL = ig599bl;
	}
    
	/**
	 * ע����¹���API��
	 * 
	 * @param flowSetBL
	 */
	public void setFlowSetBL(FlowSetBL flowSetBL) {
		this.flowSetBL = flowSetBL;
	}

	/**
	 * ע���ѯ����API��
	 * 
	 * @param flowSearchBL
	 */
    public void setFlowSearchBL(FlowSearchBL flowSearchBL) {
        this.flowSearchBL = flowSearchBL;
    }
      
    /**
     * ע�����̲�ѯ����API
     * @param sysManageBL ���̲�ѯ����API
     */
    public void setSysManageBL(SysManageBL sysManageBL) {
		this.sysManageBL = sysManageBL;
	}

	/**
     * ǰ����
     */
	public void preTreatmentExecute(WorkFlowStatusEventBeanInfo bean)
			throws BLException {
		
	}

	/**
	 * ����
	 */
	public void afterTreatmentExecute(WorkFlowStatusEventBeanInfo bean)
			throws BLException {
		
		log.debug("======== �ĵ���� �ĵ���ű�ֵ��ʼ��   �������ڵ�ǰ���� ��ʼ ========");
		
		// ��ȡ��ǰʱ��
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
		String date = formatter.format(new Date());
		String HEAD = "WD";
		//�ĵ���ţ���-��-��-���(2λ)
		//��ȡ���������
		String maxSerialNum = ig599BL.searchMaxSerialnum(date, "�ĵ����");
		//���û�б�Ż��߲����ϸ�ʽ����ʼֵ
		if (null == maxSerialNum || maxSerialNum.length() != 12) {
			maxSerialNum = (HEAD + date + "01").trim();
		}else{
			//��ȡ��ǰ���
			String num = maxSerialNum.substring(10).trim();
			//��ȡ��-��-��
			String numStr = maxSerialNum.substring(2, 10);
			int maxNumber = Integer.valueOf(num) + 1;
			//������ С��10ʱ����
			if(maxNumber < 10){
				maxSerialNum = HEAD + numStr + "0" + maxNumber;
			}else{
				maxSerialNum = HEAD + numStr + maxNumber;
			}
		}
		IG599SearchCondImpl cond = new IG599SearchCondImpl();
		cond.setPrid(bean.getLogInfo().getPrid());
		cond.setPivarname("�ĵ����");
		List<IG599Info> list = ig599BL.searchIG599InfosByCond(cond);
		if(list != null && list.size() > 0){
			IG599TB ig599TB = (IG599TB)SerializationUtils.clone(list.get(0));
			ig599TB.setPivarvalue(maxSerialNum);
			ig599BL.updateIG599Info(ig599TB);
		}

		log.debug("======== �ĵ���� �ĵ���ű�ֵ��ʼ��   �������ڵ�ǰ���� ����========");
	}

}